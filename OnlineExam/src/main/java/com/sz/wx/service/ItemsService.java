package com.sz.wx.service;

import com.sz.wx.model.Items;

import java.util.List;

public interface ItemsService {
    //根据试卷id查对应的题目集合
    public List<Items> getItemsListByPaperid(int paperid);
}
