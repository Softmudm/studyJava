package com.sz.zhiling.service.impl;

import com.sz.zhiling.dao.ConferenceDao;
import com.sz.zhiling.entity.Conference;
import com.sz.zhiling.service.ConferenceService;
import com.sz.zhiling.util.Page;

public class ConferenceServiceImpl implements ConferenceService {

    private ConferenceDao conferenceDao = new ConferenceDao();
    @Override
    public Page<Conference> selPage(int pageno) {
        return conferenceDao.selPage(pageno);
    }

    @Override
    public Conference selConferenceBySerialId(int serialId) {
        return conferenceDao.selConferenceBySerialId(serialId);
    }

    @Override
    public int addConference(Conference conference) {
        return conferenceDao.addConference(conference);
    }

    @Override
    public int updateConference(Conference conference) {
        return conferenceDao.updateConference(conference);
    }

    @Override
    public int delConference(int serialId) {
        return conferenceDao.delConference(serialId);
    }
}
