package com.wx.exam.service;

import com.wx.exam.model.Remark;

import java.util.List;

public interface RemarkService {
    //查询所有评论列表
    public List<Remark> getRemarkList();
}
