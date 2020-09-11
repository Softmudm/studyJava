package com.sz.paper.controller;

import com.sz.paper.model.Paper;
import com.sz.paper.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/papers")
public class PaperController {

    @Autowired
    PaperService paperService;

    //分页查询试卷列表
    @GetMapping("/{papername}")
    public List<Paper> getPaperlistPage(@PathVariable("papername")String papername , Integer pageNum, Integer pageSize){
        return paperService.getPagePaperList(pageNum,pageSize,papername);
    }
}
