package com.carl.breakfast.web.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 购物车服务类
 * @author Carl
 * @date 2016/12/10
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
public interface IStopCartService {

    /**
     * 添加产品到购物车
     * <pre>
     *     若没有登录添加到cookie，若已经登陆了添加到数据库
     * </pre>
     * @param request 请求对象
     * @param goodsId 商品id
     * @param quantity 数量
     */
    void addGoodsInCookie(HttpServletRequest request, int goodsId, int quantity);
}
