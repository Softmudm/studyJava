package com.wx.exam.dao;

import com.wx.exam.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    //查询所有用户
    public List<User> selectUserList();
    //添加用户
    public int addUser(User user);
    //添加用户
    public int addUser1(String uname,String upwd);
}
