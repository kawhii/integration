package com.carl.breakfast.web.ctrl.user;

import org.springframework.stereotype.Repository;


/**
 * @author Carl
 * @date 2016/11/27
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
@Repository
public interface UserDao {
    User findByName(String username);
}
