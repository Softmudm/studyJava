package com.sz.zhiling.controller;

import com.sz.zhiling.dao.BankCardDao;
import com.sz.zhiling.entity.BankCard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pwd = request.getParameter("newpwd1");
        BankCardDao bankCardDao = new BankCardDao();
        BankCard bankCard = bankCardDao.selectBCById(String.valueOf(request.getSession().getAttribute("cardid1")));
        bankCard.setCardpwd(pwd);
        bankCardDao.updateBankCardById(bankCard);
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
}
