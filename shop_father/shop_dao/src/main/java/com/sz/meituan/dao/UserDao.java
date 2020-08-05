package com.sz.meituan.dao;

import com.sz.meituan.dbutils.DBUtils;
import com.sz.meituan.model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    private QueryRunner runner = new QueryRunner(DBUtils.getDataSource());
    //根据账号密码返回用户信息
    public User selUserByNameAndPwd(String username,String userpwd){
        String sql = "select * from t_user where username=? and userpwd=?";
        try {
            return runner.query(sql,new BeanHandler<>(User.class),username,userpwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    //验证用户名是否重复
    public User selUserByName(String username){
        String sql = "select * from t_user where username=? ";
        try {
            return runner.query(sql,new BeanHandler<>(User.class),username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
