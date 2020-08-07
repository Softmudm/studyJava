package com.sz.softmudm.staticproxy;

import com.sz.softmudm.targetclass.Computer;

//静态代理类
public class StaticProxy implements Computer{
    //定义一个接口引用用来存放接口实现类
    private Computer computer;
    //在实例化代理类时要传入一个{实现类}，因为代理类本身没有业务方法
    // 只是作为功能增强，或者访问控制
    public StaticProxy(Computer computer) {
        this.computer = computer;
    }

    @Override
    public int add(int n1, int n2) {
        System.out.println("方法前动作");
        int result = computer.add(n1,n2);
        System.out.println("方法后动作");
        return result;
    }

    @Override
    public int subtract(int n1, int n2) {
        System.out.println("方法前动作");
        int result = computer.subtract(n1,n2);
        System.out.println("方法后动作");
        return result;
    }

    @Override
    public int multiply(int n1, int n2) {
        System.out.println("方法前动作");
        int result = computer.multiply(n1,n2);
        System.out.println("方法后动作");
        return result;
    }

    @Override
    public int divide(int n1, int n2) {
        System.out.println("方法前动作");
        int result = computer.divide(n1,n2);
        System.out.println("方法后动作");
        return result;
    }
}
