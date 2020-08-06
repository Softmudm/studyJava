package com.sz.test.service.serviceImpl;

import com.sz.test.dao.ConferenceDao;
import com.sz.test.modal.Conference;
import com.sz.test.service.ConferenceService;
import com.sz.test.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//业务层注解
@Service
public class ConferenceServiceImpl implements ConferenceService {
    //属性自动(Spring容器)注入注解
    @Autowired
    private ConferenceDao conferenceDao;
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
