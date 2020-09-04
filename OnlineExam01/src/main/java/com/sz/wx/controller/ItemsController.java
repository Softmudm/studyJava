package com.sz.wx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.sz.wx.model.Items;
import com.sz.wx.service.ItemsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Api(value = "/items",description = "试卷详情小题操作")
@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    ItemsService itemsService;

    //有分页功能键的；
    @ApiOperation(value = "/getItemsListByPaperid",notes = "根据试卷id查询所有的题目")
    @ApiImplicitParams({@ApiImplicitParam(name = "paperid", value = "要查询的试卷id",required = true,dataType = "int")})
    //查询试卷具体题目
    @RequestMapping("/getItemsListByPaperid")
    public JSONArray getItemsListByPaperid(Integer paperid){
        //实例化过滤器对象在return是用来指定过滤字段
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        //这里在序列化时排除答案和解析不传到页面上
        filter.getExcludes().add("ekey");
        filter.getExcludes().add("ehints");
        filter.getExcludes().add("paperid");
        List<Items> list = itemsService.getItemsListByPaperid(paperid);
        //打乱题目顺序
        Collections.shuffle(list);
        return JSON.parseArray(JSON.toJSONString(list,filter));
    }
}
