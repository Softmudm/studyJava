package com.sz.wx.controller;

import com.alibaba.fastjson.JSON;
import com.sz.wx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getUserList")
    public String getAllUserList(Model model){
        model.addAttribute("userList",userService.selectUserList());
        return "userList";
    }
}
