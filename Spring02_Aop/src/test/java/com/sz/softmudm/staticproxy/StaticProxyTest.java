package com.sz.softmudm.staticproxy;

import com.sz.softmudm.targetclass.Computer;
import com.sz.softmudm.targetclass.ComputerImpl;
import org.junit.Test;


//测试静态代理类
public class StaticProxyTest {
    @Test
    public void allTest(){
        //这里依旧是computer接口引用
        //只是实际上是调用的代理类实现功能增强
        //这里传入的是代理类
        Computer computer = new StaticProxy(new ComputerImpl());
        computer.add(4,2);
        computer.subtract(4,2);
        computer.multiply(4,2);
        computer.divide(4,2);
    }

}
