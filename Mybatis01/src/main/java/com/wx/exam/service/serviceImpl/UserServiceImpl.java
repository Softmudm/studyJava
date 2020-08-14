package com.wx.exam.service.serviceImpl;

import com.wx.exam.dao.UserDao;
import com.wx.exam.entity.User;
import com.wx.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> selectUserList() {
        return userDao.selectUserList();
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int addUser1(String uname,String upwd) {
        return userDao.addUser1(uname, upwd);
    }
}
