package com.tangjie.mybatis.dao;

import com.tangjie.mybatis.entity.User;

public interface UserDao {
    public User findUserById(String id);

    public int insertUser(User user);

    public int deleteUser(String id);

}
