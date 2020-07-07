package com.sz.zhiling;

import java.sql.*;

public class OracleUtil {
    private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static String URL= "jdbc:oracle:thin:@localhost:1521:orcl";
    private static String USER = "wx";
    private static String PWD = "123456";

    public static Connection getConnection(){
        try {
            //注册驱动
            Class.forName(DRIVER);
            //获取连接
            return DriverManager.getConnection(URL,USER,PWD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void closeAll(ResultSet rs, Statement st, Connection con){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (st != null){
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (con != null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
