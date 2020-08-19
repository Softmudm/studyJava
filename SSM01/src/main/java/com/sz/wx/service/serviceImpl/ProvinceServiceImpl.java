package com.sz.wx.service.serviceImpl;

import com.sz.wx.dao.ProvinceDao;
import com.sz.wx.entity.Province;
import com.sz.wx.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceDao provinceDao;

    @Override
    public List<Province> getAllProvince() {
        return provinceDao.getAllProvince();
    }

    @Override
    public List<Province> getProvinceList(Map<String, Object> map) {
        return provinceDao.getProvinceList(map);
    }

    @Override
    public int getProvinceCount(Map<String, Object> map) {
        return provinceDao.getProvinceCount(map);
    }
}
