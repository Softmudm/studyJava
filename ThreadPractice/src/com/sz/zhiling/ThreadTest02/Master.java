package com.sz.zhiling.ThreadTest02;

/**
 *两个窗口一起卖100张票，轮流卖。
 */
public class Master {
    public static void main(String[] args) {
        Homework02 t1 = new Homework02();
        Homework02 t2 = new Homework02();

        t1.setName("第一个窗口");
        t2.setName("第二个窗口");
        boolean flag1 = false;
        boolean flag2 = false;
        while (Homework02.ticketNum>0){
            if(Homework02.ticketNum%2==0){
                if(!flag1){
                    t1.start();
                    flag1 = true;
                }else{
                    t1.goThread();
                    t1.stopThread();
                }
            }else{
                if(!flag2){
                    t2.start();
                    flag2 = true;
                }else{
                    t2.goThread();
                    t2.stopThread();
                }
            }
        }
    }
}
