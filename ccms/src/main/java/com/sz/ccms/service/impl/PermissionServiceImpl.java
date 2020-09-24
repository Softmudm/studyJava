package com.sz.ccms.service.impl;

import com.sz.ccms.dao.PermissionDao;
import com.sz.ccms.entity.Permission;
import com.sz.ccms.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionDao permissionDao;
    @Override
    public List<String> getPermissionIdByRoleId(String roleId) {
        return permissionDao.getPermissionIdByRoleId(roleId);
    }

    @Override
    public List<Permission> getAll() {
        return permissionDao.selectAll();
    }
}
