package com.sz.order.service;

import com.sz.order.model.Order;

public interface OrderService {
    //添加订单
    public int addOrder(Order order);
    //获取订单后面尾数
    public int getOrderIdNum();
    //生成订单号
    public String getOrderId(String num);
    //支付订单
    public int payOrder(String orderId);
}
