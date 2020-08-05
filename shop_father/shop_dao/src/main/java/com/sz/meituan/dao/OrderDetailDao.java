package com.sz.meituan.dao;

import com.sz.meituan.dbutils.DBUtils;
import com.sz.meituan.model.OrderDetail;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailDao {
    private QueryRunner runner = new QueryRunner(DBUtils.getDataSource());
    //插入订单详情表
    public int addOrderDetail(OrderDetail orderDetail){
        String sql = "insert into t_order_detail values(s_tod_odid.nextval,?,?,?,?,?)";
        try {
            return runner.update(sql,orderDetail.getOrderid(),orderDetail.getFid(),orderDetail.getFnumber(),orderDetail.getFname(),orderDetail.getFprice());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    //根据订单id查询该订单下的详细列表
    public List<OrderDetail> selDetailByOid(int orderid){
        String sql = "select * from t_order_detail where orderid=?";
        try {
            return runner.query(sql,new BeanListHandler<>(OrderDetail.class),orderid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
