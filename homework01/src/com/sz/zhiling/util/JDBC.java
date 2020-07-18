package com.sz.zhiling.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
    public static ComboPooledDataSource getComboPooledDataSource(){
        return comboPooledDataSource;
    }
    public static Connection getConnection(){
        try {
            return comboPooledDataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static void closeAll(ResultSet rs, Statement st,Connection con){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(st != null){
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(con != null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
