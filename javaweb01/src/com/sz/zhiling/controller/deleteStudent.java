package com.sz.zhiling.controller;

import com.sz.zhiling.service.studentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteStudent")
public class deleteStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuid = req.getParameter("stuid");
        System.out.println(stuid);
        new studentService().deleteStudentById(stuid);
        resp.sendRedirect("http://localhost:8080/test01/studentList");
    }
}
