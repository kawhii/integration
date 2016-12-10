package com.carl.breakfast.dao.pojo.cart;

import javax.servlet.http.HttpServletRequest;

/**
 * cookie存储的购物车
 *
 * @author Carl
 * @date 2016/12/10
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
public class CookieStopCart extends StopCartSupport<HttpServletRequest> {
    private HttpServletRequest request;

    public CookieStopCart(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public HttpServletRequest who() {
        return request;
    }
}
