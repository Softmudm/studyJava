package com.sz.zhiling.controller;

import com.sz.zhiling.dao.BankCardDao;
import com.sz.zhiling.entity.BankCard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saveServlet")
public class saveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float money = Float.parseFloat(request.getParameter("savemoney"));
        String cardid = request.getParameter("cardid");
        BankCardDao bcd = new BankCardDao();
        BankCard bc = bcd.selectBCById(cardid);
        bc.setBalance(bc.getBalance()+money);
        if (bcd.updateBankCardById(bc)==1){
            request.setAttribute("bankCard",bc);
            request.setAttribute("msg","存款"+money+"成功！");
            request.getRequestDispatcher("mainpage.jsp").forward(request,response);
        }else{
            bc.setBalance(bc.getBalance()-money);
            request.setAttribute("bankCard",bc);
            request.setAttribute("msg","存款失败！");
            request.getRequestDispatcher("mainpage.jsp").forward(request,response);
        }
    }
}
