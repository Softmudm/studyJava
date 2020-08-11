package com.sz.softmudm.dao;

import com.sz.softmudm.modal.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.util.List;

//省或市的持久层
@Repository
public class ProvinceDao {
    //根据类型自动注入
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //查询
    //查询子节点集合
    public List<Province> getProvinceListByFid(int fid){
        String sql = "select * from t_province where fid=?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Province.class),fid);
    }
    //查询省是否有
    //这里jdbctemp只负责查找，找不到则抛出异常，返回null有开发者编写逻辑处理，(职责单一设计原则)
    public Province getProvinceByPname(String pname){
        String sql = "select * from t_province where pname=?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Province.class), pname);
        }catch(Exception e){
            return null;
        }
    }
    //查询市是否有
    //这里jdbctemp只负责查找，找不到则抛出异常，返回null有开发者编写逻辑处理，(职责单一设计原则)
    public Province getCityByPname(String pname,int fid){
        String sql = "select * from t_province where fid=? and pname=?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Province.class),fid,pname);
        }catch(Exception e){
            return null;
        }
    }
    //查询省id
    public int getProvinceId(){
        String sql = "select s_t_province_pid.nextval from dual";
        return jdbcTemplate.queryForObject(sql,int.class);
    }
    //模糊查询省集合
    public List<Province> getProvinceListByPname(String pname){
        String sql = "select * from t_province where fid=0 and pname like ?";
        String n = "%"+pname+"%";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Province.class),n);
    }
    //查询父节点
    public Province getProvinceByPid(int pid){
        String sql = "select * from t_province where pid=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Province.class),pid);
    }
    //添加
    public int addProvince(Province province){
        String sql = "insert into t_province values(s_t_province_pid.nextval,?,?)";
        return jdbcTemplate.update(sql,province.getPname(),province.getFid());
    }
    //添加
    public int addProvince1(Province province){
        String sql = "insert into t_province values(?,?,?)";
        return jdbcTemplate.update(sql,province.getPid(),province.getPname(),province.getFid());
    }
    //删除单个
    public int deleteProvinceByPid(int pid){
        String sql = "delete t_province where pid=?";
        return jdbcTemplate.update(sql,pid);
    }
    //删除单个
    public int deleteProvinceByFid(int fid){
        String sql = "delete t_province where fid=?";
        return jdbcTemplate.update(sql,fid);
    }
    //修改
    public int updateProvince(Province province){
        String sql = "update t_province set pname=?,fid=? where pid=?";
        return jdbcTemplate.update(sql,province.getPname(),province.getFid(),province.getPid());
    }
}
