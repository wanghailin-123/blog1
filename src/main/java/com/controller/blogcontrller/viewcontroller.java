package com.controller.blogcontrller;

import com.pojo.Article;
import com.pojo.messagetext;
import com.service.articleservice.ArticleServiceImpl;
import com.service.messagetextservice.MessagetextServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class viewcontroller {
    @Autowired
    ArticleServiceImpl articleService;

    @Autowired
    MessagetextServiceImpl messagetextService;

    @Autowired
    HttpSession session;

    @RequestMapping("add")
    public String addarticle(String title,String content,String type,HttpSession model){

        Article article = new Article( title,content,null,type,null);
        article.setAuthor((String) session.getAttribute("username"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        article.setDate(df.format(new Date()));
        if (articleService.addArticle(article)>0){
            model.setAttribute("msg","发表成功");
            return "personal_blog";
        }else {
            model.setAttribute("msg","发表失败了哦。。");
            return "home";
        }

    }

    /**
     * 留言时间升序
     * @param model
     * @return
     */
    @RequestMapping("mes")
    public String messageboard( Model model){
        List<messagetext> messageTextByDateAsc = messagetextService.getMessageTextByDateAsc();
        model.addAttribute("MsgList",messageTextByDateAsc);
        return "MessageBoard";
    }


    /**
     * 留言时间降序
     * @param model
     * @return
     */
    @RequestMapping("mesDesc")
    public String messageboardDesc( Model model){
        List<messagetext> messageTextByDateDesc = messagetextService.getMessageTextByDateDesc();
        model.addAttribute("MsgList",messageTextByDateDesc);
        return "MessageBoard";
    }

    @RequestMapping("addMes")
    @ResponseBody
    public boolean messageboard1(String messagecontent,HttpSession session){
        messagetext message = new messagetext();
        message.setMessagecontext(messagecontent);
        message.setWriter((String) session.getAttribute("username"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        message.setMessagedate(df.format(new Date()));
        if(messagetextService.addMessagetext(message)){
//            System.out.println(1111111);
            return true;
        }else {
            return false;
        }
    }
}
