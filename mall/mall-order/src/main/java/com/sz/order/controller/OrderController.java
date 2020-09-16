package com.sz.order.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sz.commons.model.Result;
import com.sz.order.model.*;
import com.sz.order.otherinterface.ProductService;
import com.sz.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //加入购物车
    @PostMapping("/cart/{productId}/{amount}")
    public Result addToCart(@PathVariable("productId")Integer productId, @PathVariable("amount")Integer amount ,HttpServletRequest request){
        String s = productService.getProductById(productId);
        Result result = JSON.parseObject(s,Result.class);
        Product product = JSON.parseObject(result.getData().toString(),Product.class);
        if(!result.isStatus()){
            return new Result(false,"商品id不正确！");
        }
        ValueOperations<String, String> redis = stringRedisTemplate.opsForValue();
        //获取当前用户
        String token = request.getHeader("token");
        String tokenvalue = redis.get(token);
        User user = JSON.parseObject(tokenvalue,User.class);
        //查询缓存中有没有该用户购物车
        String cartvalue = redis.get(user.getAccount()+"cart");
        Cart cart = null;
        if(cartvalue==null){//没有就添加
            cart = new Cart(new HashMap<>());
            redis.set(user.getAccount()+"cart",JSON.toJSONString(cart));
        }else{//缓存中有购物车
            cart = JSON.parseObject(cartvalue,Cart.class);
        }
        //判断有没有该商品
        CartDetail cartDetail = cart.getMap().get(productId);
        if(cartDetail==null){
            Map<Integer,CartDetail> map = cart.getMap();
            if(map==null){
                map = new HashMap<>();
            }
            if(amount==null||amount<0){
                return new Result(false,"商品数量不正确！");
            }
            map.put(productId,new CartDetail(amount,null, product));
            redis.set(user.getAccount()+"cart",JSON.toJSONString(new Cart(map)));
        }else{
            int num = cartDetail.getDetailNum()+amount;
            if(num<=0){
                cart.getMap().remove(productId);
                System.out.println(cart.getMap());
            }else{
                cartDetail.setDetailNum(num);
            }
            redis.set(user.getAccount()+"cart",JSON.toJSONString(cart));
        }
        return new Result(true,"操作购物车成功！");
    }

    //查询购物车
    @GetMapping("/cart")
    public Result getCart(HttpServletRequest request){
        String token = request.getHeader("token");
        //购物车在redis缓存中，直接拿
        User user = JSON.parseObject(stringRedisTemplate.opsForValue().get(token),User.class);
        String cart = stringRedisTemplate.opsForValue().get(user.getAccount()+"cart");
        return new Result(true,"购物车",cart);
    }

    //新增订单
    @PostMapping("/addorder")
    public Result addOrder(HttpServletRequest request){
        Order order = new Order();
        //得到订单号
        int o = orderService.getOrderIdNum();
        String orderId = orderService.getOrderId(o+"");
        //得到用户id和地址
        String token = request.getHeader("token");
        String tokenvalue = stringRedisTemplate.opsForValue().get(token);
        User user = JSON.parseObject(tokenvalue,User.class);
        //把订单详情放入list
        //从缓存中取出购物车
        String scart = stringRedisTemplate.opsForValue().get(user.getAccount()+"cart");
        Cart cart = JSON.parseObject(scart,Cart.class);
        Map<Integer, CartDetail> map = cart.getMap();
        List<Detail> list = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            CartDetail cartDetail = map.get(integer);
            Detail detail = new Detail();
            detail.setProductId(cartDetail.getProductId());
            detail.setProductName(cartDetail.getProductName());
            detail.setProductPrice(cartDetail.getProductPrice());
            detail.setAmount(cartDetail.getDetailNum());
            detail.setOrderId(orderId);
            list.add(detail);
        }
        order.setOrderId(orderId);
        order.setUserId(user.getUserId());
        order.setUserName(user.getUserName());
        order.setOrderAdress(user.getAddress());
        order.setCartNum(cart.getCartNum());
        order.setCartCount(cart.getCartCount());
        order.setStatus("待支付");
        order.setList(list);
        orderService.addOrder(order);
        stringRedisTemplate.delete(user.getAccount()+"cart");
        return new Result(true,"成功",order);
    }
    @PostMapping("/payorder/{orderId}")
    public Result payOrder(@PathVariable("orderId") String orderId){
        int f = orderService.payOrder(orderId);
        Result result = new Result(true,"支付成功");
        if(f<=0){
            result.setStatus(false);
            result.setMsg("支付失败");
        }
        return result;
    }
}
