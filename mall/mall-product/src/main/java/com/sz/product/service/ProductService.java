package com.sz.product.service;

import com.sz.commons.model.PageResult;
import com.sz.product.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    //分页查询产品列表
    public PageResult<Product> getProductList(String productName, Integer pageIndex, Integer pageSize);
    //根据id查询商品
    public Product getProductById(Integer productId);
}
