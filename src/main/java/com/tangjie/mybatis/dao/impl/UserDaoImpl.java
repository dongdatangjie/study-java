package com.tangjie.mybatis.dao.impl;

import com.tangjie.mybatis.dao.UserDao;
import com.tangjie.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Date;

public class UserDaoImpl implements UserDao {
    public SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory=sqlSessionFactory;
    }


    public User findUserById(String id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById", id);
        sqlSession.close();
        return user;
    }

    public int insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
        return result;

    }

    public int deleteUser(String id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.delete("test.deleteUser", id);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }
}
