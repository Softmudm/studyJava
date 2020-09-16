package com.sz.client.controller;

import com.sz.client.inter.ProductInterface;
import com.sz.commons.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ProductInterface productInterface;
    @GetMapping("/productList/{productName}")
    public Result getProductList(@PathVariable("productName")String productName,Integer pageIndex, Integer pageSize){
        return productInterface.getProductList(productName,pageIndex,pageSize);
    }
}
