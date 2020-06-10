package com.sz.zhiling.ThreadTest03;

public class Homework03Thread1 extends Thread{

    private MyData myData;

    public Homework03Thread1() {
    }

    public Homework03Thread1(MyData myData) {
        this.myData = myData;
    }

    @Override
    public void run() {
        myData.add();
    }
}
