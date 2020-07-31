package com.sz.zhiling.controller;

import com.sz.zhiling.dao.ConferenceDao;
import com.sz.zhiling.entity.Conference;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateconference")
public class UpdateConferenceServlet extends HttpServlet {
    private ConferenceDao conferenceDao = new ConferenceDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageno = Integer.parseInt(request.getParameter("pageNum"));
        String msg = "{\"pageNo\":"+pageno;
        Conference conference = new Conference(
                Integer.parseInt(request.getParameter("serialId")),
                request.getParameter("conferenceId"),
                request.getParameter("conferenceName"),
                request.getParameter("conferenceAddr"),
                Integer.parseInt(request.getParameter("conferenceSize")));
        int flag = conferenceDao.updateConference(conference);
        if(flag==1){
            msg = msg+",\"s\":true}";
        }else{
            msg = msg+",\"s\":false}";
        }
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(msg);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
