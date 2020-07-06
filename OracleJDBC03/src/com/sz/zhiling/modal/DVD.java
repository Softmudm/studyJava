package com.sz.zhiling.modal;

public class DVD {
    private String dvdid;//DVD编号
    private String dvdname;//DVD名称
    private int state;//状态;
    private String date;//借出日期
    private int time;//次数

    public String getDvdid() {
        return dvdid;
    }

    public void setDvdid(String dvdid) {
        this.dvdid = dvdid;
    }

    public String getDvdname() {
        return dvdname;
    }

    public void setDvdname(String dvdname) {
        this.dvdname = dvdname;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public DVD() {
    }

    public DVD(String dvdid, String dvdname, int state, String date, int time) {
        this.dvdid = dvdid;
        this.dvdname = dvdname;
        this.state = state;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "dvdid='" + dvdid + '\'' +
                ", dvdname='" + dvdname + '\'' +
                ", state=" + state +
                ", date='" + date + '\'' +
                ", time=" + time +
                '}';
    }
}
