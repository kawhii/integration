package com.carl.breakfast.web.ctrl.buyer;

import com.carl.framework.ui.ctrl.BaseCtrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Override
    protected String getModuleName() {
        return "cart";
    }

    @RequestMapping("/addGoods")
    @ResponseBody
    public Object addGoods(@RequestParam("goodsId") int goodsId, @RequestParam("qnt") int quantity) {
        return null;
    }
}
