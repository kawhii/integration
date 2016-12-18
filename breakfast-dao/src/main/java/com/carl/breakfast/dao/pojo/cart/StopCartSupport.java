package com.carl.breakfast.dao.pojo.cart;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 购物车基础类
 *
 * @author Carl
 * @date 2016/12/10
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
public abstract class StopCartSupport<H> implements StopCart<H> {
    private List<CartGoods> goodsList = new CopyOnWriteArrayList<>();
    private Map<Integer, Integer> goodsListMap = new HashMap<Integer, Integer>();

    @Override
    public List<CartGoods> getGoods() {
        return goodsList;
    }

    public StopCartSupport setGoods(List<CartGoods> goodsList) {
        clear();
        if (goodsList != null) {
            addGoods(goodsList.toArray(new CartGoods[]{}));
        }
        return this;
    }

    /**
     * 添加商品到购物车，若购物车存在，继续添加到对应的商品下
     *
     * @param goods
     */
    public final void addGoods(CartGoods... goods) {
        if (goods != null) {
            //如果不存在，放到映射里面
            for (CartGoods c : goods) {
                if (goodsListMap.containsKey(c.getGoodsId())) {
                    Integer res = goodsListMap.get(c.getGoodsId());
                    goodsListMap.put(c.getGoodsId(), res + c.getQuantity());
                } else {
                    goodsListMap.put(c.getGoodsId(), c.getQuantity());
                }
            }
            reset();
        }
    }
    //重新设置数据列表
    private void reset() {
        goodsList.clear();
        for (Integer goodsId : goodsListMap.keySet()) {
            goodsList.add(new CartGoods().setGoodsId(goodsId).setQuantity(goodsListMap.get(goodsId)));
        }
    }

    @Override
    public final void clear() {
        this.goodsListMap.clear();
        this.goodsList.clear();
    }

    @Override
    public final void remove(CartGoods goods) throws StopCartRemoveException {
        Integer q = goodsListMap.get(goods.getGoodsId());
        if((q == null || q == 0) && goods.getQuantity() > 0) {
            throw new StopCartRemoveException(null, goods.getQuantity());
        } else {
            if(goods.getQuantity() > 0) {
                Integer res = q - goods.getQuantity();
                if(res < 0) {
                    throw new StopCartRemoveException(
                            new CartGoods().setGoodsId(goods.getGoodsId()).setQuantity(q),
                            goods.getQuantity());
                }
                goodsListMap.remove(goods.getGoodsId());
            }
        }
        reset();
    }

    @Override
    public CartGoods getGoodsById(Integer id) {
        Integer q = goodsListMap.get(id);
        return q == null ? null : new CartGoods(id, q);
    }
}
