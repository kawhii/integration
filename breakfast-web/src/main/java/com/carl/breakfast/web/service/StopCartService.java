package com.carl.breakfast.web.service;

import com.carl.breakfast.dao.cart.IStopCartCookieDao;
import com.carl.breakfast.dao.pojo.cart.CartGoods;
import com.carl.breakfast.dao.pojo.cart.CookieStopCart;
import com.carl.breakfast.dao.pojo.cart.StopCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 购物车处理服务类
 *
 * @author Carl
 * @date 2016/12/11
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
@Service
public class StopCartService implements IStopCartService {
    @Autowired
    private IStopCartCookieDao stopCartCookieDao;

    @Override
    public void addGoodsInCookie(HttpServletRequest request, HttpServletResponse response, int goodsId, int quantity) {
        //获取当前购物车，若为空，new一个
        CookieStopCart cookieStopCart = stopCartCookieDao.getStopCart(request);
        if (cookieStopCart == null) {
            cookieStopCart = new CookieStopCart(request);
        }
        //购物车中添加商品
        cookieStopCart.addGoods(new CartGoods(goodsId, quantity));
        //保存到购物车中
        stopCartCookieDao.saveStopCart(response, cookieStopCart);
    }

    @Override
    public StopCart obtainCart(HttpServletRequest request) {
        return stopCartCookieDao.getStopCart(request);
    }

    @Override
    public void removeGoodsInCookie(HttpServletRequest request, HttpServletResponse response, int goodsId, int quantity) {
        CookieStopCart cookieStopCart = stopCartCookieDao.getStopCart(request);
        if (cookieStopCart != null) {
            cookieStopCart.remove(new CartGoods(goodsId, quantity));
            //保存到购物车中
            stopCartCookieDao.saveStopCart(response, cookieStopCart);
        }
    }

    @Override
    public void removeGoodsInCookie(HttpServletRequest request, HttpServletResponse response, Integer []goodsId) {
        CookieStopCart cookieStopCart = stopCartCookieDao.getStopCart(request);
        if (cookieStopCart != null) {
            //根据id获取商品，找到直接移除
            for(int id :goodsId) {
                CartGoods goods = cookieStopCart.getGoodsById(id);
                if(goods != null) {
                    cookieStopCart.remove(goods);
                }
            }

            //保存到购物车中
            stopCartCookieDao.saveStopCart(response, cookieStopCart);
        }
    }

    @Override
    public void removeAllGoodsInCookie(HttpServletRequest request, HttpServletResponse response) {
        stopCartCookieDao.remove(response, request);
    }

    @Override
    public void addGoodsToUser(Subject subject, int goodsId, int quantity) {
// TODO: 2016/12/11
    }

    @Override
    public void removeGoodsFromUser(Subject subject, int goodsId, int quantity) {
// TODO: 2016/12/11
    }

    @Override
    public void removeGoodsFromUser(Subject subject, int goodsId) {
// TODO: 2016/12/11
    }

    @Override
    public void removeAllGoodsFromUser(Subject subject) {
        // TODO: 2016/12/11
    }
}
