package com.sz.user.service;

import com.sz.user.model.User;

public interface UserService {
    //根据账号密码查询用户
    public User getUserByAccountAndPassword(String account, String password);
}
