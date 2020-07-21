package com.sz.zhiling.controller;

import com.sz.zhiling.entity.User;
import com.sz.zhiling.util.JDBC;
import com.sz.zhiling.util.Page;
import org.apache.commons.dbutils.QueryRunner;

import java.lang.reflect.Field;

public class TestPage {
    public static void main(String[] args) {
        QueryRunner runner = new QueryRunner(JDBC.getComboPooledDataSource());
        String sql = "select u.t_userid userid,u.t_username username,r.t_roleid roleid," +
                "r.t_rolename rolename from t_users u left join t_role r on u.t_roleid=r.t_roleid " +
                "order by t_userid asc";
        Page<User> pu = new Page<>(2,5,sql,runner,User.class);
        for (User user : pu.getDate()) {
            System.out.println(user);
        }
        for (Field d : pu.getClass().getDeclaredFields()) {
            try {
                d.setAccessible(true);
                System.out.println(d.get(pu));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
