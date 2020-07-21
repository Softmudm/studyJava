package com.sz.zhiling.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if("wx".equals(request.getParameter("account"))&&"123".equals(request.getParameter("password"))){
            HttpSession session = request.getSession();
            System.out.println(session);
            request.getRequestDispatcher("/selectUserServlet").forward(request,response);
        }else{
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print("<img style='height: 700px;float: left' src='img/1.gif'>" +
                    "<img style='height: 700px;float: right' src='img/2.gif'>");
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
