package com.sz.wx.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器，请求地址:"+request.getRequestURI());
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null){
            request.getRequestDispatcher("/login.html").forward(request,response);
        }
        return true;
    }
}
