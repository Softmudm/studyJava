package com.sz.zhiling.controller;

import com.sz.zhiling.dao.CompanyDao;
import com.sz.zhiling.entity.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelComServlet")
public class SelComServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CompanyDao companyDao = new CompanyDao();
        String comname = request.getParameter("comname");
        String mastername = request.getParameter("mastername");
        comname = comname==null?"":comname;
        mastername = mastername==null?"":mastername;
        List<Company> comlist = companyDao.selComByComOrMaster(comname,mastername);
        request.setAttribute("comlist",comlist);
        request.getRequestDispatcher("company.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
