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

@WebServlet("/delconference")
public class DelConferenceServlet extends HttpServlet {
    private ConferenceDao conferenceDao = new ConferenceDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int serialId = Integer.parseInt(request.getParameter("serialId"));
        int pageno = Integer.parseInt(request.getParameter("pageno"));
        int flag = conferenceDao.delConference(serialId);
        Page<Conference> page = conferenceDao.selPage(pageno);
        if(page.getData().size()==0 && pageno>1){
            request.setAttribute("page",conferenceDao.selPage(pageno-1));
        }else{
            request.setAttribute("page",page);
        }
        request.getRequestDispatcher("/test.jsp").forward(request,response);
        /*PrintWriter out = response.getWriter();
        Page<Conference> page = conferenceDao.selPage(pageno);
        if(page.getData().size()==0 && pageno>1){
            out.print(JSON.toJSONString(conferenceDao.selPage(pageno-1)));
        }else{
            out.print(JSON.toJSONString(page));
        }
        out.flush();
        out.close();*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
