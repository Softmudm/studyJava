package com.sz.wx.interceptor;

import com.sz.wx.util.JWTUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        System.out.println("进入拦截器，请求地址:"+request.getRequestURI());
        String token = request.getHeader("token");
        System.out.println(uri.substring(uri.length()-5));
        if(".html".equals(uri.substring(uri.length()-5))){
            Cookie[] cookie = request.getCookies();
            if(cookie!=null){
                for (Cookie cookie1 : cookie) {
                    if("token".equals(cookie1.getName())){
                        token = cookie1.getValue();
                    }
                }
            }
        }
        try {
            Claims claims = JWTUtil.parseJwt(token);
        }catch(ExpiredJwtException expiredJwtException){
            System.out.println("token已过期！");
        }catch (Exception exception){
            response.sendRedirect("/login.html");
            return false;
        }
        return true;
    }
}
