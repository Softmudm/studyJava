package com.sz.meituan.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//购物车实体类；
public class Cart {
   //存储所有购买的信息；
    private Map<Integer,CartItem> map = new HashMap<>();
    private float total = 0;  //总金额；通过计算得到；
    private int sum = 0;      //总数量；    通过计算得到；

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> map, float total, int sum) {
        this.map = map;
        this.total = total;
        this.sum = sum;
    }

    public Map<Integer, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CartItem> map) {
        this.map = map;
    }

    public float getTotal() {

        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getSum() {
        int t = 0;
        float f = 0;
        Collection<CartItem> values = map.values();
        for (CartItem item : values) {
            f+=item.getXiaoji();     //总金额；通过计算得到；
            t+=item.getNum();       //总数量； 通过计算得到；
        }
        this.total=f;
        this.sum=t;
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        Set set = map.entrySet();
        for (Object o : set) {
            System.out.println(o);
        }
        return "总金额："+total+"总数量："+sum;
    }
}
