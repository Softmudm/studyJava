package com.sz.wx.service;

import com.sz.wx.model.User;

public interface UserService {
    //登录
    public User getUserByNameAndPwd(User user);
    //注册
    public int addUser(User user);
}
