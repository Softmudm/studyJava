package com.sz.zhiling.dao;

import com.sz.zhiling.entity.Person;
import com.sz.zhiling.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class PersonDao {
    private QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
    //按角色和国家查询Person
    public List<Person> selPersonByRoleAndCountry(int roleId,int countryId){
        String sql = "select u.t_userid userid,u.t_username username from t_users u\n" +
                    "left join t_role r on u.t_roleid=r.t_roleid\n" +
                    "left join t_country c on u.t_countryid=c.t_countryid\n" +
                    "where r.t_roleid=? and c.t_countryid=?";
        try {
            return runner.query(sql,new BeanListHandler<>(Person.class),roleId,countryId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    //按角色查询Person
    public List<Person> selPersonByRole(int roleId){
        String sql = "select u.t_userid userid,u.t_username username from t_users u\n" +
                "left join t_role r on u.t_roleid=r.t_roleid\n" +
                "left join t_country c on u.t_countryid=c.t_countryid\n" +
                "where r.t_roleid=?";
        try {
            return runner.query(sql,new BeanListHandler<>(Person.class),roleId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    //按国家查询Person
    public List<Person> selPersonByCountry(int countryId){
        String sql = "select u.t_userid userid,u.t_username username from t_users u\n" +
                "left join t_role r on u.t_roleid=r.t_roleid\n" +
                "left join t_country c on u.t_countryid=c.t_countryid\n" +
                "where c.t_countryid=?";
        try {
            return runner.query(sql,new BeanListHandler<>(Person.class),countryId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
