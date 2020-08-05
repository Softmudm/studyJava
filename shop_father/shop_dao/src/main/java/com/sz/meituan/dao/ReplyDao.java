package com.sz.meituan.dao;

import com.sz.meituan.dbutils.DBUtils;
import com.sz.meituan.model.Reply;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ReplyDao {
    private QueryRunner runner = new QueryRunner(DBUtils.getDataSource());
    //添加一个回复
    public int addReply(Reply reply){
        String sql = "insert into t_reply values(s_reply_replyid.nextval,?,?,?,sysdate)";
        try {
            return runner.update(sql,reply.getAppraiseid(),reply.getUserid(),reply.getContent());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    //根据评论id查询回复
    public List<Reply> selReplyByAppraiseid(int appraiseid){
        String sql = "select r.*,u.username from t_reply r,t_user u where r.userid=u.userid and r.appraiseid=?";
        try {
            return runner.query(sql,new BeanListHandler<>(Reply.class),appraiseid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
