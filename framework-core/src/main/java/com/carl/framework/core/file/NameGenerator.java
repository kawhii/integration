package com.carl.framework.core.file;

/**
 * 名字生成器
 * @author Carl
 * @date 2016/11/29
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
public interface NameGenerator {
    /**
     * 生成名字
     * @param params
     * @return
     */
    String generator(Object ...params);
}
