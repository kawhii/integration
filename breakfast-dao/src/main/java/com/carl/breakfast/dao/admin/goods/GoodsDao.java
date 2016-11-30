package com.carl.breakfast.dao.admin.goods;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import org.springframework.stereotype.Repository;

/**
 * 产品操作
 *
 * @author Carl
 * @date 2016/11/30
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
@Repository
public interface GoodsDao {
    /**
     * 保存基本信息
     * @param goods
     * @return
     */
    int saveBase(GoodsPojo goods) throws DaoException;

    /**
     * 保存实际心思
     * @param goods
     * @return
     */
    int saveActual(GoodsPojo goods) throws DaoException;
}