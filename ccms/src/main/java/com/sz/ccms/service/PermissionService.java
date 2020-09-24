package com.sz.ccms.service;

import com.sz.ccms.entity.Permission;

import java.util.List;

public interface PermissionService {
    //根据角色id查询对应权限id
    public List<String> getPermissionIdByRoleId(String roleId);
    //查询所有权限
    public List<Permission> getAll();
}
