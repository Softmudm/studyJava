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

    public List<User> selectByUsername(String username){
        UserExample example = new UserExample();
        example.createCriteria().andUsernameLike("%"+username+"%");
        return userMapper.selectByExample(example);
    }

    @Override
    public User getUserByUserid(Integer userid) {
        return userMapper.selectByPrimaryKey(userid);
    }

    @Override
    public int deleteUserByUserid(Integer userid) {
        return userMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }
}
