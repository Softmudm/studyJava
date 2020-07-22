package com.sz.zhiling.dao;

import com.sz.zhiling.entity.Visit;
import com.sz.zhiling.util.JDBC;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class VisitDao {
    private static QueryRunner runner = new QueryRunner(JDBC.getComboPooledDataSource());
    //增加
    public int addVisit(Visit visit){
        String sql = "insert into telvisit values(s_telvisit_vid.nextval,?,to_date(?,'yyyy-mm-dd HH24:mi:ss'),?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(visit.getVdate()));
        try {
            return runner.update(sql,visit.getVname(),sdf.format(visit.getVdate()),visit.getVtype(),visit.getVresult(),visit.getVmethod(),visit.getComid());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    //根据公司id查询所有回访
    public List<Visit> selVisitByComid(int comid){
        String sql = "select * from telvisit where comid=? order by vid desc";
        try {
            return runner.query(sql,new BeanListHandler<>(Visit.class),comid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
