package com.carl.breakfast.web.ctrl.buyer;

import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import com.carl.breakfast.web.service.IGoodsService;
import com.carl.framework.core.page.PageBean;
import com.carl.framework.core.page.PageParam;
import com.carl.framework.ui.ctrl.BaseCtrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 购买模块，商品
 *
 * @author Carl
 * @date 2016/12/5
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
@RequestMapping("/goods")
@Controller
public class GoodsShowCtrl extends BaseCtrl {
    @Autowired
    private IGoodsService goodsService;

    @Override
    protected String getModuleName() {
        return "buyer/goods";
    }

    //商品首页
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView view = new ModelAndView(freemarker("index"));
        return view;
    }

    //商品列表
    @RequestMapping(value = "/list.json", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize,
            @RequestParam(value = "name", required = false) String name
            ) {
        GoodsPojo goodsPojo = new GoodsPojo();
        goodsPojo.setStatus(1);
        goodsPojo.setTitle(name);
        PageBean data = goodsService.listPage(new PageParam(page, pageSize), goodsPojo);
        return success(data);
    }
}
