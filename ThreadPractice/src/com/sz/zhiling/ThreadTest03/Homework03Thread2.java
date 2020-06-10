package com.sz.zhiling.ThreadTest03;

public class Homework03Thread2 extends Thread{

    private MyData myData;

    public Homework03Thread2(MyData myData) {
        this.myData = myData;
    }

    public Homework03Thread2() {
    }

    @Override
    public void run() {
        myData.mins();
    }
}
