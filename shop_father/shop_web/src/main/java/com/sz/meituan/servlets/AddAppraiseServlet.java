package com.sz.meituan.servlets;

import com.sz.meituan.dao.AppraiseDao;
import com.sz.meituan.dao.OrderDao;
import com.sz.meituan.dao.OrderDetailDao;
import com.sz.meituan.model.Appraise;
import com.sz.meituan.model.OrderDetail;
import com.sz.meituan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/addAppraise")
public class AddAppraiseServlet extends HttpServlet {
    private OrderDetailDao orderDetailDao = new OrderDetailDao();
    private AppraiseDao appraiseDao = new AppraiseDao();
    private OrderDao orderDao = new OrderDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderid = Integer.parseInt(request.getParameter("orderid"));
        List<OrderDetail> list = orderDetailDao.selDetailByOid(orderid);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        for (OrderDetail orderDetail : list) {
            //获取菜品id
            int fid = orderDetail.getFid();
            //获取评价内容
            String content = request.getParameter(String.valueOf(fid));
            Appraise appraise = new Appraise(fid,content,user.getUserid());
            appraiseDao.addAppriseDao(appraise);
        }
        orderDao.updateOrderByid(orderid,"已评价");
        request.getRequestDispatcher("/orderlist").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
