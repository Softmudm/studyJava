package com.sz.ccms.service.impl;

import com.sz.ccms.dao.RoleDao;
import com.sz.ccms.entity.Permission;
import com.sz.ccms.entity.Role;
import com.sz.ccms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;
    @Override
    public Role getRoleByRoleId(String roleId) {
        return roleDao.selectByPrimaryKey(roleId);
    }

    @Override
    public List<String> getRoleNameByPermissionId(String permissionId) {
        return roleDao.getRoleNameByPermissionId(permissionId);
    }
}
