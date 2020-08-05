package com.sz.meituan.model;

public class User {
    private int userid;
    private String username;
    private String userpwd;
    private String usertel;
    private String useraddr;

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", usertel='" + usertel + '\'' +
                ", useraddr='" + useraddr + '\'' +
                '}';
    }

    public User(int userid, String username, String userpwd, String usertel, String useraddr) {
        this.userid = userid;
        this.username = username;
        this.userpwd = userpwd;
        this.usertel = usertel;
        this.useraddr = useraddr;
    }

    public User() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel;
    }

    public String getUseraddr() {
        return useraddr;
    }

    public void setUseraddr(String useraddr) {
        this.useraddr = useraddr;
    }
}
