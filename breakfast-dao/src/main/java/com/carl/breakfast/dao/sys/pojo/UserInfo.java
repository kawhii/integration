package com.carl.breakfast.dao.sys.pojo;

import com.carl.framework.core.entity.BaseEntity;

/**
 * @author Carl
 * @date 2016/12/22
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public class UserInfo extends BaseEntity {
    //USERNAME
    private String username;
    //PASSWORD
    private String password;
    //PASSWORD_SALT
    private String passwordSalt;
    //NAME
    private String name;

    public String getUsername() {
        return username;
    }

    public UserInfo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public UserInfo setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserInfo setName(String name) {
        this.name = name;
        return this;
    }
}
