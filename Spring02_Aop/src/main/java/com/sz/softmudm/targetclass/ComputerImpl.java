package com.sz.softmudm.targetclass;

import org.springframework.stereotype.Component;

@Component
//目标类
public class ComputerImpl implements Computer{
    //加
    public int add(int n1,int n2){
        System.out.println("执行加法中。。");
        return n1+n2;
    }
    //减
    public int subtract(int n1,int n2){
        System.out.println("执行减法中。。");
        return n1-n2;
    }
    //乘
    public int multiply(int n1,int n2){
        System.out.println("执行乘法中。。");
        return n1*n2;
    }
    //除
    public int divide(int n1,int n2){
        System.out.println("执行除法中。。");
        return n1/n2;
    }
}
