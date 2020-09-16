package com.sz.order.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private String orderId;

    private Long userId;

    private String userName;

    private String orderAdress;

    private String status;

    private Integer cartNum;

    private BigDecimal cartCount;

    private List<Detail> list;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrderAdress() {
        return orderAdress;
    }

    public void setOrderAdress(String orderAdress) {
        this.orderAdress = orderAdress == null ? null : orderAdress.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getCartNum() {
        return cartNum;
    }

    public void setCartNum(Integer cartNum) {
        this.cartNum = cartNum;
    }

    public BigDecimal getCartCount() {
        return cartCount;
    }

    public void setCartCount(BigDecimal cartCount) {
        this.cartCount = cartCount;
    }

    public List<Detail> getList() {
        return list;
    }

    public void setList(List<Detail> list) {
        this.list = list;
    }
}