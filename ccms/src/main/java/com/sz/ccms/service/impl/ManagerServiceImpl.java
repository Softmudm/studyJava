package com.sz.ccms.service.impl;

import com.sz.ccms.dao.ManagerDao;
import com.sz.ccms.entity.Manager;
import com.sz.ccms.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerDao managerDao;

    @Override
    public Manager getManager(Manager manager) {
        return managerDao.selectOne(manager);
    }
}
