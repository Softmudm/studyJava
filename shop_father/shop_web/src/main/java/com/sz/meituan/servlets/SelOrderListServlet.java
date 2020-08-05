package com.sz.meituan.servlets;

import com.sz.meituan.dao.OrderDao;
import com.sz.meituan.model.Order;
import com.sz.meituan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderlist")
public class SelOrderListServlet extends HttpServlet {
    private OrderDao orderDao = new OrderDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userid = 0;
        if(user!=null){
            userid = user.getUserid();
        }
        List<Order> list = orderDao.selOrderByUserid(userid);
        request.setAttribute("orderlist",list);
        request.getRequestDispatcher("/orderlist.jsp").forward(request,response);
    }
}
