package com.sz.ccms.controller;

import com.alibaba.fastjson.JSON;
import com.sz.ccms.utils.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
    @RequestMapping("/goLogin")
    public ModelAndView goLogin(){
        return new ModelAndView("/login");
    }
    @RequestMapping("/goMain")
    public ModelAndView goMain(){
        return new ModelAndView("/main");
    }

    @RequestMapping("/login")
    public String login(String account,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        try {
            //登录认证(调用MyRealm)
            subject.login(token);
        }catch (IncorrectCredentialsException e){
            //登陆失败
            return JSON.toJSONString(new ResultBean("失败"));
        }
        return "redirect:goMain";
    }
}
