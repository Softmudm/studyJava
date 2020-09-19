package com.sz.ccms.controller;

import com.sz.ccms.dao.ManagerDao;
import com.sz.ccms.entity.Manager;
import com.sz.ccms.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    ManagerDao managerDao;

    @RequestMapping("/test")
    public String test(Model model){
        Manager manager = new Manager();
        manager.setManagerAccount("wx");
        manager.setManagerPassword(MD5Util.md5("123"));
        manager.setManagerName("王鑫");
        model.addAttribute("text",managerDao.insertSelective(manager));
        return "test";
    }
}
