package com.sz.meituan.dao;

import com.sz.meituan.dbutils.DBUtils;
import com.sz.meituan.model.Order;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    private QueryRunner runner = new QueryRunner(DBUtils.getDataSource());
    //插入表之前得到订单id
    public int getOrderid(){
        try {
            return Integer.parseInt(String.valueOf(runner.query("select s_order_orderid.nextval from dual",new ScalarHandler())));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    //插入订单总表
    public int addOrder(Order order){
        String sql = "insert into t_order values(?,?,?,?,?,?,?,?,?)";
        try {
            return runner.update(sql,order.getOrderid(),order.getUserid(),order.getTotalmoney(),order.getRemark(),order.getStatus(),order.getUsername(),order.getUsertel(),order.getUseraddr(),order.getTotalnum());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    //根据订单id查询订单
    public Order selOrderByid(int orderid){
        String sql = "select * from t_order where orderid=?";
        try {
            return runner.query(sql,new BeanHandler<>(Order.class),orderid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //根据用户id查询订单
    public List<Order> selOrderByUserid(int userid){
        String sql = "select * from t_order where userid=?";
        try {
            return runner.query(sql,new BeanListHandler<>(Order.class),userid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //根据订单id修改订单状态
    public int updateOrderByid(int orderid,String status){
        String sql = "update t_order set status=? where orderid=?";
        try {
            return runner.update(sql,status,orderid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

}
