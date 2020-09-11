package com.sz.paper.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.sz.paper.dao.PaperMapper;
import com.sz.paper.model.Paper;
import com.sz.paper.model.PaperExample;
import com.sz.paper.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperMapper paperMapper;

    @Override
    public List<Paper> getPagePaperList(Integer pageNum, Integer pageSize, String papername) {
        //处理参数
        pageNum = pageNum==null?1:pageNum;
        pageSize = pageSize==null?5:pageSize;
        papername = "%"+(papername==null?"":papername)+"%";
        //放入查询条件
        PaperExample example = new PaperExample();
        PaperExample.Criteria criteria = example.createCriteria();
        criteria.andPapernameLike(papername);
        //分页
        PageHelper.startPage(pageNum,pageSize);
        return paperMapper.selectByExample(example);
    }
}
