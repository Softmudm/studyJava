package com.sz.meituan.servlets;

import com.sz.meituan.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateOrder")
public class UpdateOrderServlet extends HttpServlet {
    private OrderDao orderDao = new OrderDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderid = Integer.parseInt(request.getParameter("orderid"));
        String status = request.getParameter("status");
        if("cancel".equals(status)){//取消订单
            orderDao.updateOrderByid(orderid,"已取消");
        }
        if("paid".equals(status)){//支付订单
            orderDao.updateOrderByid(orderid,"待评价");
        }
        request.getRequestDispatcher("/orderlist").forward(request,response);
    }
}
