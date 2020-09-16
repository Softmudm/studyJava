package com.sz.zuul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ErrorController {

    @GetMapping(value = "/error")
    public void error(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入错误处理");
        try {
            response.sendRedirect("/client/html/login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
