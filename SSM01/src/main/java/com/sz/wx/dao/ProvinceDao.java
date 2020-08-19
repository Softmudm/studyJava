package com.sz.wx.dao;

import com.sz.wx.entity.Province;

import java.util.List;
import java.util.Map;

public interface ProvinceDao {
    //查询所有省
    public List<Province> getAllProvince();
    //分页查询省
    public List<Province> getProvinceList(Map<String,Object> map);
    //分页查询总数
    public int getProvinceCount(Map<String,Object> map);

}
