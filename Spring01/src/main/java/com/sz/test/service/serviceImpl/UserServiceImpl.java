package com.sz.test.service.serviceImpl;

import com.sz.test.dao.UserDao;
import com.sz.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class UserServiceImpl implements UserService{
    //定义成员变量，会被Spring注入
    UserDao userDao;
    //设值注入必须要有set方法和无参构造方法
    public void setUserDao(UserDao userDao) {
        System.out.println("set注入方法被调用！");
        this.userDao = userDao;
    }
    public UserServiceImpl(){}
    //构造注入的构造方法
    public UserServiceImpl(UserDao userDao) {
        System.out.println("构造注入方法被调用！");
        this.userDao = userDao;
    }

    @Override
    public int addUser() {
        return userDao.addUser();
    }
}
