package com.sz.zhiling.dao;

import com.sz.zhiling.entity.Company;
import com.sz.zhiling.util.JDBC;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CompanyDao {
    private QueryRunner runner = new QueryRunner(JDBC.getComboPooledDataSource());
    //根据公司名称或法人名称模糊查询
    public List<Company> selComByComOrMaster(String comname,String mastername){
        String sql = "select * from companyinfo where comname like ? or mastername like ? order by comid asc";
        comname = "%"+comname+"%";
        mastername = "%"+mastername+"%";
        try {
            return runner.query(sql,new BeanListHandler<>(Company.class),comname,mastername);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
