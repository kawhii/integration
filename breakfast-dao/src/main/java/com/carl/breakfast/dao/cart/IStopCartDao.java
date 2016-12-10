package com.carl.breakfast.dao.cart;

import com.carl.breakfast.dao.pojo.cart.StopCart;

/**
 * 购物车处理类
 *
 * @author Carl
 * @date 2016/12/11
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public interface IStopCartDao<W, S extends StopCart<O>, O> {
    /**
     * 获取购物车数据
     *
     * @param o 存储目标对象
     * @return
     */
    S getStopCart(O o);

    /**
     * 保存购物车
     * @param w 存储工具对象
     * @param s 购物车源
     */
    void saveStopCart(W w, S s);
}
