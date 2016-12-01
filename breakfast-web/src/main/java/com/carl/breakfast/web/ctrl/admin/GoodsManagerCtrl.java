package com.carl.breakfast.web.ctrl.admin;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.web.service.IGoodsService;
import com.carl.framework.ui.ctrl.BaseCtrl;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
            goods.setCreateUser((String) SecurityUtils.getSubject().getPrincipal());
            goodsService.saveGoods(goods);
            //TODO 校验
        } catch (DaoException e) {
            logger.error(e);
            return fail(e.getMessage());
        }
        return success(goods);
    }

    @ResponseBody
    @RequestMapping(value ="/goodsList.json")
    public Object findByCity(@RequestParam String name,
                                      @RequestParam(required =false,defaultValue ="1") int page,
                                      @RequestParam(required =false,defaultValue ="30")int limit,
                                      @RequestParam(required =false) String sort,
                                      @RequestParam(required =false) String dir) {

        try {
            return goodsService.selectGoodsByName(new PageBounds(page, limit, Order.create(sort,dir)), name);
        } catch (DaoException e) {
            return fail(e.getMessage());
        }
    }
}