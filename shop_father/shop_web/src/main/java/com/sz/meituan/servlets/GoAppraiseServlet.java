package com.sz.meituan.servlets;

import com.sz.meituan.dao.OrderDao;
import com.sz.meituan.dao.OrderDetailDao;
import com.sz.meituan.model.Order;
import com.sz.meituan.model.OrderDetail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/goappraise")
public class GoAppraiseServlet extends HttpServlet {
    private OrderDao orderDao = new OrderDao();
    private OrderDetailDao orderDetailDao = new OrderDetailDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderid = Integer.parseInt(request.getParameter("orderid"));
        Order order = orderDao.selOrderByid(orderid);
        List<OrderDetail> list = orderDetailDao.selDetailByOid(orderid);
        System.out.println(order);
        for (OrderDetail orderDetail : list) {
            System.out.println(orderDetail);
        }
        request.setAttribute("order",order);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/addappraise.jsp").forward(request,response);
    }
}
