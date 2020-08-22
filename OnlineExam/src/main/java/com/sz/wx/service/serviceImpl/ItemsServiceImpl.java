package com.sz.wx.service.serviceImpl;

import com.sz.wx.dao.ItemsMapper;
import com.sz.wx.model.Items;
import com.sz.wx.model.ItemsExample;
import com.sz.wx.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    ItemsMapper itemsMapper;

    //根据试卷id查对应的题目集合
    public List<Items> getItemsListByPaperid(int paperid){
        ItemsExample example = new ItemsExample();
        ItemsExample.Criteria criteria = example.createCriteria();
        criteria.andEpaperidEqualTo(paperid);
        return itemsMapper.selectByExample(example);
    }
}
