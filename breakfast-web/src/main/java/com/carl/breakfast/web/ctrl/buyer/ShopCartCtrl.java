package com.carl.breakfast.web.ctrl.buyer;

import com.carl.breakfast.web.service.StopCartService;
import com.carl.framework.ui.ctrl.BaseCtrl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping("/addGoods")
    @ResponseBody
    public Object addGoods(
            HttpServletRequest request, HttpServletResponse response,
            @RequestParam("goodsId") int goodsId, @RequestParam("qnt") int quantity) {

        //TODO 增加数据校验
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()) {
            //todo 数据库修改
        } else {
            stopCartService.addGoodsInCookie(request, response, goodsId, quantity);
        }
        return success();
    }
}
