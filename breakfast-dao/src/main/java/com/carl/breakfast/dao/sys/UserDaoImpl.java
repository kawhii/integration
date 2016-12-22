package com.carl.breakfast.dao.sys;

import com.carl.breakfast.dao.sys.pojo.UserInfo;
import com.carl.framework.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * @author Carl
 * @date 2016/12/22
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserInfo> implements UserDao {
}
