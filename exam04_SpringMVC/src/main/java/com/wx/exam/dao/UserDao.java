package com.wx.exam.dao;

import com.wx.exam.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    //根据名称查询用户信息
    public User getUser(String uname,String upwd){
        String sql = "select * from t_user where uname=? and upwd=?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), uname, upwd);
        }catch (Exception e){
            return null;
        }
    }
}
