package com.sz.wx.service.serviceImpl;

import com.sz.wx.dao.ScoreMapper;
import com.sz.wx.model.Score;
import com.sz.wx.model.ScorePaper;
import com.sz.wx.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public int insertReturnId(Score record) {
        return scoreMapper.insertReturnId(record);
    }

    @Override
    public List<ScorePaper> selectByPaperName(Map<String, Object> map) {
        return scoreMapper.selectByPaperName(map);
    }
}
