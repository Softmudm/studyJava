package com.sz.order.otherinterface;

import com.sz.commons.model.Result;
import com.sz.order.otherinterface.impl.ProductServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "product-client" , fallback = ProductServiceImpl.class)
public interface ProductService {

    //商品详情查询服务
    @GetMapping("/product/{productId}")
    public String getProductById(@PathVariable("productId")Integer productId);
}
