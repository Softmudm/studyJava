package com.sz.test;

import com.sz.test.dao.ConferenceDao;
import com.sz.test.modal.Conference;
import com.sz.test.service.ConferenceService;
import com.sz.test.service.serviceImpl.ConferenceServiceImpl;
import com.sz.test.util.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ConferenceDaoTest {

    @Test
    public void selPageTest(){
        //注意：测试时只能通过Spring上下文获取实例对象
        //     使用new和反射都会破坏Spring的单例模式，拿到的对象不是注入过的那个。
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("-----容器创建-----");
        ConferenceDao conferenceDao = (ConferenceDao)ac.getBean("conferenceDao");
        System.out.println(conferenceDao.getRunner());
    }
}
