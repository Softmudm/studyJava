package com.sz.wx.util;

public class MsgResult {
    private String msg;
    private int i;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public MsgResult() {
    }

    public MsgResult(String msg, int i) {
        this.msg = msg;
        this.i = i;
    }
}
