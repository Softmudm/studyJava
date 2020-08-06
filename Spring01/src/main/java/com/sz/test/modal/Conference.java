package com.sz.test.modal;

//会议室实体类
public class Conference {
    private int serialId;//序号
    private String conferenceId;//会议室编号
    private String conferenceName;//会议室名称
    private String conferenceAddr;//会议室地址
    private int conferenceSize;//会议室容量

    public int getSerialId() {
        return serialId;
    }

    public void setSerialId(int serialId) {
        this.serialId = serialId;
    }

    public String getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public String getConferenceAddr() {
        return conferenceAddr;
    }

    public void setConferenceAddr(String conferenceAddr) {
        this.conferenceAddr = conferenceAddr;
    }

    public int getConferenceSize() {
        return conferenceSize;
    }

    public void setConferenceSize(int conferenceSize) {
        this.conferenceSize = conferenceSize;
    }

    public Conference() {
    }

    public Conference(String conferenceId, String conferenceName, String conferenceAddr, int conferenceSize) {
        this.conferenceId = conferenceId;
        this.conferenceName = conferenceName;
        this.conferenceAddr = conferenceAddr;
        this.conferenceSize = conferenceSize;
    }

    public Conference(int serialId, String conferenceId, String conferenceName, String conferenceAddr, int conferenceSize) {
        this.serialId = serialId;
        this.conferenceId = conferenceId;
        this.conferenceName = conferenceName;
        this.conferenceAddr = conferenceAddr;
        this.conferenceSize = conferenceSize;
    }
}
