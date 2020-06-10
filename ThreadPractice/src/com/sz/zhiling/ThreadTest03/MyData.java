package com.sz.zhiling.ThreadTest03;

public class MyData {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public synchronized void add(){
        for (int i = 0; i < 10 ; i++) {
            ++num;
            System.out.print(num+"\t");
        }
        System.out.println();
    }
    public synchronized void mins(){
        for (int i = 0; i < 10; i++) {
            --num;
            System.out.print(num+"\t");
        }
        System.out.println();
    }

    public MyData(int num) {
        this.num = num;
    }

    public MyData() {
    }
}
