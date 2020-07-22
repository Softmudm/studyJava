package com.sz.zhiling.entity;

import java.util.Date;

public class Visit {
    private int vid;//回访编号
    private String vname;//回访人姓名
    private Date vdate;//回访时间
    private String vtype;//回访分类
    private String vresult;//回访结果
    private String vmethod;//回访方式
    private int comid;//公司编号

    public Visit() {
    }

    public Visit(int vid, String vname, Date vdate, String vtype, String vresult, String vmethod, int comid) {
        this.vid = vid;
        this.vname = vname;
        this.vdate = vdate;
        this.vtype = vtype;
        this.vresult = vresult;
        this.vmethod = vmethod;
        this.comid = comid;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "vid=" + vid +
                ", vname='" + vname + '\'' +
                ", vdate=" + vdate +
                ", vtype='" + vtype + '\'' +
                ", vresult='" + vresult + '\'' +
                ", vmethod='" + vmethod + '\'' +
                ", comid=" + comid +
                '}';
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public Date getVdate() {
        return vdate;
    }

    public void setVdate(Date vdate) {
        this.vdate = vdate;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public String getVresult() {
        return vresult;
    }

    public void setVresult(String vresult) {
        this.vresult = vresult;
    }

    public String getVmethod() {
        return vmethod;
    }

    public void setVmethod(String vmethod) {
        this.vmethod = vmethod;
    }

    public int getComid() {
        return comid;
    }

    public void setComid(int comid) {
        this.comid = comid;
    }
}
