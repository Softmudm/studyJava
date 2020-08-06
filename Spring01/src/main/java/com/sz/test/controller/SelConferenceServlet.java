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

@WebServlet("/selconference")
public class SelConferenceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassPathXmlApplicationContext apxac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConferenceService conferenceService = (ConferenceService) apxac.getBean("conferenceServiceImpl");
        int serialId = Integer.parseInt(request.getParameter("serialId"));
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(conferenceService.selConferenceBySerialId(serialId)));
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassPathXmlApplicationContext apxac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConferenceService conferenceService = (ConferenceService) apxac.getBean("conferenceServiceImpl");
        response.setContentType("text/html;charset=utf-8");
        String p = request.getParameter("pageno");
        int pageno = (p==null||"".equals(p))?1:Integer.parseInt(p);
        Page<Conference> page = conferenceService.selPage(pageno);
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(page));
        out.flush();
        out.close();
    }
}
