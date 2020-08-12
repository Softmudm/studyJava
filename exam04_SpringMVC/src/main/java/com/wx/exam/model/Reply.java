package com.wx.exam.model;

import java.util.Date;

public class Reply {
    private int rid;        //回复id
    private int kid;        //评论id
    private int ruid;       //用户id
    private String rmsg;    //回复内容
    private Date rdate;     //回复时间
    private String runame;  //用户名称

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public int getRuid() {
        return ruid;
    }

    public void setRuid(int ruid) {
        this.ruid = ruid;
    }

    public String getRmsg() {
        return rmsg;
    }

    public void setRmsg(String rmsg) {
        this.rmsg = rmsg;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    public String getRuname() {
        return runame;
    }

    public void setRuname(String runame) {
        this.runame = runame;
    }

    public Reply() {
    }

    public Reply(int kid, int ruid, String rmsg) {
        this.kid = kid;
        this.ruid = ruid;
        this.rmsg = rmsg;
    }

    public Reply(int kid, int ruid, String rmsg, Date rdate, String runame) {
        this.kid = kid;
        this.ruid = ruid;
        this.rmsg = rmsg;
        this.rdate = rdate;
        this.runame = runame;
    }

    public Reply(int rid, int kid, int ruid, String rmsg, Date rdate, String runame) {
        this.rid = rid;
        this.kid = kid;
        this.ruid = ruid;
        this.rmsg = rmsg;
        this.rdate = rdate;
        this.runame = runame;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "rid=" + rid +
                ", kid=" + kid +
                ", ruid=" + ruid +
                ", rmsg='" + rmsg + '\'' +
                ", rdate=" + rdate +
                ", runame='" + runame + '\'' +
                '}';
    }
}
