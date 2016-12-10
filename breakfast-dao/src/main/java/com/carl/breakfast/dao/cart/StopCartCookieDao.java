package com.carl.breakfast.dao.cart;

import com.carl.breakfast.dao.pojo.cart.CookieStopCart;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 购物车cookie存储
 * @author Carl
 * @date 2016/12/11
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
@Repository("stopCartCookieDao")
public class StopCartCookieDao implements IStopCartDao<HttpServletResponse, CookieStopCart, HttpServletRequest> {
    protected static final Log logger = LogFactory.getLog(StopCartCookieDao.class);
    //cookie存储的数据key
    public static final String STORE_COOKIE_NAME = "$carl.st.g";
    @Override
    public CookieStopCart getStopCart(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if(STORE_COOKIE_NAME.equals(cookie.getName())) {
                    CookieStopCart c = new CookieStopCart(request);
                    try {
                        //TODO json解析返回
//                        c.setGoods()
                    } catch (Exception e) {
                        logger.error("", e);
                    }
                }
            }
        }

        return null;
    }

    @Override
    public void saveStopCart(HttpServletResponse httpServletResponse, CookieStopCart cookieStopCart) {
//TODO json解析存储
    }
}
