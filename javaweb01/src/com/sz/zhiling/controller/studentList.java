package com.sz.zhiling.controller;

import com.sz.zhiling.service.studentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentList")
public class studentList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了studentList的doGet方法");
        req.setAttribute("list",new studentService().selectAllStudent());
        req.getRequestDispatcher("studentList.jsp").forward(req,resp);
    }
}