package com.sz.zhiling.controller;

import com.alibaba.fastjson.JSON;
import com.sz.zhiling.dao.ConferenceDao;
import com.sz.zhiling.entity.Conference;
import com.sz.zhiling.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/selconference")
public class SelConferenceServlet extends HttpServlet {
    ConferenceDao conferenceDao = new ConferenceDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int serialId = Integer.parseInt(request.getParameter("serialId"));
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(conferenceDao.selConferenceBySerialId(serialId)));
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String p = request.getParameter("pageno");
        int pageno = (p==null||"".equals(p))?1:Integer.parseInt(p);
        Page<Conference> page = conferenceDao.selPage(pageno);
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(page));
        out.flush();
        out.close();
    }
}
