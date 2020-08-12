package com.wx.exam.controller;

import com.wx.exam.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/remark")
public class RemarkController {
    @Autowired
    RemarkService remarkService;
    //获取评论列表
    @RequestMapping("/getRemarkList")
    public String getRemarkList(Model model){
        model.addAttribute("remarkList",remarkService.getRemarkList());
        return "remark";
    }
}
