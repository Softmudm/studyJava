package com.sz.zhiling.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(req.getRemoteAddr());
        HttpServletRequest request = (HttpServletRequest) req;
        req.setCharacterEncoding("utf-8");
        String url = request.getRequestURI();
        if(url.contains("login")||"/".equals(url)||url.contains("bootstrap")){
            chain.doFilter(req,resp);
        }else{
            HttpSession session = request.getSession(false);
            System.out.println(session);
            if(session==null){
                resp.setContentType("text/html;charset=UTF-8");
                PrintWriter out = resp.getWriter();
                out.print("<img style='height: 700px;float: left' src='img/1.gif'>" +
                        "<img style='height: 700px;float: right' src='img/2.gif'>");
                out.flush();
                out.close();
            }else{
                chain.doFilter(req,resp);
            }
        }
        /*if("0:0:0:0:0:0:0:1".equals(req.getRemoteAddr())||"127.0.0.1".equals(req.getRemoteAddr())||"/img/1.gif".equals(request.getRequestURI())||"/img/2.gif".equals(request.getRequestURI())){
            chain.doFilter(req,resp);
        }else {
            resp.setContentType("text/html;charset=utf-8");

        }*/
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
