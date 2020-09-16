package com.sz.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sz.commons.model.PageResult;
import com.sz.product.dao.ProductMapper;
import com.sz.product.model.Product;
import com.sz.product.model.ProductExample;
import com.sz.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //查询商品列表
    @Override
    public PageResult<Product> getProductList(String productName,Integer pageIndex,Integer pageSize) {
        String key = "p"+productName+"i"+pageIndex+"s"+pageSize;
        String value = stringRedisTemplate.opsForValue().get(key);
        if(value!=null){//缓存中有直接返回
            System.out.println("从缓存中拿");
            return JSON.parseObject(value,PageResult.class);
        }else{//缓存中没有
            //查询条件
            System.out.println("数据库中拿");
            ProductExample example = new ProductExample();
            ProductExample.Criteria criteria = example.createCriteria();
            criteria.andProductNameLike("%"+productName+"%");
            //分页
            PageHelper.startPage(pageIndex,pageSize);
            List<Product> list = productMapper.selectByExample(example);
            Page<Product> page = (Page<Product>) list;
            PageResult pr = new PageResult<>(
                    page.getPageNum(),
                    page.getPageSize(),
                    page.getPages(),
                    page.getTotal(),
                    page.getResult());
            //存入redis
            stringRedisTemplate.opsForValue().set(key,JSON.toJSONString(pr));
            return pr;
        }
    }

    //根据id查询商品
    @Override
    public Product getProductById(Integer productId) {
        return productMapper.selectByPrimaryKey((long) productId);
    }
}
