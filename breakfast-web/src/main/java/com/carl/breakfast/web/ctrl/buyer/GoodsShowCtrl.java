package com.carl.breakfast.web.ctrl.buyer;

import com.carl.framework.ui.ctrl.BaseCtrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
