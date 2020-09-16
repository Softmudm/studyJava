package com.sz.user.controller;

import com.alibaba.fastjson.JSON;
import com.sz.commons.model.Result;
import com.sz.commons.utils.JWTUtil;
import com.sz.user.model.User;
import com.sz.user.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/login")
    public Result doLogin(String account, String password, HttpServletRequest request, HttpServletResponse response){
        User user = userService.getUserByAccountAndPassword(account,password);
        Result result = null;
        //账号密码错误
        if(user==null){
            result = new Result(false,"账号密码不匹配！");
        }else{//账号密码正确
            //将信息放入jwt的payload并生成token
            HashMap<String,Object> map = new HashMap<>();
            map.put("userId",user.getUserId());
            map.put("account",user.getAccount());
            map.put("userName",user.getUserName());
            map.put("address",user.getAddress());
            String token = JWTUtil.createJwt(map);
            //token为key，user为value存入缓存，设置过期时间15分钟
            stringRedisTemplate.opsForValue().set(token, JSON.toJSONString(user),15, TimeUnit.MINUTES);
            //token写入cookie
            //网管zuul过滤了cookie
            Cookie cookie = new Cookie("token",token);
            //webapp下的所有应用共享cookie
            cookie.setPath("/");
            //expiry默认值为 -1；
            //1.如果expiry大于0，则保存有效期为expire时间长度，单位毫秒；
            //2.如果expiry等于0，则指示浏览器删除当前cookie；
            //3.如果expiry小于0，则指示浏览器不保存该cookie到硬盘，就保存在内存中，浏览器关闭就消失；
            //cookie.setMaxAge(15*60*1000);
            response.addCookie(cookie);
            result = new Result(true,"登录成功！",token);
        }
        return result;
    }
}
