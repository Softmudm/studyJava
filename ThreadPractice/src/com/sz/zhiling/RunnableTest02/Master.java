package com.sz.zhiling.RunnableTest02;

/**
 *两个窗口一起卖100张票，轮流卖。
 */
public class Master {
    public static void main(String[] args) {
        Homework02 hw2 = new Homework02();

        Thread t1 = new Thread(hw2);
        Thread t2 = new Thread(hw2);
        t1.setName("第一个窗口");
        t2.setName("第二个窗口");
        t1.start();
        t2.start();
    }
}
