package com.sz.wx.entity;

import java.util.List;

public class Province {
    private int pid;
    private String pname;
    private List<City> list;

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

    public List<City> getList() {
        return list;
    }

    public void setList(List<City> list) {
        this.list = list;
    }

    public Province() {
    }

    public Province(String pname) {
        this.pname = pname;
    }

    public Province(int pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    public Province(int pid, String pname, List<City> list) {
        this.pid = pid;
        this.pname = pname;
        this.list = list;
    }

    @Override
    public String toString() {
        return "Province{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", list=" + list +
                '}';
    }
}
