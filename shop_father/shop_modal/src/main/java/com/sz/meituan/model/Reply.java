package com.sz.meituan.model;

import java.util.Date;

//回复类
public class Reply {
    private int replyid;
    private int appraiseid;
    private int userid;
    private String content;
    private Date rdate;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Reply(int replyid, int appraiseid, int userid, String content, Date rdate, String username) {
        this.replyid = replyid;
        this.appraiseid = appraiseid;
        this.userid = userid;
        this.content = content;
        this.rdate = rdate;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyid=" + replyid +
                ", appraiseid=" + appraiseid +
                ", userid=" + userid +
                ", content='" + content + '\'' +
                ", rdate=" + rdate +
                '}';
    }

    public Reply(int replyid, int appraiseid, int userid, String content, Date rdate) {
        this.replyid = replyid;
        this.appraiseid = appraiseid;
        this.userid = userid;
        this.content = content;
        this.rdate = rdate;
    }

    public Reply(int appraiseid, int userid, String content) {
        this.appraiseid = appraiseid;
        this.userid = userid;
        this.content = content;
    }

    public Reply() {
    }

    public int getReplyid() {
        return replyid;
    }

    public void setReplyid(int replyid) {
        this.replyid = replyid;
    }

    public int getAppraiseid() {
        return appraiseid;
    }

    public void setAppraiseid(int appraiseid) {
        this.appraiseid = appraiseid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }
}
