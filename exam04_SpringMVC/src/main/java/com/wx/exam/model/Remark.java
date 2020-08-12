package com.wx.exam.model;

import java.util.Date;

public class Remark {
    private int kid;        //评论id
    private int kuid;       //用户id
    private String kmsg;    //评论内容
    private Date kdate;     //评论时间
    private String uname;   //用户名称

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public int getKuid() {
        return kuid;
    }

    public void setKuid(int kuid) {
        this.kuid = kuid;
    }

    public String getKmsg() {
        return kmsg;
    }

    public void setKmsg(String kmsg) {
        this.kmsg = kmsg;
    }

    public Date getKdate() {
        return kdate;
    }

    public void setKdate(Date kdate) {
        this.kdate = kdate;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Remark() {
    }

    public Remark(int kuid, String kmsg, Date kdate, String uname) {
        this.kuid = kuid;
        this.kmsg = kmsg;
        this.kdate = kdate;
        this.uname = uname;
    }

    public Remark(int kid, int kuid, String kmsg, Date kdate, String uname) {
        this.kid = kid;
        this.kuid = kuid;
        this.kmsg = kmsg;
        this.kdate = kdate;
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "Remark{" +
                "kid=" + kid +
                ", kuid=" + kuid +
                ", kmsg='" + kmsg + '\'' +
                ", kdate=" + kdate +
                '}';
    }
}
