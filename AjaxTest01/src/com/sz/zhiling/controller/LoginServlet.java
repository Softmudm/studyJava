package com.sz.zhiling.controller;

import com.sz.zhiling.dao.UserDao;
import com.sz.zhiling.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置写入响应包中时的编码
        resp.setCharacterEncoding("utf-8");
        //设置响应头中的contentType，用来控制浏览器解析时使用的解析器
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String userpwd = req.getParameter("userpwd");
        User user = userDao.selUserByName(username);
        if(user!=null && user.getUserpwd().equals(userpwd)){
            //返回json格式字符串
            resp.getWriter().print("{\"s\":true}");
        }else{
            resp.getWriter().print("{\"s\":false}");
        }
    }
}
