package com.sz.zhiling.controller;

import com.sz.zhiling.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUserServlet")
public class deleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("userid");
        String ids = request.getParameter("userids");
        UserDao userDao = new UserDao();
        if(id!=null && id!=""){//单个删除
            userDao.deleteUser(Integer.parseInt(id));
            System.out.println(request.getRemoteAddr()+"删除了"+id);
        }else{
            userDao.deleteUsers(ids);
            System.out.println(request.getRemoteAddr()+"删除了"+ids);
        }
        request.getRequestDispatcher("selectUserServlet").forward(request,response);
    }
}
