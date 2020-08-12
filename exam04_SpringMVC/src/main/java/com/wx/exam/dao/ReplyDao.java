package com.wx.exam.dao;

import com.wx.exam.model.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReplyDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    //根据评论ID查询回复列表
    public List<Reply> getReplyListByKid(int kid){
        String sql = "select r.*,u.uname runame from t_reply r,t_user u where r.ruid=u.uid and r.kid=? order by r.rid desc";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Reply.class),kid);
    }
    //添加回复
    public int addReply(Reply reply){
        String sql = "insert into t_reply(kid,ruid,rmsg,rdate) values(?,?,?,sysdate())";
        return jdbcTemplate.update(sql,reply.getKid(),reply.getRuid(),reply.getRmsg());
    }
}
