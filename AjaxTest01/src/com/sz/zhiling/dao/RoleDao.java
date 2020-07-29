package com.sz.zhiling.dao;

import com.sz.zhiling.entity.Role;
import com.sz.zhiling.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class RoleDao {
    private QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
    //查询所有角色
    public List<Role> selAllRole(){
        String sql = "select t_roleid roleId,t_rolename roleName from t_role";
        try {
            return runner.query(sql,new BeanListHandler<>(Role.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
