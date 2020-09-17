package com.sz.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicConsumer {
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
            //5.创建主体对象
            Topic topic = session.createTopic("test-topic");
            //6.创建消费者对象
            MessageConsumer consumer = session.createConsumer(topic);
            System.out.println("发布订阅模式---消费者开始监听。。。");
            //7.监听消息
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("接收到消息"+textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
            //8.关闭资源
            consumer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
