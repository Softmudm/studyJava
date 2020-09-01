package com.sz.wx.service;

import com.sz.wx.model.Paper;

import java.util.List;

public interface PaperService {
    //模糊查询试卷列表
    public List<Paper> getPaperListByName(String paperName);
    //根据paperid查询具体试卷
    public Paper getPaperByPaperid(int paperid);
}
