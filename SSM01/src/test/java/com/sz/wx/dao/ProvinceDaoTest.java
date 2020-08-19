package com.sz.wx.dao;

import com.sz.wx.entity.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProvinceDaoTest {
    @Autowired
    ProvinceDao provinceDao;
    @Test
    public void getAllCityTest(){
        List<Province> list = provinceDao.getProvinceList(new HashMap<>());
        for (Province province : list) {
            System.out.println(province);
        }
    }
}
