package com.sz.meituan.servlets;

import com.sz.meituan.dao.UserDao;
import com.sz.meituan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registe")
public class RegisteServlet extends HttpServlet {
    private UserDao userDao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用来设置写入到请求头的编码格式
        response.setCharacterEncoding("utf-8");
        //这是在请求头的contentType中指定浏览器使用什么格式解析数据
        //response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        User user = userDao.selUserByName(username);
        //该用户名没有使用
        if(user == null){
            //response.getWriter().print("{\"msg\":\"<span style='color: green;'>该用户名可以注册！</span>\"}");
            response.getWriter().print("<span style='color: green;'>该用户名可以注册！</span>");
        }else{//用户名已使用
            //response.getWriter().print("{\"msg\":\"<span style='color: red;'>该用户名已被使用！</span>\"}");
            response.getWriter().print("<span style='color: red;'>该用户名已被使用！</span>");
        }
    }
}
