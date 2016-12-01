package com.carl.breakfast.web.ctrl.admin;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import com.carl.breakfast.web.service.IGoodsService;
import com.carl.framework.core.page.PageParam;
import com.carl.framework.ui.ctrl.BaseCtrl;
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
    @RequestMapping(value = "/list.json")
    public Object listGoods(@RequestParam(required = false, value = "name") String name,
                            @RequestParam(required = false, defaultValue = "1", value = "page") int page,
                            @RequestParam(required = false, defaultValue = "30", value = "pageSize") int limit,
                            @RequestParam(required = false, value = "sort") String sort,
                            @RequestParam(required = false, value = "dir") String dir) {

//            PageList result = goodsService.selectGoodsByName(new PageBounds(page, limit), name);
        GoodsPojo goodsPojo = new GoodsPojo();
        goodsPojo.setName(name);
        Object obj = goodsService.listPage(new PageParam(page, limit), goodsPojo);
        return success(obj);
    }

    @ResponseBody
    @RequestMapping(value = "/updateState")
    public Object updateState( @RequestParam(value = "state") int state,
                               @RequestParam(value = "goodsId") int goodsId) {
        return success(goodsService.updateState(goodsId, state));
    }
}