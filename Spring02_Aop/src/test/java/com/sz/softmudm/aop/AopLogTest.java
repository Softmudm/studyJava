package com.sz.softmudm.aop;

import com.sz.softmudm.targetclass.Computer;
import com.sz.softmudm.targetclass.ComputerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopLogTest {
    //这里必须使用Spring管理的Bean才能实现Aop日志
    @Autowired
    Computer computerImpl;

    //测试aop实现日志功能
    @Test
    public void aopTest(){
        System.out.println("===================aop切面方法添加测试=======================");
        System.out.println(computerImpl.add(9,3));
    }
}
