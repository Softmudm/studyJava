package com.sz.zhiling.controller;

import com.sz.zhiling.dao.UserDao;
import com.sz.zhiling.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUserServlet")
public class addUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        request.setCharacterEncoding("utf-8");
        User user = new User(request.getParameter("username"),Integer.parseInt(request.getParameter("roleid")));
        userDao.addUser(user);
        System.out.println(request.getRemoteAddr()+"添加了用户"+user);
        response.sendRedirect("http://localhost:8080/selectUserServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
