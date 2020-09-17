package com.sz.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicProducer {
    public static void main(String[] args) {
        //1.创建连接工厂
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("tcp://192.168.83.131:61616");
        Connection connection = null;
        try {
            //2.获取连接
            connection = connectionFactory.createConnection();
            //3启动连接
            connection.start();
            //4.获取 session (参数 1：是否启动事务,参数 2：消息确认模式)
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //-------------------------------这前面基本一样------------------------------------------
            //5.创建主体对象(发布/订阅模式)
            Topic topic = session.createTopic("test-topic");
            //6.创建消息生产者
            MessageProducer producer = session.createProducer(topic);
            //7.创建消息
            TextMessage textMessage = session.createTextMessage("发布订阅模式测试！");
            //8.发送消息
            producer.send(textMessage);
            //9.关闭资源
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
