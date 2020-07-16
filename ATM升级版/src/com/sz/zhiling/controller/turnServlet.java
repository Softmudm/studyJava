package com.sz.zhiling.controller;

import com.sz.zhiling.dao.BankCardDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/turnServlet")
public class turnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cardid2 = request.getParameter("cardid2");
        Float turnmoney = Float.valueOf(request.getParameter("turnmoney"));
        BankCardDao bankCardDao = new BankCardDao();
        String cardid1 = String.valueOf(request.getSession().getAttribute("cardid1"));
        String msg = bankCardDao.turnMoney(cardid1,cardid2,turnmoney);
        request.setAttribute("bankCard",bankCardDao.selectBCById(cardid1));
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("mainpage.jsp").forward(request,response);
    }
}
