package com.carl.breakfast.dao.admin.goods;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import org.apache.ibatis.annotations.Param;
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
     *
     * @param goods
     * @return
     */
    int saveBase(GoodsPojo goods) throws DaoException;

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
    int saveExt(@Param("goodsId") int goodsId, @Param("keyName") String keyName, @Param("keyAs") String keyAs, @Param("val") String val);
}
