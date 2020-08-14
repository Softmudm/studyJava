package com.wx.exam;

import com.wx.exam.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest {
    @Test
    public void getUserListTest(){
        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory =null;
        SqlSession sqlSession = null;
        try {
            //把mybatis核心配置文件读取成输入流
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //使用SqlSessionFactoryBuilder根据配置文件创建sqlSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //sqlSessionFactory.openSession()方法里面为true时会开启事务
            sqlSession = sqlSessionFactory.openSession();
            //这里的参数时Mapper.xml的命名空间.id方法名称
            List<User> list = sqlSession.selectList("com.wx.exam.dao.UserDao.selectUserList");
            for (User user : list) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
