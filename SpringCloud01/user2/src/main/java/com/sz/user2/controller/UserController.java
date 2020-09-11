package com.sz.user2.controller;

import com.sz.user2.eurekaInterface.PaperInterface;
import com.sz.user2.model.Paper;
import com.sz.user2.model.User;
import com.sz.user2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PaperInterface paperInterface;

    @GetMapping("/all")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("/{userId}")
    public User getUserByUserid(@PathVariable("userId")Integer userId){
        return userService.getUserByUserId(userId);
    }
    @PostMapping("/login")
    public String login(User user){
        return "{\"state\":true}";
    }
    @GetMapping("/papers/{papername}")
    public List<Paper> papers(@PathVariable("papername")String papername , Integer pageNum, Integer pageSize){
        System.out.println("22222222222");
        return paperInterface.getPaperlistPage(papername,pageNum,pageSize);
    }
}
