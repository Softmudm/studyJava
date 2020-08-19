package com.sz.wx.service.serviceImpl;

import com.sz.wx.dao.CityDao;
import com.sz.wx.entity.City;
import com.sz.wx.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityDao cityDao;

    @Override
    public List<City> getCityList1(int pageNo, int pageSize, String cname) {
        return cityDao.getCityList1(pageNo,pageSize,cname);
    }

    @Override
    public List<City> getCityList(Map<String, Object> map) {
        return cityDao.getCityList(map);
    }

    @Override
    public int getCityCount1(String cname) {
        return cityDao.getCityCount1(cname);
    }
    @Override
    public int getCityCount(Map<String,Object> map) {
        return cityDao.getCityCount(map);
    }

    @Override
    public int delCityByIds(int[] cids) {
        return cityDao.delCityByIds(cids);
    }
}
