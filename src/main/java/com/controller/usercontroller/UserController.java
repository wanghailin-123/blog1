package com.controller.usercontroller;


import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @RequestMapping("logandreg")
    public  String registered(){
        return "logandreg";
    }
    //登陆界面
    @RequestMapping("Mysign_in")
    public String Mysign(){

        return "logandreg";
    }

    @RequestMapping("log")
    public String log(){

        return "log";
    }

    @RequestMapping("addaa")
    public String addaa(HttpSession session){
        session.getAttribute("islog");
        return "personal_blog";
    }
}
