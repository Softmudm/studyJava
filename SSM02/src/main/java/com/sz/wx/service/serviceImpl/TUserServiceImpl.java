package com.sz.wx.service.serviceImpl;

import com.sz.wx.dao.TUserMapper;
import com.sz.wx.entity.TUser;
import com.sz.wx.entity.TUserExample;
import com.sz.wx.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUserServiceImpl implements TUserService {
    @Autowired
    TUserMapper tUserMapper;

    public List<TUser> getTUserList(){
        return tUserMapper.selectByExample(null);
    }

    @Override
    public List<TUser> searchTUserList(String uname) {
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andUnameLike("%"+uname+"%");
        return tUserMapper.selectByExample(example);
    }

    @Override
    public int addUser(TUser user) {
        return tUserMapper.insertSelective(user);
    }

    @Override
    public int delUsers(List<Integer> uids) {
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andUidIn(uids);
        return tUserMapper.deleteByExample(example);
    }
}
