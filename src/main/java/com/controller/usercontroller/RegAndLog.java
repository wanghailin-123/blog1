package com.controller.usercontroller;

import com.pojo.User;
import com.service.userservice.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class RegAndLog {
    @Autowired
    UserServiceImpl UserService;
    //用户注册
    @RequestMapping("reguser")
    public String reguser(String username,String password, String email, HttpSession model ){
//        获取前端传入的值，封装成user对象并向数据库添加用户
        User user = new User(username,password,email);
//        判断该用户名是否被注册，若查询结果为空，则表示该用户名未被注册
            if(UserService.getUser(user)==null) {
//                受影响行数大于零，说明添加成功，否则注册失败
                if(UserService.addUser(user)>0){
                    model.setAttribute("msg","注册成功！");
                    return "logandreg";
                }else{
                    model.setAttribute("msg","注册失败！");
                    return "log";
                }
            }else {
                model.setAttribute("msg","用户名已注册");
                return "log";
            }
    }

    //用户登陆
    @RequestMapping("loguser")
    public String loguser(@RequestParam("username") String username,@RequestParam("password") String password, HttpSession session){
        System.out.println(1111111);
        User user = new User(username,password,null);
//        验证用户名和密码是否匹配
        System.out.println(user.toString());
        if (!UserService.getUserNameAndPassword(user)){
            session.setAttribute("username",user.getUsername());
            System.out.println(1);
            return "home";
        }else{
            session.setAttribute("msg","用户名或密码错误");
            System.out.println(2);
            return "log";
        }
    }
}
