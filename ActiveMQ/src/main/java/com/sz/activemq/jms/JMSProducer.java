package com.sz.activemq.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSProducer {
    public static void main(String[] args){
        //1创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.83.131:61616");
        Connection connection = null;
        try {
            //2获取连接
            connection = connectionFactory.createConnection();
            //3.启动连接
            connection.start();
            //4.获取 session (参数 1：是否启动事务,参数 2：消息确认模式)
            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            //-------------------------------这前面基本一样----------------------------------------------
            //5.创建队列对象(点对点）
            Queue queue = session.createQueue("test-jms");
            //6创建消息生产者
            MessageProducer producer = session.createProducer(queue);
            //7创建消息
            TextMessage textMessage = session.createTextMessage("点对点模式测试！");
            //8发送消息
            producer.send(textMessage);
            //9关闭资源
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
