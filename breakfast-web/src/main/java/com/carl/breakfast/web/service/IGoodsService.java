package com.carl.breakfast.web.service;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.admin.goods.GoodsDao;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;

/**
 * 商品信息保存
 * @author Carl
 * @date 2016/11/30
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public interface IGoodsService extends IService<GoodsDao>{
    /**
     * 保存商品信息
     * @param goods
     * @return
     */
    int saveGoods(GoodsPojo goods) throws DaoException;
}
