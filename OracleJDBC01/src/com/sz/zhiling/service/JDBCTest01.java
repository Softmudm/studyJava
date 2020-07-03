package com.sz.zhiling.service;

import java.sql.*;

public class JDBCTest01 {
    static final String ORACLEURL= "jdbc:oracl:thin:@localhost:1521:orcl";
    static final String USER = "wx";
    static final String PSW = "123456";
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //注册驱动
            /*Driver driver = new oracle.jdbc.driver.OracleDriver();在这个类中有静态代码块实现这一步
            DriverManager.registerDriver(driver);*/
            //加载类会运行静态代码块，1.调用静态方法2.实例化一个对象3.Class.foName()
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //获取连接 oracle.jdbc.driver.T4CConnection@3d71d552
            conn = DriverManager.getConnection(ORACLEURL,USER,PSW);
            //获取数据库操作对象
            statement = conn.createStatement();
            //执行SQL语句
            //-------------------增删改-------------------------
            String sql = "insert into t_users values(5,'李四')";
            int n = statement.executeUpdate(sql);
            if(n != 0){
                System.out.println("成功");
            }else{
                System.out.println("失败");
            }
            //--------------------查询-------------------------
            String sql1 = "select t_userid userid,t_username username from t_users";
            rs = statement.executeQuery(sql1);
            //rs.next()返回一个boolean值，true表示有值，false表示没有值
            /*while(rs.next()){
                //rs.getString()以String类型返回查询到的数据，括号里面是列下标从1开始
                String userid = rs.getString(1);
                String username = rs.getString(2);
                System.out.println(userid+","+username);
            }*/
            while(rs.next()){
                //rs.getString()括号里面还可以是列名(别名)推荐用这种方法。
                String userid = rs.getString("userid");
                String username = rs.getString("username");
                System.out.println(userid+","+username);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            try {
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(statement != null){
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
