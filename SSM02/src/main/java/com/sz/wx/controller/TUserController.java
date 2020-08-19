package com.sz.wx.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sz.wx.entity.TUser;
import com.sz.wx.service.TUserService;
import com.sz.wx.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class TUserController {
    @Autowired
    TUserService tUserService;
    //无条件查询所有的用户
    @RequestMapping("/getUserList")
    public String getAllUserList(Model model){
        model.addAttribute("userList",tUserService.getTUserList());
        return "userList";
    }
    //名字模糊查询用户
    @RequestMapping("/searchUserList")
    public String searchUserList(@RequestParam(required=false) String search,
                                 @RequestParam(required=false) Integer pageIndex,
                                 @RequestParam(required=false) Integer pageSize,
                                 Model model){
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;
        //PageHelper分页插件代码，将当前页码和页面大小放入当前线程变量，在mybatis调用sql时对sql语句拼接改造
        PageHelper.startPage(pageIndex,pageSize);
        List<TUser> list = tUserService.searchTUserList(search);
        Page<TUser> page = (Page<TUser>) list;
        PageBean<TUser> pageBean = new PageBean<TUser>(
                page.getPageNum(),
                page.getPageSize(),
                page.getTotal(),
                page.getPages(),
                page.getResult());
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("search",search);
        return "userList";
    }
    //添加用户
    @RequestMapping("/addUser")
    public String addUser(TUser user, Model model){
        int flag = tUserService.addUser(user);
        String result = "{\"m\":\"用户添加成功！\",\"i\":1}";
        if(flag<=0){
            result = "{\"m\":\"用户添加失败！\",\"i\":2}";
        }
        model.addAttribute("result",result);
        return "forward:searchUserList.do?search=";
    }
    //删除用户
    @RequestMapping("/delUsers")
    public String delUsers(String uids, Model model){
        System.out.println(uids);
        List<Integer> ids = new ArrayList<>();
        for (String s : uids.split(",")) {
            ids.add(Integer.valueOf(s));
        }
        int flag = tUserService.delUsers(ids);
        String result = "{\"m\":\"删除成功！\",\"i\":1}";
        if(flag<=0){
            result = "{\"m\":\"删除失败！\",\"i\":2}";
        }
        model.addAttribute("result",result);
        return "forward:searchUserList.do?search=";
    }
}
