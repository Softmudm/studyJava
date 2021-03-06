package com.sz.zhiling.controller;

import com.sz.zhiling.dao.ConferenceDao;
import com.sz.zhiling.entity.Conference;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateconference")
public class UpdateConferenceServlet extends HttpServlet {
    private ConferenceDao conferenceDao = new ConferenceDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Conference conference = new Conference(
                Integer.parseInt(request.getParameter("serialId")),
                request.getParameter("conferenceId"),
                request.getParameter("conferenceName"),
                request.getParameter("conferenceAddr"),
                Integer.parseInt(request.getParameter("conferenceSize")));
        int flag = conferenceDao.updateConference(conference);
        if(flag==1){
            response.sendRedirect("/selconference");
        }else{
            request.setAttribute("msg","修改失败！");
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
