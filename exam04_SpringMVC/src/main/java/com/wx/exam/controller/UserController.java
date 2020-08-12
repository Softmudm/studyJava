package com.wx.exam.controller;

import com.alibaba.fastjson.JSON;
import com.wx.exam.model.User;
import com.wx.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    //去登陆页面
    @RequestMapping("/gologin")
    public String gologin(Model model){
        return "login";
    }
    //登录方法
    @RequestMapping("/login")
    public String login(String uname, String upwd, Model model, HttpServletRequest request){
        User user = userService.getUser(uname,upwd);
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return "forward:/remark/getRemarkList.do";
        }else{
            model.addAttribute("msg","账号密码不匹配，登陆失败！请重新输入！");
            return "login";
        }
    }
    //验证
    @RequestMapping("/verifyUser")
    @ResponseBody
    public String verifyUser(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "{\"m\":false}";
        }
        return "{\"m\":true,\"uid\":\""+user.getUid()+"\",\"uname\":\""+user.getUname()+"\"}";
    }

}
