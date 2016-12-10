package com.carl.breakfast.dao.cart;

import javax.servlet.http.Cookie;

/**
 * 购物车cookie存储方案策略
 *
 * @author Carl
 * @date 2016/12/11
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public interface IStopCartCookieStoreStrategy {

    /**
     * 一般会修改cookie的存储策略才会实现
     * @param cookie
     */
    void happen(Cookie cookie);
}
