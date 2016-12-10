package com.carl.breakfast.dao.pojo.cart;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Create by Administrator on 2016/12/10.
 */
public class CookieStopCartTest {

    @Test
    public void addGoods() {
        CookieStopCart cart = new CookieStopCart(null);
        CartGoods cg1 = new CartGoods(1, 2);
        CartGoods cg2 = new CartGoods(1, 3);
        CartGoods cg3 = new CartGoods(2, 3);
        cart.addGoods(cg1, cg2, cg3);
        List<CartGoods> goods = cart.getGoods();
        Assert.assertEquals(2, goods.size());
        for(CartGoods g : goods) {
            if(g.getGoodsId() == 1) {
                Assert.assertEquals(5, g.getQuantity());
            } else if(g.getGoodsId() == 2) {
                Assert.assertEquals(3, g.getQuantity());
            }
        }
    }

    @Test
    public void setGoods() {
        CookieStopCart cart = new CookieStopCart(null);
        CartGoods cg1 = new CartGoods(1, 2);
        CartGoods cg2 = new CartGoods(1, 3);
        CartGoods cg3 = new CartGoods(2, 3);
        CartGoods cg4 = new CartGoods(2, 3);
        List<CartGoods> goodsList = new ArrayList<>(3);
        goodsList.add(cg1);
        goodsList.add(cg2);
        goodsList.add(cg3);
        cart.setGoods(goodsList);
        cart.addGoods(cg4);
        List<CartGoods> goods = cart.getGoods();
        Assert.assertEquals(2, goods.size());
        for(CartGoods g : goods) {
            if(g.getGoodsId() == 1) {
                Assert.assertEquals(5, g.getQuantity());
            } else if(g.getGoodsId() == 2) {
                Assert.assertEquals(6, g.getQuantity());
            }
        }
    }

    @Test
    public void remove() {
        CookieStopCart cart = new CookieStopCart(null);
        CartGoods cg1 = new CartGoods(1, 2);
        CartGoods cg2 = new CartGoods(2, 3);
        List<CartGoods> goodsList = new ArrayList<>(2);
        goodsList.add(cg1);
        goodsList.add(cg2);
        cart.setGoods(goodsList);
        cart.remove(new CartGoods(1, 2));
        cart.remove(new CartGoods(2, 3));
        try {
            cart.remove(new CartGoods(2, 3));
            Assert.fail();
        } catch (StopCart.StopCartRemoveException ex) {
            System.out.println("正常异常信息：" + ex.getMessage());
        }
        List<CartGoods> goods = cart.getGoods();
        Assert.assertEquals(2, goods.size());
        for(CartGoods g : goods) {
            if(g.getGoodsId() == 1) {
                Assert.assertEquals(0, g.getQuantity());
            } else if(g.getGoodsId() == 2) {
                Assert.assertEquals(0, g.getQuantity());
            }
        }
    }
}