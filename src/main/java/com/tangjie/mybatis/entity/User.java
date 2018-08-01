package com.tangjie.mybatis.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    private String id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public User(){}

    public User(String username, Date birthday, String sex, String address) {
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
