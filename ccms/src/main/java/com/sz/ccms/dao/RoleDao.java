package com.sz.ccms.dao;

import com.sz.ccms.entity.Role;
import com.sz.ccms.utils.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends BaseMapper<Role> {
    public List<String> getRoleNameByPermissionId(String permissionId);
}
