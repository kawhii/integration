package com.carl.breakfast.dao.admin.goods;

import com.carl.breakfast.dao.admin.goods.pojo.GoodsDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 商品数据查询
 *
 * @author Carl
 * @date 2016/12/8
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
public interface GoodsDao {

    /**
     * 采用id进行详情查询
     * @param goodId
     * @return
     */
    GoodsDetail findDetailById(@Param("goodsId") int goodId);
}
