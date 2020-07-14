package com.sz.zhiling.controller;

import com.sz.zhiling.dao.studentDao;
import com.sz.zhiling.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudent")
public class addStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("正在调用增加学生方法");
        req.setCharacterEncoding("utf-8");
        Student student = new Student(
                req.getParameter("stuid"),
                req.getParameter("stuname"),
                Integer.parseInt(req.getParameter("age")),
                req.getParameter("stusex"));
        System.out.println(student);
        new studentDao().addStudent(student);
        resp.sendRedirect("http://localhost:8080/test01/studentList");
    }
}
