package com.sz.zhiling.util;

import com.sz.zhiling.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcutil {
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/exam01";
    private static String USER = "root";
    private static String PASSWORD = "root";
    public static Connection getConnection(){
        try {
            //注册驱动
            Class.forName(DRIVER);
            //获取连接
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static void closeAll(ResultSet rs, Statement st, Connection cn){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}