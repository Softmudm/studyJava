package com.sz.wx.controller;

import com.sz.wx.entity.Province;
import com.sz.wx.service.ProvinceService;
import com.sz.wx.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    ProvinceService provinceService;

    //查询所有的省
    @RequestMapping("/getAllProvince")
    public List<Province> getAllProvince(){
        return provinceService.getAllProvince();
    }
    //分页查询省
    @RequestMapping("/getProvinceList")
    public PageResult<Province> getProvinceList(Map<String,Object> map){
        Integer pageNo = (Integer) map.get("pageNo");
        Integer pageSize = (Integer) map.get("pageSize");
        map.put("pageNo",pageNo==null?1:pageNo);
        map.put("pageSize",pageSize==null?5:pageSize);
        List<Province> list = provinceService.getProvinceList(map);
        PageResult<Province> page = new PageResult<>((Integer) map.get("pageNo"),(Integer) map.get("pageSize"),list);
        page.setTotalNum(provinceService.getProvinceCount(map));
        return page;
    }
}
