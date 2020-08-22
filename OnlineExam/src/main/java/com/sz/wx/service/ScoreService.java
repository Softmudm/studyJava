package com.sz.wx.service;

import com.sz.wx.model.Score;
import com.sz.wx.model.ScorePaper;

import java.util.List;
import java.util.Map;

public interface ScoreService {
    //插入返回主键id
    int insertReturnId(Score record);
    //查询我的试卷
    List<ScorePaper> selectByPaperName(Map<String,Object> map);
}
