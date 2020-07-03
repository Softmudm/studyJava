package com.sz.zhiling.modal;

public class Teacher extends User {
    private String teano;//教师编号

    public String getTeano() {
        return teano;
    }
    public void setTeano(String teano) {
        this.teano = teano;
    }
    public Teacher() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Teacher(String teano,String name, String password, int age, String sex) {
        super(name, password, age, sex);
        this.teano = teano;
        // TODO Auto-generated constructor stub
    }
}