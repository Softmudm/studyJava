package com.sz.zhiling.modal;

public class Student extends User {
    private String stuno;//学生编号

    public String getStuno() {
        return stuno;
    }
    public void setStuno(String stuno) {
        this.stuno = stuno;
    }
    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Student(String stuno,String name, String password, int age, String sex) {
        super(name, password, age, sex);
        this.stuno = stuno;
        // TODO Auto-generated constructor stub
    }
}