package com.sz.ccms.service;

import com.sz.ccms.entity.Permission;
import com.sz.ccms.entity.Role;

import java.util.List;

public interface RoleService {
    //根据角色id查询用户
    public Role getRoleByRoleId(String roleId);
    //根据权限id查询对应角色
    public List<String> getRoleNameByPermissionId(String permissionId);
}
