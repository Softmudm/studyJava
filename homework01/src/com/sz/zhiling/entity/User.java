package com.sz.zhiling.entity;


import java.util.ArrayList;

public class User {
    private int userid;
    private String username;
    private int roleid;
    private String rolename;
    private ArrayList<Integer> likeids;

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", likeids=" + likeids +
                '}';
    }

    public User(int userid, String username, int roleid, String rolename, ArrayList<Integer> likeids) {
        this.userid = userid;
        this.username = username;
        this.roleid = roleid;
        this.rolename = rolename;
        this.likeids = likeids;
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

    public ArrayList<Integer> getLikeids() {
        return likeids;
    }

    public void setLikeids(ArrayList<Integer> likeids) {
        this.likeids = likeids;
    }
}
