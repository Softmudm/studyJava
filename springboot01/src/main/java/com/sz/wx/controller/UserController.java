package com.sz.wx.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sz.wx.model.User;
import com.sz.wx.service.UserService;
import com.sz.wx.util.PageResult;
import com.sz.wx.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/getUserList")
    public PageResult<User> getUserList(@RequestBody Map<String,Object> map){
        Integer pageIndex = Integer.parseInt(String.valueOf(map.get("pageIndex")));
        Integer pageSize = Integer.parseInt(String.valueOf(map.get("pageSize")));
        String userName = (String) map.get("userName");
        PageHelper.startPage(pageIndex,pageSize);
        Page<User> page = (Page<User>) userService.selectByUsername(userName==null?"":userName);
        return new PageResult<>(page.getPageNum(),page.getPageSize(),page.getTotal(),page.getPages(),page.getResult());
    }
    @RequestMapping("/getUserByUserid")
    public User getUserByUserid(@RequestBody Map<String,Integer> map){
        return userService.getUserByUserid(map.get("userid"));
    }
    @RequestMapping("/deleteUserByUserid")
    public ResultBean deleteUserByUserid(@RequestBody Map<String,Integer> map){
        int flag = userService.deleteUserByUserid(map.get("userid"));
        ResultBean resultBean = new ResultBean("删除成功！",1);
        if(flag!=1){
            resultBean.setMessage("删除失败！");
            resultBean.setI(2);
        }
        return resultBean;
    }
    @RequestMapping("/updateUser")
    public ResultBean updateUser(@RequestBody Map<String,User> map){
        int flag = userService.updateUser(map.get("user"));
        ResultBean resultBean = new ResultBean("修改成功！",1);
        if(flag!=1){
            resultBean.setMessage("修改失败！");
            resultBean.setI(2);
        }
        return resultBean;
    }
    @RequestMapping("/addUser")
    public ResultBean addUser(@RequestBody Map<String,User> map){
        int flag = userService.addUser(map.get("user"));
        ResultBean resultBean = new ResultBean("添加成功！",1);
        if(flag!=1){
            resultBean.setMessage("添加失败！");
            resultBean.setI(2);
        }
        return resultBean;
    }
}
