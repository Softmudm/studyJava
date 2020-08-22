package com.sz.wx.service;

import com.sz.wx.model.ScoreDetail;
import com.sz.wx.model.ScoreDetailItems;

import java.util.List;

public interface ScoreDetailService {
    //批量插入
    int insertList(List<ScoreDetail> list);
    //查询
    List<ScoreDetailItems> getDetailList(Integer scoreId);
}
