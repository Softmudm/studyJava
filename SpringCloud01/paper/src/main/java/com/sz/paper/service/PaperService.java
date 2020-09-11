package com.sz.paper.service;

import com.sz.paper.model.Paper;

import java.util.List;

public interface PaperService {
    //获取试卷列表
    public List<Paper> getPagePaperList(Integer pageIndex,Integer pageSize,String papername);
}
