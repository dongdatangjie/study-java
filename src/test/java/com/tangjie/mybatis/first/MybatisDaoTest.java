package com.tangjie.mybatis.first;

import com.tangjie.mybatis.dao.UserDao;
import com.tangjie.mybatis.dao.impl.UserDaoImpl;
import com.tangjie.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class MybatisDaoTest {
    public SqlSessionFactory sqlSessionFactory;
    @Before
    public void testUp() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建回话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void insertUser(){
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        User user = new User("唐杰",new Date(),"男","南京栖霞区");

        int result = userDao.insertUser(user);

        Assert.assertEquals(result,1);

    }
    @Test
    public void deleteUser(){
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        int result = userDao.deleteUser("9be8b11e-9595-11e8-9988-1c1b0d7d1b8d");

        Assert.assertEquals(result,1);

    }

}
