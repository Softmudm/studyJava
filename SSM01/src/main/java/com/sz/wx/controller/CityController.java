package com.sz.wx.controller;

import com.sz.wx.entity.City;
import com.sz.wx.service.CityService;
import com.sz.wx.util.MsgResult;
import com.sz.wx.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    CityService cityService;

    @RequestMapping("/getCityList1")
    public PageResult<City> getCityList1(@RequestBody Map<String,Object> map){
        Integer pageNo = (Integer) map.get("pageNo");
        Integer pageSize = (Integer) map.get("pageSize");
        String cname = (String) map.get("cname");
        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?1:pageSize;
        List<City> list = cityService.getCityList1(pageNo,pageSize,cname);
        PageResult<City> page = new PageResult<>(pageNo,pageSize,list);
        page.setTotalNum(cityService.getCityCount1(cname));
        return page;
    }
    @RequestMapping("/getCityList")
    public PageResult<City> getCityList(@RequestBody Map<String,Object> map){
        Integer pageNo = (Integer) map.get("pageNo");
        Integer pageSize = (Integer) map.get("pageSize");
        map.put("pageNo",pageNo==null?1:pageNo);
        map.put("pageSize",pageSize==null?5:pageSize);
        List<City> list = cityService.getCityList(map);
        PageResult<City> page = new PageResult<>((Integer) map.get("pageNo"),(Integer) map.get("pageSize"),list);
        page.setTotalNum(cityService.getCityCount(map));
        return page;
    }
    @RequestMapping("delCityByIds")
    //这里直接接收前端传的数组，此时前端要用传统方式不能用json
    public MsgResult delCityByIds(int cids[]){
        if(cityService.delCityByIds(cids)==cids.length){
            return new MsgResult("删除成功！",1);
        }
        return new MsgResult("删除失败！",2);
    }
}
