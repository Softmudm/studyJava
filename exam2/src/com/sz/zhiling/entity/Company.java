package com.sz.zhiling.entity;

public class Company {
    private int comid;//公司编号
    private String comname;//公司名称
    private String mastername;//法人姓名
    private String mastertele;//法人电话
    private String cominfo;//公司简介

    @Override
    public String toString() {
        return "Company{" +
                "comid=" + comid +
                ", comname='" + comname + '\'' +
                ", mastername='" + mastername + '\'' +
                ", mastertele='" + mastertele + '\'' +
                ", cominfo='" + cominfo + '\'' +
                '}';
    }

    public int getComid() {
        return comid;
    }

    public void setComid(int comid) {
        this.comid = comid;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public String getMastername() {
        return mastername;
    }

    public void setMastername(String mastername) {
        this.mastername = mastername;
    }

    public String getMastertele() {
        return mastertele;
    }

    public void setMastertele(String mastertele) {
        this.mastertele = mastertele;
    }

    public String getCominfo() {
        return cominfo;
    }

    public void setCominfo(String cominfo) {
        this.cominfo = cominfo;
    }
}
