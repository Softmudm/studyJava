package com.sz.zhiling.RunnableTest01;

/**
 * 三个线程，分别求和(1~100)(100~200)(200~300),最后主线程求总和
 */
public class Master {
    public static void main(String[] args) {
        Homework01 hw1 = new Homework01(0,100);
        Homework01 hw2 = new Homework01(100,200);
        Homework01 hw3 = new Homework01(200,300);

        Thread t1 = new Thread(hw1);
        Thread t2 = new Thread(hw2);
        Thread t3 = new Thread(hw3);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(hw1.getCount()+hw2.getCount()+hw3.getCount());
    }
}
