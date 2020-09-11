package com.sz.user2.service.serviceImpl;

import com.sz.user2.dao.UserMapper;
import com.sz.user2.model.User;
import com.sz.user2.model.UserExample;
import com.sz.user2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUseridIsNotNull();
        return userMapper.selectByExample(example);
    }

    @Override
    public User getUserByUserId(Integer userId) {
        if(userId==null) {
            return null;
        }else{
            return userMapper.selectByPrimaryKey(userId);
        }
    }
}
