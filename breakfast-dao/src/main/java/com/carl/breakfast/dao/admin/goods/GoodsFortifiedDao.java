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

}
