package com.sz.zhiling.util;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

public class OracleJDBC {

    //获取ORACLE连接方法
    public static Connection getConnection(){
        //使用资源绑定器绑定属性配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");
        //注册驱动，获取连接
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //关闭结果集，操作数据库对象，数据库连接
    public static void closeAll(ResultSet resultSet,Statement statement, Connection connection){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //增删改方法
    public static int DML(String sql,Object ... args) {//Object ... args 可变参数列，类型全是Object
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll(null,ps,connection);
        }
        return 0;
    }

    //查询方法
    public static <T> List<T> DQL(Class<T> clazz,String sql,Object ... args){
        List<T> list = new ArrayList<>();
        T entity = null;
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            resultSet = ps.executeQuery();
            //获取结果集列数
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnNum = rsmd.getColumnCount();
            while(resultSet.next()){
                //用参数clazz来实例化一个T对象
                entity = clazz.newInstance();
                for (int i = 1; i <= columnNum; i++) {
                    //获取列名
                    String columnName = rsmd.getColumnName(i);
                    Object object = resultSet.getObject(i);
                    //赋值给对象
                    BeanUtils.setProperty(entity,columnName.toLowerCase(),object);
                }
                list.add(entity);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return list;
    }
}
