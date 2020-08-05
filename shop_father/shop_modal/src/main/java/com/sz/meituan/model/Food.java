package com.sz.meituan.model;

//实体类；
public class Food {
    private int fid;
    private String fname;
    private String ftype;
    private String fshop;
    private float fprice;
    private String fimg;

    public Food() {
    }

    public Food(int fid, String fname, String ftype, String fshop, float fprice, String fimg) {
        this.fid = fid;
        this.fname = fname;
        this.ftype = ftype;
        this.fshop = fshop;
        this.fprice = fprice;
        this.fimg = fimg;
    }


    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public String getFshop() {
        return fshop;
    }

    public void setFshop(String fshop) {
        this.fshop = fshop;
    }

    public float getFprice() {
        return fprice;
    }

    public void setFprice(float fprice) {
        this.fprice = fprice;
    }

    public String getFimg() {
        return fimg;
    }

    public void setFimg(String fimg) {
        this.fimg = fimg;
    }

    @Override
    public String toString() {
        return "Food{" +
                "fid=" + fid +
                ", fname='" + fname + '\'' +
                ", ftype='" + ftype + '\'' +
                ", fshop='" + fshop + '\'' +
                ", fprice=" + fprice +
                ", fimg='" + fimg + '\'' +
                '}';
    }
}
