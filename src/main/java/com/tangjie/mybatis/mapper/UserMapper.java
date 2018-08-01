package com.tangjie.mybatis.mapper;

import com.tangjie.mybatis.entity.User;

import java.util.List;

public interface UserMapper {

    public User findUserById(String id);

    public List<User> findUserByName(String username);

    public int insertUser(User user);

    public int deleteUser(String id);

    public int updateUser(User user);

}
