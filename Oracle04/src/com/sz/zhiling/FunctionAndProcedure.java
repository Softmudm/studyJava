package com.sz.zhiling;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FunctionAndProcedure {
    public static void main(String[] args) {
        System.out.println(callFunction(2,2));
        System.out.println(callProcedure());
    }
    //调用数据库方法(两数字加减乘除的和)
    public static int callFunction(int a,int b){
        Connection conn = OracleUtil.getConnection();
        CallableStatement cs = null;
        try {
            String sql = "{?=call ftest1(?,?)}";
            cs = conn.prepareCall(sql);
            cs.setInt(2,2);
            cs.setInt(3,2);
            cs.registerOutParameter(1, OracleTypes.NUMBER);
            cs.execute();
            return cs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            OracleUtil.closeAll(null,cs,conn);
        }
        return -1;
    }
    //调用数据库存储过程(emp表中添加一条数据)
    public static String callProcedure(){
        Connection conn = OracleUtil.getConnection();
        CallableStatement cs = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        try {
            String sql = "{call usp_emp_addemp(?,?,to_date(?,'yyyy-mm-dd'),?,?,?)}";
            cs = conn.prepareCall(sql);
            cs.setString(1,"A00010");
            cs.setString(2,"名字");
            cs.setString(3,sdf.format(d));
            cs.setString(4,"F");
            cs.setString(5,"北京");
            cs.registerOutParameter(6,OracleTypes.VARCHAR);
            cs.execute();
            return cs.getString(6);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            OracleUtil.closeAll(null,cs,conn);
        }
        return null;
    }
}
