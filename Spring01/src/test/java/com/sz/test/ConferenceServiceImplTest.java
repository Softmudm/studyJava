package com.sz.test;

import com.sz.test.service.serviceImpl.ConferenceServiceImpl;
import com.sz.test.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//使用注解来自动注入属性
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ConferenceServiceImplTest {
    @Autowired
    ConferenceServiceImpl conferenceService;
    //注意：测试时只能通过Spring上下文获取实例对象
    //     使用new和反射都会破坏Spring的单例模式，拿到的对象不是注入过的那个。
    @Test
    public void selPageTest(){
        Page page = conferenceService.selPage(2);
        System.out.println("总页数："+page.getTotalpage());
        System.out.println("总条数："+page.getTotalnum());
        System.out.println("当前页："+page.getPageno());
        System.out.println("页面大小："+page.getPagesize());
        System.out.println("数据：");
        for (Object o : page.getData()) {
            System.out.println(o);
        }
    }
}
