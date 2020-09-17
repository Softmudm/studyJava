package com.sz.activemq.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSConsumer {
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
            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            //-------------------------------这前面基本一样----------------------------------------------
            //5.创建队列对象
            Queue queue = session.createQueue("test-jms");
            //6.创建消息消费
            MessageConsumer consumer = session.createConsumer(queue);
            System.out.println("点对点模式---消费者开始监听。。。");
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
            //9关闭资源
            consumer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
