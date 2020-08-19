package com.sz.wx.entity;

public class City {
    private int cid;
    private String cname;
    private int pid;
    private String pname;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public City() {
    }

    public City(String cname, int pid, String pname) {
        this.cname = cname;
        this.pid = pid;
        this.pname = pname;
    }

    public City(int cid, String cname, int pid, String pname) {
        this.cid = cid;
        this.cname = cname;
        this.pid = pid;
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "City{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }
}
