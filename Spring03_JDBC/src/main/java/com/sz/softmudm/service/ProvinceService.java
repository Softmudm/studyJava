package com.sz.softmudm.service;

import com.sz.softmudm.modal.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public interface ProvinceService {
    //查询
    public List<Province> getProvinceListByFid(int fid);
    //查询省是否有
    public Province getProvinceByPname(String pname);
    //查询市是否有
    public Province getCityByPname(String pname,int fid);
    //查询省id
    public int getProvinceId();
    //模糊查询省集合
    public List<Province> getProvinceListByPname(String pname);
    //添加
    public int addProvince(Province province);
    //添加
    public int addProvince1(Province province);
    //查询父节点
    public Province getProvinceByPid(int pid);
    //删除单个
    public int deleteProvince(int pid);
    //修改
    public int updateProvince(Province province);
    //递归查询(传入一个初始父id)
    public List<Province> getProvince(int fid);
}
