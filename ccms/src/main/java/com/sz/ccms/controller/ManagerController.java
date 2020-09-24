package com.sz.ccms.controller;

import com.alibaba.fastjson.JSON;
import com.sz.ccms.dao.ManagerDao;
import com.sz.ccms.utils.MD5Util;
import com.sz.ccms.utils.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    ManagerDao managerDao;
}
