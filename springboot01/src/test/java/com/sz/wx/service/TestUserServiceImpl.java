package com.sz.wx.service;

import com.sz.wx.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserServiceImpl {
    @Autowired
    UserService userService;

    @Test
    public void testGetAllUser(){
        System.out.println(userService.selectByUsername(""));
    }
}
