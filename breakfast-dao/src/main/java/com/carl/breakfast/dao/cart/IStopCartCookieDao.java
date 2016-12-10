package com.carl.breakfast.dao.cart;

import com.carl.breakfast.dao.pojo.cart.CookieStopCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie方式存储类
 * @author Carl
 * @date 2016/12/11
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public interface IStopCartCookieDao extends IStopCartDao<HttpServletResponse, CookieStopCart, HttpServletRequest> {
    /**
     * 获取存储策略
     * @return
     */
    IStopCartCookieStoreStrategy getStoreStrategy();
}
