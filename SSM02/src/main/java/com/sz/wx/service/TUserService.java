package com.sz.wx.service;

import com.sz.wx.entity.TUser;

import java.util.List;

public interface TUserService {
    //查询所有用户
    public List<TUser> getTUserList();
    //关键字查询
    public List<TUser> searchTUserList(String uname);
    //添加用户
    public int addUser(TUser user);
    //删除用户
    public int delUsers(List<Integer> ids);
}
