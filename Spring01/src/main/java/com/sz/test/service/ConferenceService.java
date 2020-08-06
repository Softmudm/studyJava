package com.sz.test.service;

import com.sz.test.modal.Conference;
import com.sz.test.util.Page;

public interface ConferenceService {
    //分页查询
    public Page<Conference> selPage(int pageno);
    //根据serialId查询会议室
    public Conference selConferenceBySerialId(int serialId);
    //增加会议室
    public int addConference(Conference conference);
    //修改会议室
    public int updateConference(Conference conference);
    //删除会议室
    public int delConference(int serialId);
}
