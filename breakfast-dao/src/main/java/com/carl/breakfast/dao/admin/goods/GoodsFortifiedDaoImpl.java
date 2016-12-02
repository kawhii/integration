package com.carl.breakfast.dao.admin.goods;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsDetail;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import com.carl.framework.core.dao.BaseDaoImpl;
import com.carl.framework.util.MapBuilder;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 加强版商品数据库操作类加强版本
 *
 * @author Carl
 * @date 2016/12/1
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
@Repository
public class GoodsFortifiedDaoImpl extends BaseDaoImpl<GoodsPojo> implements GoodsFortifiedDao {

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

    @Override
    @Transactional
    public int updateState(int goodsId, int state) {
        int res = getSessionTemplate().update(getStatement("updateState"),
                MapBuilder.build().p("goodsId", goodsId).p("status", state));
        if (res == 1) {
            insertModify(goodsId, "STATUS", Integer.toString(state == 1 ? 0 : 1), Integer.toString(state)
                    , (String) SecurityUtils.getSubject().getPrincipal());
        }
        return res;
    }

    @Override
    public int insertModify(int goodsId, String columnName, String oldVal, String newVal, String operateUser) {
        return getSessionTemplate().insert(getStatement("insertModify"),
                MapBuilder.build().p("goodsId", goodsId).p("columnName", columnName).p("newVal", newVal).p("oldVal", oldVal).p("operateUser", operateUser));
    }

    @Override
    public GoodsDetail queryDetail(int goodsId) {
        return getSessionTemplate().selectOne(getStatement("queryDetail"), MapBuilder.build().p("goodsId", goodsId));
    }
}
