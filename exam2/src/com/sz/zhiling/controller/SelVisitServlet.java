package com.sz.zhiling.controller;

import com.sz.zhiling.dao.VisitDao;
import com.sz.zhiling.entity.Visit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelVisitServlet")
public class SelVisitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VisitDao visitDao = new VisitDao();
        List<Visit> visitlist = visitDao.selVisitByComid(Integer.parseInt(request.getParameter("comid")));
        request.setAttribute("visitlist",visitlist);
        request.getRequestDispatcher("visit.jsp").forward(request,response);
    }
}
