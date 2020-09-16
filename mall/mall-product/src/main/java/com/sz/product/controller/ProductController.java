package com.sz.product.controller;

import com.sz.commons.model.Result;
import com.sz.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    //商品列表
    @GetMapping("/productList/{productName}")
    public Result getProductList(@PathVariable("productName")String productName,Integer pageIndex,Integer pageSize){
        //对数据进行处理
        productName = "null".equals(productName)?"":productName;
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?4:pageSize;
        System.out.println("productName"+productName+"页码"+pageIndex+pageSize);
        return new Result(true,"成功",productService.getProductList(productName,pageIndex,pageSize));
    }

    //商品详情查询服务
    @GetMapping("/{productId}")
    public Result getProductById(@PathVariable("productId")Integer productId){
        return new Result(true,"",productService.getProductById(productId));
    }

}
