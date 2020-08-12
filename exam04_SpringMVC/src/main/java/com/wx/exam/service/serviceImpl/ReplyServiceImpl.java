package com.wx.exam.service.serviceImpl;

import com.wx.exam.dao.ReplyDao;
import com.wx.exam.model.Reply;
import com.wx.exam.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyDao replyDao;

    @Override
    //根据评论ID查询回复列表
    public List<Reply> getReplyListByKid(int kid) {
        return replyDao.getReplyListByKid(kid);
    }

    @Override
    //添加回复
    public int addReply(Reply reply) {
        return replyDao.addReply(reply);
    }
}
