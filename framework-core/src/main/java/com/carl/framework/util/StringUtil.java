package com.carl.framework.util;

/**
 * 字符串处理工具
 *
 * @author Carl
 * @date 2016/3/28
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class StringUtil {

    /**
     * 判断是否为空
     *
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        return str == null ? true : str.trim().length() == 0;
    }
}
