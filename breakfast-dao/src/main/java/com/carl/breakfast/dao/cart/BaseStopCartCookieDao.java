package com.carl.breakfast.dao.cart;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.carl.breakfast.dao.pojo.cart.CartGoods;
import com.carl.breakfast.dao.pojo.cart.CookieStopCart;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 基础的cookie存储
 *
 * @author Carl
 * @date 2016/12/11
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public abstract class BaseStopCartCookieDao implements IStopCartCookieDao {
    protected static final Log logger = LogFactory.getLog(StopCartCookieDao.class);
    //cookie存储的数据key
    public static final String STORE_COOKIE_NAME = "carl.st.g";

    @Override
    public CookieStopCart getStopCart(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (STORE_COOKIE_NAME.equals(cookie.getName())) {
                    CookieStopCart c = new CookieStopCart(request);
                    try {
                        List<CartGoods> goodsList = JSONObject.parseArray(cookie.getValue(), CartGoods.class);
                        c.setGoods(goodsList);
                        return c;
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
        if(cookieStopCart.getGoods() != null) {
            //解析成json
            String value = JSON.toJSONString(cookieStopCart.getGoods());
            Cookie cookie = new Cookie(STORE_COOKIE_NAME, value);
            //如果有配置策略，则采用策略处理一下
            if(getStoreStrategy() != null) {
                getStoreStrategy().happen(cookie);
            }
            httpServletResponse.addCookie(cookie);
        }
    }

    @Override
    public void remove(HttpServletResponse response, HttpServletRequest o) {
        Cookie cookie = new Cookie(STORE_COOKIE_NAME,null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
