package com.carl.breakfast.dao;

/**
 * dao类
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
public interface IDao<T> {

    /**
     * 获取指定的代理类
     * @return
     */
    Class<T> getDaoClz();
}
