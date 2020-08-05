package com.sz.meituan.servlets;

import com.sz.meituan.dao.UserDao;
import com.sz.meituan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userpwd = req.getParameter("userpwd");
        HttpSession session = req.getSession();
        String uri = (String) session.getAttribute("uri");
        User user = userDao.selUserByNameAndPwd(username,userpwd);
        String msg ="";
        if(user!=null){
            session.setAttribute("user",user);
            if("/login".equals(uri)){
                resp.sendRedirect("/food");
            }else{
                resp.sendRedirect(uri);
            }
        }else{
            msg="账号密码不匹配！";
            req.setAttribute("msg",msg);
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
