package com.sz.zhiling.entity;


public class User {
    private int userid;
    private String username;
    private int roleid;
    private String rolename;

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                '}';
    }

    public User(int userid, String username, int roleid, String rolename) {
        this.userid = userid;
        this.username = username;
        this.roleid = roleid;
        this.rolename = rolename;
    }

    public User(int userid, String username, int roleid) {
        this.userid = userid;
        this.username = username;
        this.roleid = roleid;
    }

    public User(String username, int roleid) {
        this.username = username;
        this.roleid = roleid;
    }

    public User() {
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
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

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
