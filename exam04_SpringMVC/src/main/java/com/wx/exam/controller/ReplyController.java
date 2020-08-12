package com.wx.exam.controller;

import com.wx.exam.model.Reply;
import com.wx.exam.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    ReplyService replyService;
    //根据评论kid获取回复列表
    @RequestMapping("/getReplyList")
    public String getReplyListByKid(int kid,Model model){
        model.addAttribute("kid",kid);
        model.addAttribute("replyList",replyService.getReplyListByKid(kid));
        return "reply";
    }

    //添加评论的回复
    @RequestMapping("/addReply")
    public String addReply(Integer kid,Integer ruid,String rmsg,Model model){
        Reply reply = new Reply(kid,ruid,rmsg);
        int f = replyService.addReply(reply);
        String m ="添加失败";
        if(f==1){
            m = "添加成功";
        }
        model.addAttribute("m",m);
        return "forward:getReplyList.do";
    }
}
