package com.sz.zhiling.controller;

import com.sz.zhiling.dao.LikeDao;
import com.sz.zhiling.dao.UserDao;
import com.sz.zhiling.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUserServlet")
public class updateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        LikeDao likeDao = new LikeDao();
        request.setCharacterEncoding("utf-8");
        User user = new User(Integer.parseInt(request.getParameter("userid")),request.getParameter("username"),Integer.parseInt(request.getParameter("roleid")));
        userDao.updateUser(user);
        int userid = user.getUserid();
        likeDao.deleteUserAndLike(userid);
        String[] ids = request.getParameterValues("likeid");
        for (String id : ids) {
            likeDao.addUserLike(userid,Integer.parseInt(id));
        }
        System.out.println(request.getRemoteAddr()+"修改了用户"+user);
        request.getRequestDispatcher("selectUserServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
