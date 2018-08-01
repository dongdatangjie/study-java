package com.tangjie.mybatis.first;

import com.tangjie.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class MybatisFirst {

    @Test
    public void findUserById() throws IOException {

        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建回话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("test.findUserById", 1);

        System.out.println(user);

        sqlSession.close();
    }
    @Test
    public void findUserByName() throws IOException {

        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建回话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> users = sqlSession.selectList("test.findUserByName", "小明");

        System.out.println(users);

        sqlSession.close();
    }
    @Test
    public void insertUser() throws IOException {

        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建回话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User("唐杰",new Date(),"男","南京栖霞区");

        sqlSession.insert("test.insertUser", user);

        sqlSession.commit();

        System.out.println(user.getId());

        sqlSession.close();
    }
    @Test
    public void deleteUser() throws IOException {

        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建回话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("test.deleteUser", "a9912bc7-90e2-11e8-adb1-1c1b0d7d1b8d");

        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void updateUser() throws IOException {

        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建回话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User("唐杰",new Date(),"男","南京栖霞区");

        user.setId("1");

        sqlSession.update("test.updateUser", user);

        sqlSession.commit();

        sqlSession.close();
    }

}
