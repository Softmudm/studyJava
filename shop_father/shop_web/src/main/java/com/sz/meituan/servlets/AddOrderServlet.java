package com.sz.meituan.servlets;

import com.sz.meituan.dao.OrderDao;
import com.sz.meituan.dao.OrderDetailDao;
import com.sz.meituan.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/order")
public class AddOrderServlet extends HttpServlet {
    private static OrderDao orderDao = new OrderDao();
    private static OrderDetailDao orderDetailDao = new OrderDetailDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //获取当前用户
        Object object1= session.getAttribute("user");
        User user = new User();
        if(object1!=null){
            user = (User)object1;
        }
        //获取用户的购物车
        Object object2= session.getAttribute("cart");
        Cart cart = new Cart();
        if(object2!=null){
            cart = (Cart)object2;
        }
        //将各项订单数据装入订单实体类
        Order order = new Order();
        int orderid = orderDao.getOrderid();
        order.setOrderid(orderid);
        order.setUserid(user.getUserid());
        order.setTotalmoney(cart.getTotal());
        order.setUsername(user.getUsername());
        order.setUsertel(user.getUsertel());
        order.setUseraddr(user.getUseraddr());
        order.setTotalnum(cart.getSum());
        order.setStatus("待支付");
        orderDao.addOrder(order);
        //遍历订单各小项存入详情表
        Map<Integer, CartItem> map = cart.getMap();
        for (CartItem value : map.values()) {
            orderDetailDao.addOrderDetail(new OrderDetail(orderid,value.getFid(),value.getNum(),value.getFname(),value.getFprice()));
        }
        //添加完后清空购物车
        map.clear();
        session.setAttribute("cart",cart);
        //跳转
        response.sendRedirect("/goorder?orderid="+orderid);
    }
}
