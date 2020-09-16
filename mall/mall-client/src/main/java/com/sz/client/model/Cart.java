package com.sz.client.model;

import java.math.BigDecimal;
import java.util.Map;

public class Cart {
    Integer cartNum;
    BigDecimal cartCount;
    Map<Integer,CartDetail> map;

    public Integer getCartNum() {
        if(map.size()==0){
            return 0;
        }
        for (Integer i:map.keySet()) {
            cartNum = cartNum+map.get(i).getDetailNum();
        }
        return cartNum;
    }

    public void setCartNum(Integer cartNum) {
        this.cartNum = cartNum;
    }

    public BigDecimal getCartCount() {
        if(map.size()==0){
            return new BigDecimal(0);
        }
        cartCount = new BigDecimal(0);
        for (Integer i:map.keySet()) {
            cartCount = cartCount.add(map.get(i).getDetailCount());
        }
        return cartCount;
    }

    public void setCartCount(BigDecimal cartCount) {
        this.cartCount = cartCount;
    }

    public Map<Integer,CartDetail> getMap() {
        return map;
    }

    public void setMap(Map<Integer,CartDetail> map) {
        this.map = map;
        getCartNum();
        getCartCount();
    }

    public Cart() {
    }

    public Cart(Map<Integer,CartDetail> map) {
        this.map = map;
        getCartNum();
        getCartCount();
    }

    public Cart(Integer cartNum, BigDecimal cartCount, Map<Integer,CartDetail> map) {
        this.cartNum = cartNum;
        this.cartCount = cartCount;
        this.map = map;
        getCartNum();
        getCartCount();
    }
}
