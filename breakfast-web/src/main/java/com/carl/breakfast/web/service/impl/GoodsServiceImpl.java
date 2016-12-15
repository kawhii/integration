package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.admin.goods.GoodsFortifiedDao;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsDetail;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import com.carl.breakfast.web.ctrl.admin.GoodsImage;
import com.carl.breakfast.web.ctrl.admin.GoodsModel;
import com.carl.breakfast.web.service.IGoodsService;
import com.carl.framework.core.page.PageBean;
import com.carl.framework.core.page.PageParam;
import com.carl.framework.util.MapBuilder;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 加强版服务实现
 *
 * @author Carl
 * @date 2016/12/1
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private GoodsFortifiedDao goodsFortifiedDao;

    @Override
    public GoodsFortifiedDao getDao() {
        return goodsFortifiedDao;
    }

    @Override
    @Transactional
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

        int answer = goodsFortifiedDao.insert(pojo);
        goodsFortifiedDao.saveActual(pojo);

        if (goods.getGoodsDetail() != null && goods.getGoodsDetail().getImages() != null) {
            int i = 1;

            //保存详情图片到扩展信息数据库

            for (GoodsImage image : goods.getGoodsDetail().getImages()) {
                goodsFortifiedDao.saveExt(pojo.getId(), "img_" + i, "详情图片", image.getPath());
                i++;
            }
        }
        return answer;
    }

    @Override
    public PageBean listPage(PageParam pageParam, GoodsPojo goodsPojo) {
        return goodsFortifiedDao.listPage(pageParam, MapBuilder.<String, Object>build()
                .p("name", goodsPojo.getName())
                .p("title", goodsPojo.getTitle())
                .p("status", goodsPojo.getStatus())
        );
    }

    @Override
    public int updateState(int goodsId, int state) {
        return goodsFortifiedDao.updateState(goodsId, state);
    }

    @Override
    public GoodsDetail queryDetailById(int goodsId) {
        return goodsFortifiedDao.queryDetail(goodsId);
    }

    @Override
    @Transactional
    public int update(GoodsDetail goodsDetail) {
        GoodsPojo pojo = goodsFortifiedDao.getById(goodsDetail.getGoods().getId() + "");
        if (pojo != null) {
            int res = goodsFortifiedDao.update(goodsDetail.getGoods());
            if (res == 1) {
                //价格不一样添加修改历史
                if (pojo.getPrice() - goodsDetail.getGoods().getPrice() != 0) {
                    goodsFortifiedDao.insertModify(pojo.getId(), "PRICE", Float.toString(pojo.getPrice()),
                            Float.toString(goodsDetail.getGoods().getPrice()), (String) SecurityUtils.getSubject().getPrincipal());
                }
            }
            return res;
        }
        return 0;
    }

    @Override
    public List<GoodsPojo> listGoods(Integer[] ids) {
        if (ids == null || ids.length == 0)
            return null;
        return goodsFortifiedDao.listBy(MapBuilder.<String, Object>build().p("ids", ids));
    }
}
