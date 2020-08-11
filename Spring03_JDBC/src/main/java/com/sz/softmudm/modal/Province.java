package com.sz.softmudm.modal;

import java.util.List;

//省和市的实体类
public class Province {
    private int pid;        //省或市的id
    private String pname;   //省或市的名称
    private int fid;        //父id
    private List<Province> list;      //存放子节点的集合

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

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public List<Province> getList() {
        return list;
    }

    public void setList(List<Province> list) {
        this.list = list;
    }

    public Province(int pid, String pname, int fid) {
        this.pid = pid;
        this.pname = pname;
        this.fid = fid;
    }

    public Province(String pname, int fid) {
        this.pname = pname;
        this.fid = fid;
    }

    public Province() {
    }

    @Override
    public String toString() {
        return "Province{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", fid=" + fid +
                ", list=" + list +
                '}';
    }
}
