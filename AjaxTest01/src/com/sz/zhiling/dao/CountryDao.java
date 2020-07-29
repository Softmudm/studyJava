package com.sz.zhiling.dao;

import com.sz.zhiling.entity.Country;
import com.sz.zhiling.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CountryDao {
    private QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
    //查询所有的国家
    public List<Country> selAllCountry(){
        String sql = "select t_countryid countryId,t_countryname countryName from t_country";
        try {
            return runner.query(sql,new BeanListHandler<>(Country.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
