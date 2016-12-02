package com.carl.breakfast.web.service;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.admin.goods.GoodsFortifiedDao;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsDetail;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import com.carl.breakfast.web.ctrl.admin.GoodsModel;
import com.carl.framework.core.page.PageBean;
import com.carl.framework.core.page.PageParam;

/**
 * 加强版服务类
 * @author Carl
 * @date 2016/12/1
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
public interface IGoodsService extends IService<GoodsFortifiedDao> {


    /**
     * 保存商品信息
     *
     * @param goods
     * @return
     */
    int saveGoods(GoodsModel goods) throws DaoException;

    /**
     * 获取分页数据
     *
     * @param pageParam
     * @return
     */
    PageBean listPage(PageParam pageParam, GoodsPojo goodsPojo);

    /**
     * 修改商品状态
     * @param goodsId
     * @param state
     * @return
     */
    int updateState(int goodsId, int state);

    /**
     * 根据id查询详情，包括扩展表数据
     * @param goodsId
     * @return
     */
    GoodsDetail queryDetailById(int goodsId);
}
