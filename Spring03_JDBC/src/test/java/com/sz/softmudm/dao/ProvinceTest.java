package com.sz.softmudm.dao;

import com.sz.softmudm.modal.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProvinceTest {

    @Autowired
    private ProvinceDao provinceDao;

    //查询所有的省和市
    @Test
    public void getProvinceByFidTest(){
        List<Province> list = provinceDao.getProvinceListByFid(3);
        for (Province province : list) {
            System.out.println(province);
        }
    }

    //查询所有省
    @Test
    public void getProvinceListByPnameTest(){
        List<Province> list = provinceDao.getProvinceListByPname("");
        for (Province province : list) {
            System.out.println(province);
        }
    }

    //测试添加功能
    @Test
    public void addProvinceTest(){
        Province province = new Province("广州市",3);
        System.out.println(province);
        System.out.println(provinceDao.addProvince(province));
    }

    //查询省是否有
    @Test
    public void getProvinceByPnameTest(){
        System.out.println(provinceDao.getCityByPname("广1",27));
    }

}
