package com.wx.exam.dao;

import com.wx.exam.model.Remark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RemarkDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    //查询所有评论列表
    public List<Remark> getRemarkList(){
        String sql = "select r.*,u.uname from t_remark r,t_user u where r.kuid=u.uid order by kid desc";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Remark.class));
    }
}
