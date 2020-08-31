package com.sz.wx.service;

import com.sz.wx.model.User;
import com.sz.wx.model.UserExample;

import java.util.List;

public interface UserService {
    List<User> selectByUsername(String username);

    User getUserByUserid(Integer userid);

    int deleteUserByUserid(Integer userid);

    int updateUser(User user);

    int addUser(User user);
}
