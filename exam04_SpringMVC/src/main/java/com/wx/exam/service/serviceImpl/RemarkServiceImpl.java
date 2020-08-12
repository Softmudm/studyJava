package com.wx.exam.service.serviceImpl;

import com.wx.exam.dao.RemarkDao;
import com.wx.exam.model.Remark;
import com.wx.exam.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemarkServiceImpl implements RemarkService {
    @Autowired
    RemarkDao remarkDao;
    @Override
    //查询所有评论列表
    public List<Remark> getRemarkList() {
        return remarkDao.getRemarkList();
    }
}
