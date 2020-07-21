package com.sz.zhiling.entity;

public class Like {
    private int likeid;
    private String likename;

    @Override
    public String toString() {
        return "Like{" +
                "likeid=" + likeid +
                ", likename='" + likename + '\'' +
                '}';
    }

    public Like(int likeid, String likename) {
        this.likeid = likeid;
        this.likename = likename;
    }

    public Like() {
    }

    public int getLikeid() {
        return likeid;
    }

    public void setLikeid(int likeid) {
        this.likeid = likeid;
    }

    public String getLikename() {
        return likename;
    }

    public void setLikename(String likename) {
        this.likename = likename;
    }
}
