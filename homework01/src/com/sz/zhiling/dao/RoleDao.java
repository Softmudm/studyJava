package com.sz.zhiling.dao;

import com.sz.zhiling.entity.Role;
import com.sz.zhiling.util.JDBC;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class RoleDao {
    private static QueryRunner runner = new QueryRunner(JDBC.getComboPooledDataSource());

    //查询角色表
    public List<Role> selectAllRole(){
        String sql = "select t_roleid roleid,t_rolename rolename from t_role";
        try {
            return runner.query(sql,new BeanListHandler<>(Role.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
