package com.sz.zhiling.ThreadTest03;

public class Master {
    public static void main(String[] args) {
        MyData myData = new MyData(0);
        Homework03Thread1 t1 = new Homework03Thread1(myData);
        Homework03Thread1 t2 = new Homework03Thread1(myData);
        Homework03Thread2 t3 = new Homework03Thread2(myData);
        Homework03Thread2 t4 = new Homework03Thread2(myData);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        t3.start();
        t4.start();
    }
}
