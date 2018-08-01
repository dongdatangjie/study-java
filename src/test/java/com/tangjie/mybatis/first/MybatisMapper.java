package com.tangjie.mybatis.first;

import com.tangjie.mybatis.entity.User;
import com.tangjie.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class MybatisMapper {

    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    @Before
    public void setUp() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建回话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @After
    public void tearDown() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void findUserById() throws IOException {

        sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById("1");

        System.out.println(user);

    }

    @Test
    public void findUserByName() throws IOException {


        sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.findUserByName("小明");

        System.out.println(users);

    }

    @Test
    public void insertUser() throws IOException {


        sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);

        User user = new User("唐杰",new Date(),"男","南京栖霞区");

        userMapper.insertUser(user);

        System.out.println(user.getId());

        sqlSession.commit();

    }

    @Test
    public void deleteUser() throws IOException {


        sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);

        userMapper.deleteUser("590195d1-90ea-11e8-adb1-1c1b0d7d1b8d");

        sqlSession.commit();
    }

    @Test
    public void updateUser() throws IOException {


        sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);

        User user = new User("唐杰",new Date(),"男","南京栖霞区");

        user.setId("3");

        userMapper.updateUser(user);

        sqlSession.commit();
    }

}
