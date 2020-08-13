package com.sz.wx;

import com.sz.wx.entity.User;
import com.sz.wx.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTest {

    private static Session session;

    @Before
    public void before(){
        session = HibernateUtils.getSession();
    }

    @After
    public void after(){
        HibernateUtils.closeSession(session);
    }

    //查询不需要开启事务
    @Test
    public void getUserTest(){
        System.out.println(session.get(User.class,2));
    }

    //注意：括号里面是hql语句，from后面跟的是实体类而不是表
    //条件查询
    @Test
    public void getByUid(){
        User user = (User) session.createQuery("from User u where u.uid=?").setInteger(0,2).uniqueResult();
        System.out.println(user);
    }
    //查询多个
    @Test
    public void getUserList(){
        List<User> list = session.createQuery("from User").list();
        for (User user : list) {
            System.out.println(user);
        }
    }

    //除了查以外都要开启事务
    @Test
    public void addTest(){
        Transaction transaction = session.beginTransaction();
        //这时user只在内存中有，瞬时状态
        User user = new User("尹向阳","yinxiangyang");
        //这时user数据库也有了变成了持久状态
        session.save(user);
        //这时对内存中的user名称进行修改
        user.setUname("李深华");
        //提交时会对比内存与数据库的数据是否一致，不一致则会调用sql语句修改数据库中的数据。
        transaction.commit();
    }

    @Test
    public void updateTest(){
        Transaction transaction = session.beginTransaction();
        User u = session.load(User.class,4);
        u.setUname("张三");
        //session.saveOrUpdate(new User(4,"李四","zhangsan"));
        transaction.commit();
    }
    @Test
    public void pageTest(){
        List<User> list = session.createQuery("from User u").setFirstResult(0).setMaxResults(3).list();
        for (User user : list) {
            System.out.println(user);
        }
    }
    //删除
    @Test
    public void deletTest(){
        Transaction transaction = session.beginTransaction();
        session.delete(new User(4));
        transaction.commit();
    }
}
