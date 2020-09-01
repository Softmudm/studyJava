package com.sz.wx.util;

public class Info {
    private String message;
    private Integer icon;
    private boolean state;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Info() {
    }

    public Info(boolean state) {
        this.state = state;
    }

    public Info(String message) {
        this.message = message;
    }

    public Info(String message, Integer icon) {
        this.message = message;
        this.icon = icon;
    }

    public Info(String message, Integer icon, boolean state) {
        this.message = message;
        this.icon = icon;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Info{" +
                "message='" + message + '\'' +
                ", icon=" + icon +
                ", state=" + state +
                '}';
    }
}
