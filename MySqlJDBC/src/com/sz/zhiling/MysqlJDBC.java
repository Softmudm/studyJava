package com.sz.zhiling;

import java.sql.*;
import java.util.function.DoubleToIntFunction;

public class MysqlJDBC {
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
    public static void closeAll(ResultSet rs, Statement st,Connection cn){
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
    public static void main(String[] args) {
        Connection cn = getConnection();
        String sql = "select s2.StuId,StuName,count(courseid),IFNULL(avg(score),0) " +
                     "from tblstudent s2 left join tblscore s1 on s1.StuId=s2.StuId group by StuId";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int num = rsmd.getColumnCount();
            while(rs.next()){
                for (int i = 1; i <=num ; i++) {
                    System.out.print(rs.getString(i)+" ");
                }
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll(rs,ps,cn);
        }
    }
}
