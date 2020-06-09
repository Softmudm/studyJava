package com.sz.zhiling.RunnableTest01;

/**
 * 实现Runnable接口创建线程
 */
public class Homework01 implements Runnable {

    private int startNum;//开始数字
    private int endNum;//结束数字
    private int count;//结果

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public int getEndNum() {
        return endNum;
    }

    public void setEndNum(int endNum) {
        this.endNum = endNum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Homework01(int startNum, int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    public Homework01() {
    }

    @Override
    public void run() {//线程运行时的代码
        for (int i = startNum+1; i <= endNum ; i++) {
            count += i;
            /*try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}
