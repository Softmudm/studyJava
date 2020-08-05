package com.sz.meituan.servlets;

import com.sz.meituan.model.Cart;
import com.sz.meituan.model.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/DelShopServlet")
public class DelShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int fid = Integer.parseInt(request.getParameter("fid"));
        HttpSession session = request.getSession(false);
        Object object = session.getAttribute("cart");
        Cart cart =null;
        if(object!=null){
            cart = (Cart) object;
        }
        Map<Integer, CartItem> map = cart.getMap();
        map.remove(fid);
        cart.setMap(map);
        session.setAttribute("cart",cart);
        request.getRequestDispatcher("car.jsp").forward(request,response);
    }
}
