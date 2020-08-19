package com.sz.wx.dao;

import com.sz.wx.entity.User;

import java.util.List;

public interface UserDao {
    //查询所有用户
    public List<User> selectUserList();
    //添加用户
    public int addUser(User user);
}
