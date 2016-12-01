package com.carl.breakfast.dao.admin.goods;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import com.carl.framework.core.dao.BaseDaoImpl;
import com.carl.framework.util.MapBuilder;
import org.springframework.stereotype.Repository;

/**
 * 加强版商品数据库操作类加强版本
 * @author Carl
 * @date 2016/12/1
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
@Repository
public class GoodsFortifiedDaoImpl  extends BaseDaoImpl<GoodsPojo> implements GoodsFortifiedDao {

    @Override
    public int saveActual(GoodsPojo goods) throws DaoException {
        return getSessionTemplate().insert(getStatement("saveActual"), goods);
    }

    @Override
    public int saveExt(int goodsId, String keyName, String keyAs, String val) {
        return getSessionTemplate().insert(getStatement("saveExt"),
                MapBuilder.build()
                    .p("goodsId", goodsId)
                    .p("keyName", keyName)
                    .p("keyAs", keyAs)
                    .p("val", val)
                );
    }
}
