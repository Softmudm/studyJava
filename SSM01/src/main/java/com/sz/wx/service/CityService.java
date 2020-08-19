package com.sz.wx.service;

import com.sz.wx.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CityService {
    //分页查询
    public List<City> getCityList1(int pageNo,int pageSize,String cname);
    public List<City> getCityList(Map<String,Object> map);
    //查询总数
    public int getCityCount1(String cname);
    public int getCityCount(Map<String,Object> map);
    //删除城市
    public int delCityByIds(int[] cids);
}
