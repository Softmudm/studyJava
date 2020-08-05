package com.sz.meituan.model;

public class OrderDetail {
    private int odid;
    private int orderid;
    private int fid;
    private int fnumber;
    private String fname;
    private float fprice;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "odid=" + odid +
                ", orderid=" + orderid +
                ", fid=" + fid +
                ", fnumber=" + fnumber +
                ", fname='" + fname + '\'' +
                ", fprice=" + fprice +
                '}';
    }

    public OrderDetail(int odid, int orderid, int fid, int fnumber, String fname, float fprice) {
        this.odid = odid;
        this.orderid = orderid;
        this.fid = fid;
        this.fnumber = fnumber;
        this.fname = fname;
        this.fprice = fprice;
    }

    public OrderDetail(int orderid, int fid, int fnumber, String fname, float fprice) {
        this.orderid = orderid;
        this.fid = fid;
        this.fnumber = fnumber;
        this.fname = fname;
        this.fprice = fprice;
    }

    public OrderDetail() {
    }

    public int getOdid() {
        return odid;
    }

    public void setOdid(int odid) {
        this.odid = odid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getFnumber() {
        return fnumber;
    }

    public void setFnumber(int fnumber) {
        this.fnumber = fnumber;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public float getFprice() {
        return fprice;
    }

    public void setFprice(float fprice) {
        this.fprice = fprice;
    }
}
