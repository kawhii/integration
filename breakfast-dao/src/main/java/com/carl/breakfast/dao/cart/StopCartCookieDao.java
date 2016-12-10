package com.carl.breakfast.dao.cart;

import org.springframework.stereotype.Repository;


/**
 * 购物车cookie存储
 *
 * @author Carl
 * @date 2016/12/11
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
@Repository("stopCartCookieDao")
public class StopCartCookieDao extends BaseStopCartCookieDao {
    private IStopCartCookieStoreStrategy strategy = cookie -> {
        //保留七天
        cookie.setMaxAge(60 * 60 * 24 * 7);
        cookie.setHttpOnly(true);
    };

    @Override
    public IStopCartCookieStoreStrategy getStoreStrategy() {
        return strategy;
    }
}
