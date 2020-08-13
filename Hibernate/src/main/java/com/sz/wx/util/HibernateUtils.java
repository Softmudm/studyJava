package com.sz.wx.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

//优化工具类
public class HibernateUtils {

    private static Configuration configuration;
    private static ServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    static {
        //configure()无参表示核心文件按约定写
        configuration = new Configuration().configure();
        //注册服务与配置
        serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
    }
    //单例设计模式
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            //获取SessionFactory
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
    //获取session
    public static Session getSession(){
        //获取session,
        // getCurrentSession()得到的session会自动关闭
        // openSession()的session需手动开启与关闭
        return getSessionFactory().openSession();
    }
    //关闭session
    public static void closeSession(Session session){
        if(session!=null){
            session.close();
        }
    }
    //获取事务
//    Transaction transaction = null;
    //开启事务
//    transaction = session.beginTransaction();
}
