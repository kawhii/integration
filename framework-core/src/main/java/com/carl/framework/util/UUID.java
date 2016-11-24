package com.carl.framework.util;

/**
 * @author Carl
 * @date 2016/3/28
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class UUID {
    /**
     * 获取uuid
     * @return
     */
    public static String get() {
        String s = java.util.UUID.randomUUID().toString();
        //去掉“-”符号
        return s.replaceAll("-", "").toUpperCase();
    }
}
