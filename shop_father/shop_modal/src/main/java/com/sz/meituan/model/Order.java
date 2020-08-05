package com.sz.meituan.model;

public class Order {
    private int orderid;
    private int userid;
    private String username;
    private String usertel;
    private String useraddr;
    private float totalmoney;
    private int totalnum;
    private String remark;
    private String status;

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", usertel='" + usertel + '\'' +
                ", useraddr='" + useraddr + '\'' +
                ", totalmoney=" + totalmoney +
                ", totalnum=" + totalnum +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Order(int orderid, int userid, String username, String usertel, String useraddr, float totalmoney, int totalnum, String remark, String status) {
        this.orderid = orderid;
        this.userid = userid;
        this.username = username;
        this.usertel = usertel;
        this.useraddr = useraddr;
        this.totalmoney = totalmoney;
        this.totalnum = totalnum;
        this.remark = remark;
        this.status = status;
    }

    public Order(int userid, String username, String usertel, String useraddr, float totalmoney, int totalnum, String remark, String status) {
        this.userid = userid;
        this.username = username;
        this.usertel = usertel;
        this.useraddr = useraddr;
        this.totalmoney = totalmoney;
        this.totalnum = totalnum;
        this.remark = remark;
        this.status = status;
    }

    public Order() {
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel;
    }

    public String getUseraddr() {
        return useraddr;
    }

    public void setUseraddr(String useraddr) {
        this.useraddr = useraddr;
    }

    public float getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(float totalmoney) {
        this.totalmoney = totalmoney;
    }

    public int getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(int totalnum) {
        this.totalnum = totalnum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
