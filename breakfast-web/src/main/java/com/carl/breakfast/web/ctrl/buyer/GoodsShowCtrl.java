package com.carl.breakfast.web.ctrl.buyer;

import com.carl.breakfast.dao.admin.goods.pojo.GoodsDetail;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import com.carl.breakfast.dao.sys.pojo.UserInfo;
import com.carl.breakfast.web.ctrl.util.SleepUtil;
import com.carl.breakfast.web.service.IGoodsService;
import com.carl.breakfast.web.service.IUserService;
import com.carl.framework.core.page.PageBean;
import com.carl.framework.core.page.PageParam;
import com.carl.framework.core.third.wx.auth.WXAuthenticationToken;
import com.carl.framework.core.third.wx.token.AccessTokenAuthParam;
import com.carl.framework.core.third.wx.token.AccessTokenParam;
import com.carl.framework.core.third.wx.token.AccessTokenResult;
import com.carl.framework.ui.ctrl.BaseCtrl;
import com.carl.framework.util.request.IRequester;
import com.carl.framework.util.request.JsonUrlRequester;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
        SleepUtil.sleep(0, 3);
        return view;
    }

    //商品列表
    @RequestMapping(value = "/list.json", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize,
            @RequestParam(value = "name", required = false) String name
    ) {
        GoodsPojo goodsPojo = new GoodsPojo();
        goodsPojo.setStatus(1);
        goodsPojo.setName(name);
        PageBean data = goodsService.listPage(new PageParam(page, pageSize), goodsPojo);
        SleepUtil.sleep(0, 6);
        return success(data);
    }

    /**
     * 详细信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ModelAndView goodsDetail(@PathVariable("id") int id) {
        ModelAndView view = new ModelAndView(freemarker("detail"));
        GoodsDetail dg = goodsService.queryDetailById(id);
        if (dg == null) {
            // TODO: 2016/12/5 不存在商品页面
            view.setViewName(freemarker("notExists"));
        } else {
            view.addObject("data", dg);
        }
        SleepUtil.sleep(0, 5);
        return view;
    }

    /**
     * 详细信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/detailToBuy/{id}/{isCart}", method = RequestMethod.GET)
    public ModelAndView detailToBuy(@PathVariable("id") int id, @PathVariable("isCart") int isCart) {
        ModelAndView view = new ModelAndView(freemarker("detailToBuy"));
        GoodsDetail dg = goodsService.queryDetailById(id);
        if (dg == null) {
            // TODO: 2016/12/5 不存在商品页面
            view.setViewName(freemarker("notExists"));
        } else {
            view.addObject("data", dg);
            view.addObject("isCart", isCart);
        }
        SleepUtil.sleep(0, 6);
        return view;
    }

}
