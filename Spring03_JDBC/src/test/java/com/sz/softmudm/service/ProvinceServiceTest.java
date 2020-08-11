package com.sz.softmudm.service;

import com.sz.softmudm.modal.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProvinceServiceTest {

    @Autowired
    ProvinceService provinceService;

    @Test
    public void getProvinceTest(){
        List<Province> list = provinceService.getProvince(0);
        for (Province province : list) {
            System.out.println(province);
        }
    }
}
