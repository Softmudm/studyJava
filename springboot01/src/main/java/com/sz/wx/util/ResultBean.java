package com.sz.wx.util;

public class ResultBean {
    private String message;
    private Integer i;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public ResultBean() {
    }

    public ResultBean(String message, Integer i) {
        this.message = message;
        this.i = i;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "message='" + message + '\'' +
                ", i=" + i +
                '}';
    }
}
