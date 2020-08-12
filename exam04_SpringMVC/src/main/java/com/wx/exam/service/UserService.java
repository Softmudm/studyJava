package com.wx.exam.service;

import com.wx.exam.model.User;

public interface UserService {
    //根据名称查询用户信息
    public User getUser(String uname,String upwd);
}
