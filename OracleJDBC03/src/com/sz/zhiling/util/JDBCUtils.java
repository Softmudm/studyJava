package com.sz.zhiling.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
    //创建连接池对象
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();

    //获取连接池对象方法
    public static ComboPooledDataSource getDateSource() {
        return cpds;
    }

    //获取连接方法
    public static Connection getConnection() {
        try {
            return cpds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //关闭连接
    public static void closeAll(ResultSet rs, Statement st, Connection ct) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (ct != null) {
                ct.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
