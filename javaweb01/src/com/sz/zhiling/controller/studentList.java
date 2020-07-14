package com.sz.zhiling.controller;

import com.sz.zhiling.dao.studentDao;
import com.sz.zhiling.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/studentList")
public class studentList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了studentList的doGet方法");
//        req.setAttribute("list",new studentDao().selectAllStudent());
        String keyword = req.getParameter("keyword");
        keyword = keyword==null?"":keyword;
        List<Student> list = new studentDao().selectStudent(keyword);
        req.setAttribute("list",list);
        req.getRequestDispatcher("studentList.jsp").forward(req,resp);
    }
}