package com.carl.breakfast.web.utils;

import com.carl.framework.util.PasswordUtil;
import org.springframework.stereotype.Component;

/**
 * 密码工具
 * @author Carl
 * @date 2017/1/24
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
@Component("passwordUtil")
public class BkPasswordUtil {
    /**
     * 对密码加密
     * @param sourcePwd
     * @param salt
     * @return
     */
    public String encodePassword(String sourcePwd, String salt) {
        return PasswordUtil.encodePassword("MD5", sourcePwd, salt, 1);
    }
}
