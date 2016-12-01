package com.carl.breakfast.dao.admin.goods;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import com.carl.framework.core.dao.BaseDao;

/**
 * 加强版dao
 * @author Carl
 * @date 2016/12/1
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
public interface GoodsFortifiedDao extends BaseDao<GoodsPojo> {

    /**
     * 保存实际信息
     *
     * @param goods
     * @return
     */
    int saveActual(GoodsPojo goods) throws DaoException;

    /**
     * 保存扩展信息
     *
     * @param goodsId
     * @param keyName
     * @param keyAs
     * @param val
     * @return
     */
    int saveExt(int goodsId,String keyName, String keyAs, String val);

    /**
     * 修改商品状态
     * @param goodsId
     * @param state
     * @return
     */
    int updateState(int goodsId, int state);

    /**
     * 修改历史表
     * @param goodsId 产品id
     * @param columnName 列名
     * @param newVal 新值
     * @param operateUser 操作用户
     * @return
     */
    int insertModify(int goodsId, String columnName, String newVal, String operateUser);
}
