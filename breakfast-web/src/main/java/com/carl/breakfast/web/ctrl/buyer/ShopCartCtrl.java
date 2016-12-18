package com.carl.breakfast.web.ctrl.buyer;

import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import com.carl.breakfast.dao.pojo.cart.CartGoods;
import com.carl.breakfast.dao.pojo.cart.StopCart;
import com.carl.breakfast.web.service.IGoodsService;
import com.carl.breakfast.web.service.IStopCartService;
import com.carl.framework.ui.ctrl.BaseCtrl;
import com.carl.framework.util.MapBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车控制类
 *
 * @author Carl
 * @date 2016/12/10
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
@RequestMapping("/cart")
@Controller
public class ShopCartCtrl extends BaseCtrl {
    protected static final Log logger = LogFactory.getLog(ShopCartCtrl.class);
    @Autowired
    private IStopCartService stopCartService;
    @Autowired
    private IGoodsService goodsService;

    @Override
    protected String getModuleName() {
        return "buyer/cart";
    }

    @RequestMapping(value = "/addGoods", method = RequestMethod.POST)
    @ResponseBody
    public Object addGoods(
            HttpServletRequest request, HttpServletResponse response,
            @RequestBody @Valid CartGoods goods
            , BindingResult result) {

        Subject subject = SecurityUtils.getSubject();
        if (result.hasErrors()) {
            return fail("非法输入");
        }
        //如果已经登陆了，添加到数据库，否则添加到cookie
//        if(subject.isAuthenticated()) {
        //todo 数据库修改
//        } else {
        stopCartService.addGoodsInCookie(request, response, goods.getGoodsId(), goods.getQuantity());
//        }
        return success();
    }

    @RequestMapping(value = "/operateGoods", method = RequestMethod.POST)
    @ResponseBody
    public Object operateGoods(
            HttpServletRequest request, HttpServletResponse response,
            @RequestBody @Valid CartGoodsOpt cartGoodsOpt,
            BindingResult result) {

        Subject subject = SecurityUtils.getSubject();
        if (result.hasErrors()) {
            return fail("非法输入");
        }

        try {
            switch (cartGoodsOpt.getType()) {
                //加
                case 1:
                    stopCartService.addGoodsInCookie(request, response, cartGoodsOpt.getGoods().getGoodsId(), cartGoodsOpt.getGoods().getQuantity());
                    break;
                //减
                case 2:
                    stopCartService.removeGoodsInCookie(request, response, cartGoodsOpt.getGoods().getGoodsId(), cartGoodsOpt.getGoods().getQuantity());
                    break;
                //删除
                case 3:
                    stopCartService.removeGoodsInCookie(request, response, cartGoodsOpt.getGoods().getGoodsId());
                    break;
            }
        } catch (Exception ex) {
            logger.error(ex);
            return fail(ex.getMessage());
        }
        return success();
    }

    @RequestMapping("/listGoods.html")
    public ModelAndView listGoods(HttpServletRequest request) {
        ModelAndView view = new ModelAndView(freemarker("listGoods"));
        StopCart cart = stopCartService.obtainCart(request);
        if (cart != null) {
            List<CartGoods> list = cart.getGoods();
            //获取购物车下的数据映射
            Map<Integer, Integer> goodsRel = new HashMap<>(list.size());
            for (CartGoods goods : list) {
                goodsRel.put(goods.getGoodsId(), goods.getQuantity());
            }
            //查询所有商品
            List<GoodsPojo> goodsPojoList = goodsService.listGoods(goodsRel.keySet().toArray(new Integer[]{}));
//            view.addObject("title", "购物车(" + (goodsPojoList == null ? 0 : goodsPojoList.size()) + ")");
            view.addObject("title", "购物车");
            //返回json数据
            if(goodsPojoList != null)
                view.addObject("data", MapBuilder.build().p("goods", goodsPojoList).p("goodsRel", goodsRel).toJson());
        } else {
            view.addObject("title", "购物车(0)");
        }
        view.addObject("submitTitle", "我要结算");
        return view;
    }
}
