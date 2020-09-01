package com.sz.wx.service.serviceImpl;

import com.sz.wx.dao.ScoreDetailMapper;
import com.sz.wx.model.ScoreDetail;
import com.sz.wx.model.ScoreDetailItems;
import com.sz.wx.service.ScoreDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreDetailServiceImpl implements ScoreDetailService {

    @Autowired
    ScoreDetailMapper scoreDetailMapper;

    @Override
    public int insertList(List<ScoreDetail> list) {
        return scoreDetailMapper.insertList(list);
    }

    @Override
    public List<ScoreDetailItems> getDetailList(Integer scoreId) {
        return scoreDetailMapper.getDetailList(scoreId);
    }
}
