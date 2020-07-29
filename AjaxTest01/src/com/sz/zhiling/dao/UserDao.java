package com.sz.zhiling.dao;

import com.sz.zhiling.entity.User;
import com.sz.zhiling.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    //查询用户名
    public User selUserByName(String username){
        Connection connection = DBUtil.getConnection();
        String sql = "select username,userpwd from t_user where username=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            //预处理sql语句
            ps = connection.prepareStatement(sql);
            //设置参数
            ps.setString(1,username);
            //接收返回结果集
            rs = ps.executeQuery();
            while(rs.next()){
                user = new User(rs.getString("username"),rs.getString("userpwd"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll(rs,ps,connection);
        }
        return user;
    }
}
