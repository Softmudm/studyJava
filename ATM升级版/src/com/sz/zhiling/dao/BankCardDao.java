package com.sz.zhiling.dao;

import com.sz.zhiling.entity.BankCard;
import com.sz.zhiling.util.JDBC;
import oracle.jdbc.OracleTypes;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankCardDao {
    private static QueryRunner runner = new QueryRunner(JDBC.getComboPooledDataSource());

    public BankCard selectBCById(String cardid){
        Connection con = JDBC.getConnection();
        String sql = "select * from BankCard where cardid=?";
        BankCard bc = null;
        try {
            bc = runner.query(sql,new BeanHandler<>(BankCard.class),cardid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bc;
    }

    public int addBankCard(BankCard bankCard){
        Connection con = JDBC.getConnection();
        String sql = "insert into BankCard value(s_bankcard.nextval,?,?,?)";
        try {
            return runner.update(sql,
                    bankCard.getCardpwd(),
                    bankCard.getBalance(),
                    bankCard.getMasterid());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int updateBankCardById(BankCard bankCard){
        Connection con = JDBC.getConnection();
        String sql = "update BankCard set cardpwd=?,balance=?,masterid=? where cardid=?";
        try {
            return runner.update(sql,
                    bankCard.getCardpwd(),
                    bankCard.getBalance(),
                    bankCard.getMasterid(),
                    bankCard.getCardid());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public String turnMoney(String s1,String s2,float money){
        Connection con = JDBC.getConnection();
        String sql = "{call usp_bankcard_turn(?,?,?,?)}";
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(sql);
            cs.setString(1,s1);
            cs.setString(2,s2);
            cs.setFloat(3,money);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.execute();
            return cs.getString(4);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBC.closeAll(null,cs,con);
        }
        return null;
    }
}
