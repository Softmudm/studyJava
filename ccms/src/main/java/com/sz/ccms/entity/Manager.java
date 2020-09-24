package com.sz.ccms.entity;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//@Table 建立实体类和表的对应关系
//@Column建立实体类字段和数据库表列名的对应关系
//@Id    标记主键对应的字段
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//       建立实体类和表的对应关系
//@Transient标记非数据库表的字段
@Table(name = "ccms_manager")
public class Manager implements Serializable {
    @Id
    @KeySql(sql = "SELECT REPLACE(UUID(),'-','')",order = ORDER.BEFORE)
    private String managerId;
    private String managerAccount;
    private String managerPassword;
    private String roleId;
    private String managerName;
    private Integer managerTel;
    private Date lastLoginDate;

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerAccount() {
        return managerAccount;
    }

    public void setManagerAccount(String managerAccount) {
        this.managerAccount = managerAccount;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getManagerTel() {
        return managerTel;
    }

    public void setManagerTel(Integer managerTel) {
        this.managerTel = managerTel;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Manager() {
    }

    public Manager(String managerAccount, String managerPassword) {
        this.managerAccount = managerAccount;
        this.managerPassword = managerPassword;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerId='" + managerId + '\'' +
                ", managerAccount='" + managerAccount + '\'' +
                ", managerPassword='" + managerPassword + '\'' +
                ", roleId='" + roleId + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerTel=" + managerTel +
                ", lastLoginDate=" + lastLoginDate +
                '}';
    }
}
