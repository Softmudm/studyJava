package com.sz.wx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.sz.wx.model.Items;
import com.sz.wx.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    ItemsService itemsService;

    //查询试卷具体题目
    @RequestMapping("/getItemsListByPaperid")
    public String getItemsListByPaperid(@RequestBody Map<String,Object> map){
        //实例化过滤器对象在return是用来指定过滤字段
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        //这里在序列化时排除答案和解析不传到页面上
        filter.getExcludes().add("ekey");
        filter.getExcludes().add("ehints");
        filter.getExcludes().add("paperid");
        List<Items> list = itemsService.getItemsListByPaperid(Integer.parseInt((String) map.get("paperid")));
        //打乱题目顺序
        Collections.shuffle(list);
        return JSON.toJSONString(list,filter);
    }
}
