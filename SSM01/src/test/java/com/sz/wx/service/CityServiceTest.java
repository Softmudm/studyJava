package com.sz.wx.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CityServiceTest {
    @Autowired
    CityService cityService;
    @Test
    public void getAllCityTest(){
        System.out.println(cityService.getCityList1(2,3,""));
    }
    @Test
    public void getAllCity1Test(){
        Map<String,Object> map = new HashMap<>();
        map.put("pageNo",1);
        map.put("pageSize",3);
        map.put("cname","阳");
        System.out.println(cityService.getCityList(map));
    }
    @Test
    public void delCityByIdsTest(){
        System.out.println(cityService.delCityByIds(new int[]{17}));
    }
}
