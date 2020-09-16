package com.sz.order.otherinterface.impl;

import com.alibaba.fastjson.JSON;
import com.sz.commons.model.Result;
import com.sz.order.otherinterface.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
    @Override
    public String getProductById(Integer productId) {
        System.out.println("订单调用产品服务熔断了！");
        return JSON.toJSONString(new Result(false,"订单调用产品服务熔断了！"));
    }
}
