package com.sz.zhiling.controller;

import com.sz.zhiling.dao.BankCardDao;
import com.sz.zhiling.entity.BankCard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cardid = request.getParameter("cardid");
        BankCardDao bcd = new BankCardDao();
        BankCard bankCard = bcd.selectBCById(cardid);
        boolean flag = false;
        if(bankCard != null) {
            if (bankCard.getCardpwd().equals(request.getParameter("cardpwd"))) {
                flag = true;
            }
        }
        if(flag){
            request.getSession().setAttribute("cardid1",cardid);
            request.setAttribute("bankCard",bankCard);
            request.setAttribute("msg","登录成功");
            request.getRequestDispatcher("mainpage.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","账号或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
