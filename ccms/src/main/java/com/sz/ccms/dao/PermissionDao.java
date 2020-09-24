package com.sz.ccms.dao;

import com.sz.ccms.entity.Permission;
import com.sz.ccms.utils.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao extends BaseMapper<Permission> {
    public List<String> getPermissionIdByRoleId(String roleId);
}
