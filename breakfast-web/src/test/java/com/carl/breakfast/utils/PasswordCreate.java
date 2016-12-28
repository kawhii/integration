package com.carl.breakfast.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Test;

/**
 * @author Carl
 * @date 2016/12/21
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public class PasswordCreate {
    @Test
    public void password() {
        SimpleHash hash = new SimpleHash("MD5",
                "123456".toCharArray(), new SimpleByteSource("carls"), 1);
        System.out.println(hash);
    }
}
