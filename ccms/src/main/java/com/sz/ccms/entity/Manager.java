package com.sz.ccms.entity;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

//@Table 建立实体类和表的对应关系
//@Column建立实体类字段和数据库表列名的对应关系
//@Id    标记主键对应的字段
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//       建立实体类和表的对应关系
//@Transient标记非数据库表的字段
@Table(name = "ccms_manager")
public class Manager {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY,generator = "select UUID();")
    String managerId;
    String managerAccount;
    String managerPassword;
    String managerName;
    Integer managerTel;
    Date lastLoginDate;

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
}
