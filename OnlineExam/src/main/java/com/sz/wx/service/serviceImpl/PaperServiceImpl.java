package com.sz.wx.service.serviceImpl;

import com.sz.wx.dao.PaperMapper;
import com.sz.wx.model.Paper;
import com.sz.wx.model.PaperExample;
import com.sz.wx.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperMapper paperMapper;

    //模糊查询试卷列表
    public List<Paper> getPaperListByName(String paperName){
        PaperExample example = new PaperExample();
        PaperExample.Criteria criteria = example.createCriteria();
        criteria.andPapernameLike("%"+paperName+"%");
        return paperMapper.selectByExample(example);
    }
    //根据paperid查询具体试卷
    public Paper getPaperByPaperid(int paperid){
        return paperMapper.selectByPrimaryKey(paperid);
    }

}
