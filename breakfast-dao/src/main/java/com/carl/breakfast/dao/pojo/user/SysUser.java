package com.carl.breakfast.dao.pojo.user;

import com.carl.framework.core.entity.BaseEntity;

/**
 * 用户信息
 * @author Carl
 * @date 2017/1/24
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
public class SysUser extends BaseEntity {
    private String username;
    private String password;
    private String passwordSalt;
    private String name;

    public String getUsername() {
        return username;
    }

    public SysUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SysUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public SysUser setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
        return this;
    }

    public String getName() {
        return name;
    }

    public SysUser setName(String name) {
        this.name = name;
        return this;
    }
}
