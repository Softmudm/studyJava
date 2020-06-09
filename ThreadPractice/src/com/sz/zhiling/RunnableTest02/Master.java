package com.sz.zhiling.RunnableTest02;

/**
 *两个窗口一起卖100张票，轮流卖。
 */
public class Master {
    public static void main(String[] args) {
        Homework02 hw2 = new Homework02();

        (new Thread(hw2)).start();
        (new Thread(hw2)).start();
    }
}
