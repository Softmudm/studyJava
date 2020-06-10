package com.sz.zhiling.ThreadTest04;

public class Master {
    public static void main(String[] args) {
        Homework04Thread1 t1 = new Homework04Thread1();
        Homework04Thread2 t2 = new Homework04Thread2();
        t1.start();
        t2.start();
    }
}
