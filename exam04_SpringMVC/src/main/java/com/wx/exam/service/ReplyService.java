package com.wx.exam.service;

import com.wx.exam.model.Reply;

import java.util.List;

public interface ReplyService {
    //根据评论ID查询回复列表
    public List<Reply> getReplyListByKid(int kid);
    //添加回复
    public int addReply(Reply reply);
}
