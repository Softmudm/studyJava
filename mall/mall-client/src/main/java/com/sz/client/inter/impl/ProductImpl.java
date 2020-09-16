package com.sz.client.inter.impl;

import com.sz.client.inter.ProductInterface;
import com.sz.commons.model.Result;
import org.springframework.stereotype.Component;

@Component
public class ProductImpl implements ProductInterface {
    @Override
    public Result getProductList(String productName, Integer pageIndex, Integer pageSize) {
        return new Result(false,"熔断了！！！");
    }
}
