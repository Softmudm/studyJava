package com.sz.wx.controller;

import com.alibaba.fastjson.JSON;
import com.sz.wx.model.User;
import com.sz.wx.service.UserService;
import com.sz.wx.util.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public Info login(@RequestBody User user, HttpServletRequest request){
        User u = userService.getUserByNameAndPwd(user);
        Info info = null;
        if(u!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            info = new Info("登录成功！",1,true);
        }else {
            info = new Info("登录失败！账号密码不匹配！",2,false);
        }
        return info;
    }

    @RequestMapping("/regist")
    public Info regist(@RequestBody User user, HttpServletRequest request){
        int flag = userService.addUser(user);
        Info info = null;
        if(flag==1) {
            info = new Info("注册成功！",1,true);
        }else {
            info = new Info("注册失败！",2,false);
        }
        return info;
    }
}
