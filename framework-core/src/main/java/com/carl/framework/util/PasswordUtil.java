package com.carl.framework.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.SimpleByteSource;

/**
 * 密码工具
 *
 * @author Carl
 * @date 2017/1/24
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
public abstract class PasswordUtil {
    /**
     * 加密密码
     * @param algorithmName 加密算法，MD5等
     * @param sourcePwd 源密码
     * @param salt 盐
     * @param hashIterations 哈希值
     * @return
     */
    public static String encodePassword(String algorithmName, String sourcePwd, String salt, int hashIterations) {
        SimpleHash hash = new SimpleHash(algorithmName,
                sourcePwd.toCharArray(), new SimpleByteSource(salt), hashIterations);
        return hash.toString();
    }
}
