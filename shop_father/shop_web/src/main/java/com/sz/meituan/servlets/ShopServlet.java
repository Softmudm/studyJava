package com.sz.meituan.servlets;

import com.sz.meituan.dao.FoodDao;
import com.sz.meituan.model.Cart;
import com.sz.meituan.model.CartItem;
import com.sz.meituan.model.Food;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {
    private FoodDao dao = new FoodDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理放入到购物车的功能；
        String fid = request.getParameter("fid"); //从页面上获取到的参数的值；
        int foodid = Integer.parseInt(fid);
        Food food = dao.getFoodByFid(foodid);
        HttpSession session = request.getSession(); //创建一个session对象；
        //定义一个空的购物车；
        Cart cart = new Cart();
        Map<Integer,CartItem> myMap = new HashMap<>(); //定义一个空的集合；
        CartItem item = new CartItem(food.getFid(),food.getFname(),food.getFtype(),food.getFshop(),
                food.getFprice(),food.getFimg(),1,food.getFprice());  //因为数量只有一个，所以小计就是价格；
        //1.第一次购物时；
        if (session.getAttribute("cart") ==null){
            myMap.put(foodid,item);  //把购买的小项目加入到购物车的集合中；
            cart.setMap(myMap);  //把购物车的集合加入到购物车中；
            session.setAttribute("cart",cart);//把购物车放到请求作用域中，
        }else {
            //2.第二次或多次购买的时候；
            Object obj = session.getAttribute("cart");
            cart = (Cart) obj;   //先取出原来购物车中的集合，
            myMap = cart.getMap();
            //3.分两种情况：3.1 此购物项是否购买过？如果购买过，只需要数量+1，如果没有购买过，则放进去；
            if (myMap.containsKey(foodid)){
                //如果购买过，只需要数量+1，
                CartItem cartItem = myMap.get(foodid); //先取出原来的购物项目；
                cartItem.setNum(cartItem.getNum()+1);
            }else {
                //如果没有购买过，则放进去；
                myMap.put(foodid,item);
            }
            cart.setMap(myMap);  //购物车中的集合更新了！！！！所以要重新设置~！
            session.setAttribute("cart",cart);//把购物车放到请求作用域中，
        }
        request.getRequestDispatcher("/car.jsp").forward(request,response);//转发页面；
    }
}
