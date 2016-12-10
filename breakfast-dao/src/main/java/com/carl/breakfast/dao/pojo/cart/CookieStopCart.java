package com.carl.breakfast.dao.pojo.cart;

/**
 * cookie存储的购物车
 *
 * @author Carl
 * @date 2016/12/10
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
public class CookieStopCart extends StopCartSupport<String> {
    private String cookieId;

    /**
     * cookie值
     * @param cookieId
     */
    public CookieStopCart(String cookieId) {
        this.cookieId = cookieId;
    }

    @Override
    public String who() {
        return cookieId;
    }
}
