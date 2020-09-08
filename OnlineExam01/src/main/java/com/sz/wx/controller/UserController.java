package com.sz.wx.controller;

import com.alibaba.fastjson.JSON;
import com.sz.wx.model.User;
import com.sz.wx.service.UserService;
import com.sz.wx.util.Info;
import com.sz.wx.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /*
     *这里使用jwt进行身份验证，产生的token放在cookie中
     * 1.放在LocalStorage中容易遭受xss攻击
     * 2.放在cookie中直接提交容易受到csrf攻击，所以在提交时使用js从cookie中取出token提交。
     */
    @RequestMapping("/login")
    public Info login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response){
        User u = userService.getUserByNameAndPwd(user);
        Info info = null;
        if(u!=null) {
            Map<String,Object> uinfo = new HashMap<>();
            uinfo.put("userid",u.getUserid());
            uinfo.put("username",u.getUsername());
            Cookie cookie = new Cookie("token",JWTUtil.createJwt(uinfo));
            //webapp下的所有应用共享cookie
            cookie.setPath("/");
            //跨域共享的方法
            //cookie.setDomain(".jszx.com");
            response.addCookie(cookie);
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
