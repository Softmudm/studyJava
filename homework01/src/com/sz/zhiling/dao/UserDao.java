package com.sz.zhiling.dao;

import com.sz.zhiling.entity.User;
import com.sz.zhiling.util.JDBC;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static QueryRunner runner = new QueryRunner(JDBC.getComboPooledDataSource());

    //查询总数
    public int countAll(String keyword){
        String sql = "select count(*) from t_users u left join t_role r on u.t_roleid=r.t_roleid " +
                "where u.t_userid like ? or u.t_username like ? or r.t_rolename like ?";
        keyword = "%"+keyword+"%";
        try {
            return Integer.parseInt(String.valueOf(runner.query(sql,new ScalarHandler(),keyword,keyword,keyword)));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    //分页查询
    public List<User> selectPageUsers(int pageno, int pagesize,String keyword){
        String sql = "select t_userid userid,t_username username,t_roleid roleid,t_rolename rolename from(" +
                "select rownum rn,ttt.* from(" +
                "select u.*,r.t_rolename from t_users u left join t_role r on u.t_roleid=r.t_roleid " +
                "where u.t_userid like ? or u.t_username like ? or r.t_rolename like ? order by t_userid asc"
                + ") ttt where rownum<="+pageno*pagesize +
                ") where rn>"+(pageno-1)*pagesize;
        List<User> list = new ArrayList<>();
        keyword = "%"+keyword+"%";
        try {
            list = runner.query(sql,new BeanListHandler<>(User.class),keyword,keyword,keyword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    //增加用户
    public int reUserid(){
        String sql = "select s_t_users_id.nextval from dual";
        try {
            return Integer.parseInt(String.valueOf(runner.query(sql,new ScalarHandler())));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    //增加用户
    public int addUser(User user){
        String sql = "insert into t_users values(?,?,?)";
        try {
            return runner.update(sql,user.getUserid(),user.getUsername(),user.getRoleid());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    //修改用户
    public int updateUser(User user){
        String sql = "update t_users set t_username=?,t_roleid=? where t_userid=?";
        try {
            return runner.update(sql,user.getUsername(),user.getRoleid(),user.getUserid());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    //删除用户
    public int deleteUser(int userid){
        String sql = "delete from t_users where t_userid=?";
        try {
            return runner.update(sql,userid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    //删除用户
    public int deleteUsers(String userids){
        String sql = "delete from t_users where t_userid in ("+userids+")";
        try {
            return runner.update(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
