package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.admin.goods.GoodsDao;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import com.carl.breakfast.web.ctrl.admin.GoodsImage;
import com.carl.breakfast.web.ctrl.admin.GoodsModel;
import com.carl.breakfast.web.service.IGoodsService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public int saveGoods(GoodsModel goods) throws DaoException {
        GoodsPojo pojo = new GoodsPojo();
        pojo.setName(goods.getName());
        pojo.setTitle(goods.getTitle());
        pojo.setSubTitle(goods.getSubTitle());
        pojo.setCreateUser(goods.getCreateUser());
        pojo.setStock(goods.getStock());
        pojo.setPrice(goods.getPrice());
        pojo.setRecommend(goods.isRecommend());
        pojo.setMainImgId(goods.getMainImgId());
        pojo.setMainImgPath(goods.getMainImgPath());
        pojo.setNote(goods.getNote());

        int answer = goodsDao.saveBase(pojo);
        goodsDao.saveActual(pojo);

        if(goods.getGoodsDetail() != null && goods.getGoodsDetail().getImages() != null) {
            int i = 1;
            //保存详情图片到扩展信息
            for(GoodsImage image : goods.getGoodsDetail().getImages()) {
                goodsDao.saveExt(pojo.getId(), "img_" + i, "图片", image.getPath());
                i++;
            }
        }
        return answer;
    }

    @Override
    public List<GoodsPojo> selectGoodsByName(PageBounds pageBounds, String name) throws DaoException {
        return goodsDao.selectGoodsByName(pageBounds, name);
    }
}
