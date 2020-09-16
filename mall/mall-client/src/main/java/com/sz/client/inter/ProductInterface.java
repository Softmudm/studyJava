package com.sz.client.inter;

import com.sz.client.inter.impl.ProductImpl;
import com.sz.commons.model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "product-client",fallback = ProductImpl.class)
public interface ProductInterface {
    //分页查询商品列表
    @GetMapping("/productList/{productName}")
    public Result getProductList(@PathVariable("productName")String productName, @RequestParam Integer pageIndex, @RequestParam Integer pageSize);
}
