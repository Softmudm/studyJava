package com.sz.wx.service.serviceImpl;

import com.sz.wx.dao.UserMapper;
import com.sz.wx.model.User;
import com.sz.wx.model.UserExample;
import com.sz.wx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    //登录
    @Override
    public User getUserByNameAndPwd(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andUserpasswordEqualTo(user.getUserpassword());
        List<User> list = userMapper.selectByExample(example);
        if(list.size()==0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }
}
