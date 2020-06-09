package com.sz.zhiling.RunnableTest02;

public class Homework02 implements Runnable{

    private int ticketNum = 100;//总票数

    public Homework02() {
    }

    @Override
    public void run() {
        while (true){
            synchronized (this){
                notify();
                if(ticketNum>0){
                    System.out.println(Thread.currentThread().getName()+"卖出了第"+ticketNum+"张票，剩余"+(--ticketNum)+"张票");
                }else{
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
