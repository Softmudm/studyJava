package com.sz.zhiling.dao;

import com.sz.zhiling.entity.Like;
import com.sz.zhiling.util.JDBC;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikeDao {
    private static QueryRunner runner = new QueryRunner(JDBC.getComboPooledDataSource());

    //查询所有爱好
    public List<Like> selectAllLikes(){
        String sql = "select t_likeid likeid,t_likename likename from t_like";
        try {
            return runner.query(sql,new BeanListHandler<>(Like.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //根据id查询爱好id集合
    public ArrayList<Integer> selectLikeidsById(int userid){
        String sql = "select t_likeid from t_users_like where t_userid=?";
        try {
            return (ArrayList<Integer>)(List)runner.query(sql,new ColumnListHandler(),userid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //添加用户-爱好
    public int addUserLike(int userid,int likeid){
        String sql = "insert into t_users_like values(?,?)";
        try {
            return runner.update(sql,userid,likeid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    //删除用户-爱好
    public int deleteUserAndLike(int userid){
        String sql = "delete from t_users_like where t_userid=?";
        try {
            return runner.update(sql,userid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    //用户爱好表中删除单个用户
    public int deleteUsersLike(int userid){
        String sql = "delete from t_users_like where t_userid=?";
        try {
            return runner.update(sql,userid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    //用户爱好表中删除多个用户
    public int deleteUsersLike(String userids){
        String sql = "delete from t_users_like where t_userid in ("+userids+")";
        try {
            return runner.update(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

}
