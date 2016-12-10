package com.carl.breakfast.web.service;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 购物车服务类
 *
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
     *
     * @param request  请求对象
     * @param response 返回对象
     * @param goodsId  商品id
     * @param quantity 数量
     */
    void addGoodsInCookie(HttpServletRequest request, HttpServletResponse response, int goodsId, int quantity);

    /**
     * 从购物车中移除商品数量
     * @param request
     * @param response
     * @param goodsId
     * @param quantity
     */
    void removeGoodsInCookie(HttpServletRequest request, HttpServletResponse response, int goodsId, int quantity);

    /**
     * 从cookie购物车中移除商品
     * @param request
     * @param response
     * @param goodsId
     */
    void removeGoodsInCookie(HttpServletRequest request, HttpServletResponse response, int goodsId);

    /**
     * 从购物车中移除所有商品
     * @param request
     * @param response
     */
    void removeAllGoodsInCookie(HttpServletRequest request, HttpServletResponse response);


    /**
     * 添加产品到购物车
     * <pre>
     *     若没有登录添加到cookie，若已经登陆了添加到数据库
     * </pre>
     * @param subject 具体用户
     * @param goodsId  商品id
     * @param quantity 数量
     */
    void addGoodsToUser(Subject subject, int goodsId, int quantity);

    /**
     * 从购物车中移除商品数量
     * @param subject
     * @param goodsId
     * @param quantity
     */
    void removeGoodsFromUser(Subject subject, int goodsId, int quantity);

    /**
     * 从cookie购物车中移除商品
     * @param subject
     * @param goodsId
     */
    void removeGoodsFromUser(Subject subject, int goodsId);

    /**
     * 从购物车中移除所有商品
     * @param subject
     */
    void removeAllGoodsFromUser(Subject subject);


}
