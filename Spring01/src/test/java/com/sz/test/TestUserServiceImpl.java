package com.sz.test;

import com.sz.test.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl {
    //对注入结果测试
    @Test
    public void addUser(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService us = (UserService) ac.getBean("UserServiceImpl");
        us.addUser();
    }
}
