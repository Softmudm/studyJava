package com.sz.commons.model;

//微服务共同的返回结果类
public class Result {
    private boolean status;//状态
    private String msg;//说明
    private Object data;//返回结果数据

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result(boolean status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
