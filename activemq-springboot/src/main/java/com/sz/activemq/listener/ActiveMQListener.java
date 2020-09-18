package com.sz.activemq.listener;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.sz.activemq.util.AliyunSMS;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQListener {
    //destination这里是队列对象名称， containerFactory属性定义队列模式(jmsListenerContainerTopic/jmsListenerContainerQueue)
    @JmsListener(destination = "rrrr")
    public void getMessage(String message){
        try {
            SendSmsResponse sendSmsResponse = AliyunSMS.sendSMS();
            System.out.println(sendSmsResponse.getMessage());
            System.out.println(sendSmsResponse.getCode());
            System.out.println(sendSmsResponse.getBizId());
        } catch (ClientException e) {
            e.printStackTrace();
        }
        System.out.println("监听器得到的消息"+message);
    }
}
