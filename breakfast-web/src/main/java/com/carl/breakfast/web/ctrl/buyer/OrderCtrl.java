package com.carl.breakfast.web.ctrl.buyer;

import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import com.carl.breakfast.web.service.IGoodsService;
import com.carl.framework.ui.ctrl.BaseCtrl;
import com.carl.framework.util.MapBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


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
    @Autowired
    private IGoodsService goodsService;

    @Override
    protected String getModuleName() {
        return "order";
    }

    /**
     * 立即提交
     *
     * @return
     */
    @RequestMapping(value = "/immConfirmOrder.html", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    public String immConfirmOrder(@RequestParam("goodsId") int goodsId) {
        //1. 接收商品id（一个）
        //2. 查询具体商品数据
        //3. 前端允许修改数量 immediately=true
        //4. 地址选择
        //5. 价格显示
        //6. 提交订单（商品id，数量）

        Map<String, Object> data = MapBuilder.build();
        List<GoodsPojo> goodsPojoList = goodsService.listGoods(new int[]{goodsId});
        if(goodsPojoList != null && goodsPojoList.size() > 0) {
            Map<Integer, Integer> quantity = MapBuilder.<Integer, Integer>build().p(goodsId, 1);
            data.put("goodsItems", goodsPojoList);
            data.put("quantity", quantity);
            //立即提交
            data.put("immediately", true);
        }

        return freemarker("orderConfirm");
    }

    /**
     * 购物车中选择数据
     *
     * @return
     */
    @RequestMapping(value = "/cartConfirmOrder.html", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
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
