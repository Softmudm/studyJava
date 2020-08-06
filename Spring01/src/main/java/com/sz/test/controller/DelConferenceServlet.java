package com.sz.test.controller;


import com.alibaba.fastjson.JSON;
import com.sz.test.modal.Conference;
import com.sz.test.service.ConferenceService;
import com.sz.test.util.Page;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delconference")
public class DelConferenceServlet extends HttpServlet {
    private static ConferenceService conferenceService;
    static {
        ClassPathXmlApplicationContext apxac = new ClassPathXmlApplicationContext("applicationContext.xml");
        conferenceService = (ConferenceService) apxac.getBean("conferenceServiceImpl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int serialId = Integer.parseInt(request.getParameter("serialId"));
        int pageno = Integer.parseInt(request.getParameter("pageno"));
        int flag = conferenceService.delConference(serialId);
        Page<Conference> page = conferenceService.selPage(pageno);
        if(page.getData().size()==0 && pageno>1){
            page = conferenceService.selPage(pageno-1);
        }
        if(flag==1){
            page.setS(true);
        }else{
            page.setS(false);
        }
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(page));
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
