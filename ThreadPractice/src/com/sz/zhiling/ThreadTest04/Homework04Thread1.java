package com.sz.zhiling.ThreadTest04;

public class Homework04Thread1 extends Thread{
    @Override
    public void run() {
        for (int i = 'a'; i <= 'z'; i++) {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print((char)i);
        }
    }
}
