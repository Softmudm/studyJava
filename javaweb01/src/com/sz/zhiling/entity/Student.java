package com.sz.zhiling.entity;

public class Student {
    private String stuid;
    private String stuname;
    private int age;
    private String stusex;

    @Override
    public String toString() {
        return "Student{" +
                "stuid='" + stuid + '\'' +
                ", stuname='" + stuname + '\'' +
                ", age=" + age +
                ", stusex='" + stusex + '\'' +
                '}';
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex;
    }

    public Student(String stuid, String stuname, int age, String stusex) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.age = age;
        this.stusex = stusex;
    }

    public Student() {
    }
}
