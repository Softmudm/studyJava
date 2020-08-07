package com.sz.softmudm.dynamicproxy;

import com.sz.softmudm.targetclass.Computer;
import com.sz.softmudm.targetclass.ComputerImpl;
import org.junit.Test;

public class DynamicProxyTest {
    @Test
    public void allTest(){
        Computer c1 = new ComputerImpl();
        //传入目标类构造处理类在调用getComputer()方法得到动态代理类
        Computer computer = new DynamicProxy(c1).getComputer();
        computer.add(4,2);
        computer.subtract(4,2);
        computer.multiply(4,2);
        computer.divide(4,2);
    }
}
