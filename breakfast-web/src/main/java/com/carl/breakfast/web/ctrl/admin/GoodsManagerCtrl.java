package com.carl.breakfast.web.ctrl.admin;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import com.carl.breakfast.web.service.IGoodsService;
import com.carl.framework.ui.ctrl.BaseCtrl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品管理
 *
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
@Controller
@RequestMapping("/admin/goods")
public class GoodsManagerCtrl extends BaseCtrl {
    protected static final Log logger = LogFactory.getLog(GoodsManagerCtrl.class);
    @Autowired
    private IGoodsService goodsService;

    protected String getModuleName() {
        return "admin/goods";
    }

    //首页
    @RequestMapping("/index.html")
    public String index() {
        return freemarker("index");
    }

    @RequestMapping(value = "/addGoods", method = RequestMethod.POST)
    @ResponseBody
    public Object addGoods(@RequestBody GoodsModel goods) {
        try {
            goodsService.saveGoods(goods);
            //TODO 校验
        } catch (DaoException e) {
            logger.error(e);
        }
        return success(goods);
    }
}