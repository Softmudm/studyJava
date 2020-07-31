package com.sz.zhiling.dao;

import com.sz.zhiling.entity.Conference;
import com.sz.zhiling.util.DBUtil;
import com.sz.zhiling.util.Page;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class ConferenceDao {
    private QueryRunner runner = new QueryRunner(DBUtil.getDataSource());
    //分页查询
    public Page<Conference> selPage(int pageno){
        String sql = "select * from t_conference order by serialid";
        return new Page<>(pageno,4,sql,runner,Conference.class);
    }
    //根据serialId查询会议室
    public Conference selConferenceBySerialId(int serialId){
        String sql = "select * from t_conference where serialId=?";
        try {
            return runner.query(sql,new BeanHandler<>(Conference.class),serialId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    //增加会议室
    public int addConference(Conference conference){
        String sql = "insert into t_conference values(s_conference_serialid.nextval,?,?,?,?)";
        try {
            return runner.update(sql,conference.getConferenceId(),conference.getConferenceName(),conference.getConferenceAddr(),conference.getConferenceSize());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    //修改会议室
    public int updateConference(Conference conference){
        String sql = "update t_conference set conferenceid=?,conferencename=?,conferenceaddr=?,conferencesize=? where serialid=?";
        try {
            return runner.update(sql,conference.getConferenceId(),conference.getConferenceName(),conference.getConferenceAddr(),conference.getConferenceSize(),conference.getSerialId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    //删除会议室
    public int delConference(int serialId){
        String sql = "delete t_conference where serialid=?";
        try {
            return runner.update(sql,serialId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
