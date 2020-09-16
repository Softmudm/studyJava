package com.sz.order.service.impl;

import com.sz.order.dao.DetailMapper;
import com.sz.order.dao.OrderMapper;
import com.sz.order.model.Detail;
import com.sz.order.model.Order;
import com.sz.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    DetailMapper detailMapper;

    @Override
    public int addOrder(Order order) {
        //插入订单
        int o = orderMapper.insert(order);
        //插入订单详情
        int d = 0;
        for (Detail detail : order.getList()) {
            d = detailMapper.insertTakeId(detail);
        }
        return o>0&&d>0?1:0;
    }

    @Override
    public int getOrderIdNum() {
        return orderMapper.getOrderIdNum();
    }

    @Override
    public String getOrderId(String num) {
        String head = "GL";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());
        String body = sdf.format(date);
        while(num.length()<6){
            num = "0"+num;
        }
        return head+body+num;
    }

    @Override
    public int payOrder(String orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setStatus("已支付");
        return orderMapper.updateByPrimaryKeySelective(order);
    }
}
