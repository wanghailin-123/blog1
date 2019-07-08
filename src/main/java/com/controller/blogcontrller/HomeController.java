package com.controller.blogcontrller;

import com.pojo.Article;
import com.service.articleservice.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ArticleServiceImpl articleService;
//    @Autowired
//    HttpSession session;
    @RequestMapping("/")
    public String homePage(HttpSession session){
//        获取全部文章
        List<Article> articleAll = articleService.getArticleAll();
//        获取点击量前三的文章
        List<Article> articleTop3 = articleService.getArticleTop3();
        session.setAttribute("article",articleAll);
        session.setAttribute("articleTop3",articleTop3);
        return "home";
    }
}
