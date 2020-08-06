package com.sz.test.dao;

import com.sz.test.modal.Conference;
import com.sz.test.util.Page;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

//持久层注解
@Repository
public class ConferenceDao {
    @Autowired
    private  QueryRunner runner;

    public QueryRunner getRunner() {
        return runner;
    }

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
