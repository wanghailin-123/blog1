package com.controller.blogcontrller;

import com.pojo.Article;
import com.pojo.Comment;
import com.service.articleservice.ArticleServiceImpl;

import com.service.commentservice.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 文章详情界面
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleService;
    @Autowired
    private CommentServiceImpl commentService;

    @RequestMapping("article")
    public String essay(@RequestParam("tid")int tid, Model model, HttpSession session){
        //后台修改访问数量
        articleService.setArticleReadcountById(tid);
//        通过文章id获取全部的评论
        List<Comment> commentById = commentService.getCommenntById(tid);
        Article article = articleService.getArticleById(tid);
        System.out.println(commentById);
        //model.addAttribute("tid",tid);
        session.setAttribute("tid",tid);
        //每次渲染生成文章详情界面后
        session.setAttribute("comment",commentById);
        model.addAttribute("article",article);
        return "article";
    }

    @RequestMapping("comment")
    @ResponseBody
    public boolean comment(@RequestParam("content") String content, HttpSession session){
        Integer tid = (Integer) session.getAttribute("tid");
        String username = (String)session.getAttribute("username");
        Comment comment = new Comment(content,tid,username);
//        设置文章的评论条数
        articleService.setArticleCommentcountById(tid);
        Integer integer = commentService.addCommennt(comment);
        if (integer>0){
            return true;
        }else{
            return false;
        }
    }
}
