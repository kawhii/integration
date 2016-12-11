package com.carl.breakfast.web.ctrl.buyer;

import com.carl.breakfast.dao.pojo.cart.CartGoods;
import com.carl.breakfast.web.service.StopCartService;
import com.carl.framework.ui.ctrl.BaseCtrl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
    @Autowired
    private StopCartService stopCartService;

    @Override
    protected String getModuleName() {
        return "cart";
    }

    @RequestMapping(value = "/addGoods", method = RequestMethod.POST)
    @ResponseBody
    public Object addGoods(
            HttpServletRequest request, HttpServletResponse response,
            @RequestBody @Valid CartGoods goods
            , BindingResult result) {

        Subject subject = SecurityUtils.getSubject();
        if(result.hasErrors()) {
            return fail("非法输入");
        }
        //如果已经登陆了，添加到数据库，否则添加到cookie
        if(subject.isAuthenticated()) {
            //todo 数据库修改
        } else {
            stopCartService.addGoodsInCookie(request, response, goods.getGoodsId(), goods.getQuantity());
        }
        return success();
    }
}
