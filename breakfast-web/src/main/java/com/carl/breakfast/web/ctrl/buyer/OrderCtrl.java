package com.carl.breakfast.web.ctrl.buyer;

import com.alibaba.fastjson.JSON;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import com.carl.breakfast.dao.pojo.order.OrderGoodsItem;
import com.carl.breakfast.dao.sys.pojo.UserInfo;
import com.carl.breakfast.web.bean.OrderCreateBean;
import com.carl.breakfast.web.service.IGoodsService;
import com.carl.breakfast.web.service.IOrderService;
import com.carl.breakfast.web.utils.UserUtils;
import com.carl.framework.ui.ctrl.BaseCtrl;
import com.carl.framework.util.MapBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
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
    protected static final Log logger = LogFactory.getLog(OrderCtrl.class);

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private IOrderService orderService;

    @Override
    protected String getModuleName() {
        return "order";
    }

    /**
     * 立即提交
     * <p>
     * sec ok
     *
     * @return
     */
    @RequestMapping(value = "/immConfirmOrder.html", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    public ModelAndView immConfirmOrder(@RequestParam("goodsId") int goodsId) {
        //1. 接收商品id（一个）
        //2. 查询具体商品数据
        //3. 前端允许修改数量 immediately=true
        //4. 地址选择
        //5. 价格显示
        //6. 提交订单（商品id，数量）

        Map<String, Object> data = MapBuilder.build();
        List<GoodsPojo> goodsPojoList = goodsService.listGoods(new Integer[]{goodsId});
        if (goodsPojoList != null && goodsPojoList.size() > 0) {
            Map<Integer, Integer> quantity = MapBuilder.<Integer, Integer>build().p(goodsId, 1);
            data.put("goodsItems", goodsPojoList);
            data.put("quantity", quantity);
            //立即提交
            data.put("immediately", true);
        }

        ModelAndView view = new ModelAndView(freemarker("orderConfirm"));
        view.addObject("data", JSON.toJSONString(data));
        return view;
    }

    /**
     * 购物车中选择数据
     *
     * @return
     */
    @RequestMapping(value = "/cartConfirmOrder.html", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    public ModelAndView cartConfirmOrder(@RequestParam("goods") String goods[]) {
        //TODO 接收商品id（多个）
        //1. 接收商品id（多个）
        //2. 查询具体商品数据
        //3. 前端不允许修改数量
        //4. 地址选择
        //5. 价格显示
        //6. 提交订单（商品id，数量）

        //解析提交的参数，分好分割id以及数量
        Map<Integer, Integer> goodsRel = new HashMap<>(goods.length);
        for (String str : goods) {
            String res[] = str.split(";");
            goodsRel.put(Integer.parseInt(res[0]), Integer.parseInt(res[1]));
        }

        Map<String, Object> data = MapBuilder.build();
        List<GoodsPojo> goodsPojoList = goodsService.listGoods(goodsRel.keySet().toArray(new Integer[]{}));
        if (goodsPojoList != null && goodsPojoList.size() > 0) {
            data.put("goodsItems", goodsPojoList);
            data.put("quantity", goodsRel);
            //立即提交
            data.put("immediately", false);
        }

        ModelAndView view = new ModelAndView(freemarker("orderConfirm"));
        view.addObject("data", JSON.toJSONString(data));
        return view;
    }

    /**
     * 购物车中选择数据
     *
     * @return
     */
    @RequestMapping(value = "/createOrder", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ModelAndView createOrder(@RequestBody OrderParam params) {
        //商品id：商品以及数量
        Map<Integer, OrderGoodsParam> goodsMap = MapBuilder.build();
        for (OrderGoodsParam orderParam : params.getGoods()) {
            goodsMap.put(orderParam.getGoodsId(), orderParam);
        }

        //获取当前用户信息
        UserInfo userInfo = UserUtils.currUser();

        //获取具体产品信息
        Integer[] ids = goodsMap.keySet().toArray(new Integer[]{});
        List<GoodsPojo> goodsPojoList = goodsService.listGoods(ids);

        OrderCreateBean orderCreate = new OrderCreateBean();
        //订单基础信息
        orderCreate.setContactName(userInfo.getName())
                .setContactNumber(userInfo.getUsername())
                .setUsername(userInfo.getUsername())
                .setAddress(params.getAddress().getAddressDetail());

        //购买商品条目
        List<OrderGoodsItem> items = new ArrayList<>(goodsPojoList.size());

        //循环创建订单产品
        for (GoodsPojo goodsPojo : goodsPojoList) {
            OrderGoodsItem item = new OrderGoodsItem();
            item.setUnitPrice(goodsPojo.getPrice())
                    .setGoodsImgId(goodsPojo.getMainImgId())
                    .setGoodsImgPath(goodsPojo.getMainImgPath())
                    .setQuantity(goodsMap.get(goodsPojo.getId()).getQuantity())
                    .setGoodsId(goodsPojo.getId())
                    .setGoodsTitle(goodsPojo.getTitle());
            //添加到数组
            items.add(item);
        }
        orderCreate.setItems(items);

        //创建订单
        orderService.createOrder(orderCreate);

        //todo 返回值，地址选择
        return null;
    }

    @RequestMapping(value = "/myOrders.html", method = RequestMethod.GET)
    public String myOrders() {
        return freemarker("myOrders");
    }

    @RequestMapping(value = "/myOrders.json", method = RequestMethod.GET)
    @ResponseBody
    public Object fetchOrders( @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        //todo 拉取当前用户的订单数据
        return null;
    }
}
