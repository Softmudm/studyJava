package com.sz.zhiling.controller;

import com.sz.zhiling.dao.ConferenceDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selconference")
public class SelConferenceServlet extends HttpServlet {
    ConferenceDao conferenceDao = new ConferenceDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String p = request.getParameter("pageno");
        int pageno = p==null?1:Integer.parseInt(p);
        request.setAttribute("page",conferenceDao.selPage(pageno));
        request.getRequestDispatcher("conferencelist.jsp").forward(request,response);
    }
}
