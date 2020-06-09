package com.sz.zhiling.ThreadTest02;

/**
 * 继承Thread实现多线程
 */
public class Homework02 extends Thread {
    public static int ticketNum = 100;

    public synchronized void goThread(){
        this.notify();
    }
    public synchronized void stopThread(){
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {//线程运行时的代码
        while (true){
            synchronized (this){
                notify();
                if(ticketNum>0){
                    System.out.println(Thread.currentThread().getName()+"卖出了第"+ticketNum+"张票，剩余"+(--ticketNum)+"张票！");
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
