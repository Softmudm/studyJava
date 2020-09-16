package com.sz.user.service.impl;

import com.sz.commons.utils.MD5Util;
import com.sz.user.dao.UserMapper;
import com.sz.user.model.User;
import com.sz.user.model.UserExample;
import com.sz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByAccountAndPassword(String account, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);
        criteria.andPasswordEqualTo(MD5Util.md5(password));
        List<User> list = userMapper.selectByExample(example);
        User user = (list==null||list.size()==0)?null:list.get(0);
        return user;
    }
}
