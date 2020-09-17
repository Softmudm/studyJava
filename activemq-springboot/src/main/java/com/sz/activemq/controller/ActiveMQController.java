package com.sz.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activemq")
public class ActiveMQController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/send")
    public String sendMsg(String msg){
        System.out.println("发送消息中。。");
        jmsMessagingTemplate.convertAndSend("rrrr",msg);
        return "发送消息成功!消息内容："+msg;
    }
}
