package com.wx.exam.sevice;

import com.wx.exam.entity.User;
import com.wx.exam.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void selectUserListTest(){
        List<User> list = userService.selectUserList();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void addUserTest(){
        User user = new User("李四","lisi");
        System.out.println(userService.addUser(user));
        System.out.println(user.getUid());
    }

    @Test
    public void addUserTest1(){
        System.out.println(userService.addUser1("王五","wangwu"));
    }

}
