package com.sz.softmudm.dynamicproxy;

import com.sz.softmudm.targetclass.Computer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 * 有两种方法实现：1.jdk动态代理(JDK自带)原理是实现接口   2.cglib动态代理(第三方包)原理是继承目标类，一般用在框架
 * 这里使用jdk动态代理实现
 * 动态代理相对于静态代理优点
 * 1少写添加相同逻辑的方法
 * 2不用每个实现类一个代理类，可以共用这一个代理类，只需传入实现类就可动态生成代理类
 */
//必须实现InvocationHandler,增加的逻辑写在invoke中
public class DynamicProxy implements InvocationHandler {
    //这里和静态代理一样
    private Computer computer;
    //这里和静态代理一样
    public DynamicProxy(Computer computer) {
        this.computer = computer;
    }

    //这个方法用来生成动态代理实例对象
    //具体逻辑由jsk实现封装在Proxy类的newProxyInstance静态方法中实现
    //1---第一个参数是指定代理类的类加载器（我们传入被代理类的类加载器）
    //2---第二个参数是代理类需要实现的接口（我们传入被代理类实现的接口，这样生成的代理类和被代理类就实现了相同的接口）
    //3---第三个参数是InvocationHandler，用来处理方法的调用。这里传入调用方法的对象就行
    public Computer getComputer(){
        Computer computer = (Computer) Proxy.newProxyInstance(this.computer.getClass().getClassLoader(), this.computer.getClass().getInterfaces(), this);
        return computer;
    }
    //这里是为目标类添加的操作
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理添加的方法前操作aaa");
        Object o = method.invoke(computer,args);
        System.out.println("动态代理添加的方法后操作zzz");
        return o;
    }
}
