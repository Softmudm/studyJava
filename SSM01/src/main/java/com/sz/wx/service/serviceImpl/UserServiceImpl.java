package com.sz.wx.service.serviceImpl;

import com.sz.wx.dao.UserDao;
import com.sz.wx.entity.User;
import com.sz.wx.service.UserService;
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
}
