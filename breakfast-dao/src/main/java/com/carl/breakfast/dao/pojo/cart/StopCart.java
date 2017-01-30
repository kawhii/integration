package com.carl.breakfast.dao.pojo.cart;

import com.carl.framework.core.execption.BizException;

import java.util.List;

/**
 * @author Carl
 * @date 2016/12/10
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
public interface StopCart<H> {
    /**
     * 购物车的所有商品
     *
     * @return
     */
    List<CartGoods> getGoods();

    /**
     * 添加商品到购物车
     *
     * @param goods
     */
    void addGoods(CartGoods... goods);

    /**
     * 清空购物车
     */
    void clear();

    /**
     * 根据商品id获取商品信息
     *
     * @param id
     * @return
     */
    CartGoods getGoodsById(Integer id);

    List<CartGoods> getGoodsById(Integer id[]);

    /**
     * 移除购物车
     */
    void remove(CartGoods goods) throws StopCartRemoveException;

    /**
     * 谁的购物车
     *
     * @return
     */
    H who();

    /**
     * 购物车移除数错误
     */
    class StopCartRemoveException extends BizException {
        private CartGoods goods;
        private int removeQuantity;

        public CartGoods getGoods() {
            return goods;
        }

        public int getRemoveQuantity() {
            return removeQuantity;
        }

        public StopCartRemoveException(CartGoods goods, int removeQuantity) {
            super("移除购物车数量错误，商品数" + (goods == null ? "0" : goods.getQuantity()) + "，移除数" + removeQuantity);
            this.goods = goods;
            this.removeQuantity = removeQuantity;

        }
    }
}
