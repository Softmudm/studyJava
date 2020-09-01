package com.sz.wx.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sz.wx.model.Paper;
import com.sz.wx.service.PaperService;
import com.sz.wx.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    PaperService paperService;

    //获取试卷列表
    @RequestMapping("/getPaperList")
    public PageResult getPaperList(@RequestBody Map<String,Object> map){
        Integer pageIndex = (Integer) map.get("pageIndex");
        Integer pageSize = (Integer) map.get("pageSize");
        String paperName = (String) map.get("paperName");
        pageIndex=pageIndex==null?1:pageIndex;
        pageSize=pageSize==null?5:pageSize;
        paperName=paperName==null?"":paperName;
        PageHelper.startPage(pageIndex,pageSize);
        Page<Paper> list = (Page<Paper>) paperService.getPaperListByName(paperName);
        return new PageResult<Paper>(
                list.getPageNum(),
                list.getPageSize(),
                list.getTotal(),
                list.getPages(),
                list.getResult());
    }

    //获取具体一张试卷信息
    @RequestMapping("/getPaperByPaperid")
    public Paper getPaperByPaperid(@RequestBody Map<String,String> map){
        return paperService.getPaperByPaperid(Integer.parseInt(map.get("paperid")));
    }

}
