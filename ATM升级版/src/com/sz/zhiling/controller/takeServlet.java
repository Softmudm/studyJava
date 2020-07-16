package com.sz.zhiling.controller;

import com.sz.zhiling.dao.BankCardDao;
import com.sz.zhiling.entity.BankCard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/takeServlet")
public class takeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float money = Float.parseFloat(request.getParameter("takemoney"));
        String cardid = request.getParameter("cardid");
        BankCardDao bcd = new BankCardDao();
        BankCard bc = bcd.selectBCById(cardid);
        float m = bc.getBalance()-money;
        if(m>0){
            bc.setBalance(m);
            if(bcd.updateBankCardById(bc)==1){
                request.setAttribute("bankCard",bc);
                request.setAttribute("msg","取款"+money+"成功！");
                request.getRequestDispatcher("mainpage.jsp").forward(request,response);
            }else{
                bc.setBalance(m+money);
                request.setAttribute("bankCard",bc);
                request.setAttribute("msg","取款失败！");
                request.getRequestDispatcher("mainpage.jsp").forward(request,response);
            }
        }else{
            request.setAttribute("bankCard",bc);
            request.setAttribute("msg","余额不足！");
            request.getRequestDispatcher("mainpage.jsp").forward(request,response);
        }
    }
}
