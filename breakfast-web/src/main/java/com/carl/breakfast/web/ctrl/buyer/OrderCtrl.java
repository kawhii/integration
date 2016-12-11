package com.carl.breakfast.web.ctrl.buyer;

import com.carl.framework.ui.ctrl.BaseCtrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 订单服务
 *
 * @author Carl
 * @date 2016/12/11
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
@RequestMapping("/order")
@Controller
public class OrderCtrl extends BaseCtrl {
    @Override
    protected String getModuleName() {
        return "order";
    }

    /**
     * 立即提交
     * @return
     */
    @RequestMapping("/immConfirmOrder.html")
    public ModelAndView immConfirmOrder() {
        //TODO 接收商品id（一个）
        //1. 接收商品id（一个）
        //2. 查询具体商品数据
        //3. 前端允许修改数量
        //4. 地址选择
        //5. 价格显示
        //6. 提交订单（商品id，数量）
        return null;
    }

    /**
     * 购物车中选择数据
     * @return
     */
    @RequestMapping("/cartConfirmOrder.html")
    public ModelAndView cartConfirmOrder() {
        //TODO 接收商品id（多个）
        //1. 接收商品id（多个）
        //2. 查询具体商品数据
        //3. 前端不允许修改数量
        //4. 地址选择
        //5. 价格显示
        //6. 提交订单（商品id，数量）
        return null;
    }
}
