package com.carl.breakfast.web.ctrl.sys.service.impl;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.admin.goods.GoodsDao;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import com.carl.breakfast.web.ctrl.sys.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 商品服务
 * @author Carl
 * @date 2016/11/30
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public GoodsDao getDao() {
        return goodsDao;
    }

    @Override
    public int saveGoods(GoodsPojo goods) throws DaoException {
        int answer = goodsDao.saveBase(goods);
        goodsDao.saveActual(goods);
        return answer;
    }
}
