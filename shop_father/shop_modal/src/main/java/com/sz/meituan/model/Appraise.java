package com.sz.meituan.model;

import java.util.Date;
import java.util.List;

public class Appraise {
    private int appraiseid;
    private int fid;
    private String content;
    private int userid;
    private Date pdate;
    private String username;
    private List<Reply> replyList;

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    @Override
    public String toString() {
        return "Appraise{" +
                "appraiseid=" + appraiseid +
                ", fid=" + fid +
                ", content='" + content + '\'' +
                ", userid=" + userid +
                ", pdate=" + pdate +
                '}';
    }

    public Appraise(int fid, String content, int userid) {
        this.fid = fid;
        this.content = content;
        this.userid = userid;
    }

    public Appraise(int appraiseid, int fid, String content, int userid, Date pdate, String username) {
        this.appraiseid = appraiseid;
        this.fid = fid;
        this.content = content;
        this.userid = userid;
        this.pdate = pdate;
        this.username = username;
    }

    public Appraise(int fid, String content, int userid, Date pdate) {
        this.fid = fid;
        this.content = content;
        this.userid = userid;
        this.pdate = pdate;
    }

    public Appraise(int appraiseid, int fid, String content, int userid, Date pdate) {
        this.appraiseid = appraiseid;
        this.fid = fid;
        this.content = content;
        this.userid = userid;
        this.pdate = pdate;
    }

    public Appraise() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAppraiseid() {
        return appraiseid;
    }

    public void setAppraiseid(int appraiseid) {
        this.appraiseid = appraiseid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }
}
