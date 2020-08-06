package com.sz.test.controller;

import com.sz.test.modal.Conference;
import com.sz.test.service.ConferenceService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addconference")
public class AddConferenceServlet extends HttpServlet {
    public AddConferenceServlet() {
        System.out.println("调用add无参构造方法");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassPathXmlApplicationContext apxac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConferenceService conferenceService = (ConferenceService) apxac.getBean("conferenceServiceImpl");
        System.out.println("add的"+conferenceService);
        int pageno = Integer.parseInt(request.getParameter("pageNum"));
        String msg = "{\"pageNo\":"+pageno;
        Conference conference = new Conference(
                request.getParameter("conferenceId"),
                request.getParameter("conferenceName"),
                request.getParameter("conferenceAddr"),
                Integer.parseInt(request.getParameter("conferenceSize")));
        int flag = conferenceService.addConference(conference);
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
