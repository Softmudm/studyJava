package com.sz.user2.service;

import com.sz.user2.model.User;

import java.util.List;

public interface UserService {
    //查询所有用户
    public List<User> getAllUser();
    //根据userid查询单个用户
    public User getUserByUserId(Integer userId);
}
