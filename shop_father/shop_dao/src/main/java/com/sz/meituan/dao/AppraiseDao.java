package com.sz.meituan.dao;

import com.sz.meituan.dbutils.DBUtils;
import com.sz.meituan.model.Appraise;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AppraiseDao {
    private QueryRunner runner = new QueryRunner(DBUtils.getDataSource());
    //添加评论
    public int addAppriseDao(Appraise appraise){
        String sql = "insert into t_appraise values(s_appraise_id.nextval,?,?,?,sysdate)";
        try {
            return runner.update(sql,appraise.getFid(),appraise.getContent(),appraise.getUserid());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    //根据菜id搜索评论
    public List<Appraise> selAppraiseByFid(int fid){
        String sql = "select a.*,u.username from T_APPRAISE a,t_user u where a.userid=u.userid and a.fid=? order by appraiseid desc";
        try {
            return runner.query(sql,new BeanListHandler<>(Appraise.class),fid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
