package com.wx.exam.service.serviceImpl;

import com.wx.exam.dao.UserDao;
import com.wx.exam.model.User;
import com.wx.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUser(String uname,String upwd) {
        return userDao.getUser(uname,upwd);
    }
}
