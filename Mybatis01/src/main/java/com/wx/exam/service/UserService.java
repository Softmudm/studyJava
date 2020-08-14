package com.wx.exam.service;

import com.wx.exam.entity.User;

import java.util.List;

public interface UserService {
    //查询所有用户
    public List<User> selectUserList();
    //添加用户
    public int addUser(User user);
    //添加用户
    public int addUser1(String uname,String upwd);
}
