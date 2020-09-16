package com.sz.order.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class Cart {
    private Integer cartNum;
    private BigDecimal cartCount;
    private Map<Integer,CartDetail> map;

    public Integer getCartNum() {
        int cN=0;
        if(map.size()!=0) {
            for (Integer i : map.keySet()) {
                cN = cN + map.get(i).getDetailNum();
            }
        }
        cartNum = cN;
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
    }

    public Cart(Integer cartNum, BigDecimal cartCount, Map<Integer,CartDetail> map) {
        this.cartNum = cartNum;
        this.cartCount = cartCount;
        this.map = map;
    }
}
