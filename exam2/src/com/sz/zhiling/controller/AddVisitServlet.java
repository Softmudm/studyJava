package com.sz.zhiling.controller;

import com.sz.zhiling.dao.VisitDao;
import com.sz.zhiling.entity.Visit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/AddVisitServlet")
public class AddVisitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VisitDao visitDao = new VisitDao();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date vdate = null;
        int comid = Integer.parseInt(request.getParameter("comid"));
        try {
            vdate = sdf.parse(request.getParameter("vdate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Visit visit = new Visit(0,
                request.getParameter("vname"),
                vdate,
                request.getParameter("vtype"),
                request.getParameter("vresult"),
                request.getParameter("vmethod"),
                comid);
        System.out.println(visit);
        visitDao.addVisit(visit);
        response.sendRedirect("/SelVisitServlet?comid="+comid);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
