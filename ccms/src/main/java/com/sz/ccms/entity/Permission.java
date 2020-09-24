package com.sz.ccms.entity;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ccms_permission")
public class Permission {
    @Id
    @KeySql(sql = "SELECT REPLACE(UUID(),'-','')",order = ORDER.BEFORE)
    private String permissionId;
    private String permissionName;
    private String permissionUri;
    private String fatherId;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionUri() {
        return permissionUri;
    }

    public void setPermissionUri(String permissionUri) {
        this.permissionUri = permissionUri;
    }

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    public Permission() {
    }

    public Permission(String permissionId, String permissionName, String permissionUri, String fatherId) {
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.permissionUri = permissionUri;
        this.fatherId = fatherId;
    }
}
