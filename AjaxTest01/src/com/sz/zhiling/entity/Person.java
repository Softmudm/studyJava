package com.sz.zhiling.entity;

public class Person {
    private int userId;
    private String userName;
    private int roleId;
    private int countryId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public Person() {
    }

    public Person(int userId, String userName, int roleId, int countryId) {
        this.userId = userId;
        this.userName = userName;
        this.roleId = roleId;
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", roleId=" + roleId +
                ", countryId=" + countryId +
                '}';
    }
}
