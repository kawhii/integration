package com.carl.breakfast.web.ctrl.buyer;

import com.alibaba.fastjson.JSON;
import com.carl.breakfast.dao.admin.goods.pojo.GoodsPojo;
import com.carl.breakfast.dao.pojo.cart.CartGoods;
import com.carl.breakfast.dao.pojo.cart.StopCart;
import com.carl.breakfast.dao.pojo.order.GoodsComment;
import com.carl.breakfast.dao.pojo.order.OrderGoodsItem;
import com.carl.breakfast.dao.pojo.order.OrderPojo;
import com.carl.breakfast.dao.pojo.user.SendAddress;
import com.carl.breakfast.dao.sys.pojo.UserInfo;
import com.carl.breakfast.web.bean.OrderCreateBean;
import com.carl.breakfast.web.ctrl.buyer.param.CommentSubmitParam;
import com.carl.breakfast.web.ctrl.buyer.param.OrderCreateParam;
import com.carl.breakfast.web.ctrl.buyer.param.OrderGoodsParam;
import com.carl.breakfast.web.ctrl.buyer.param.OrderParam;
import com.carl.breakfast.web.service.*;
import com.carl.breakfast.web.utils.UserUtils;
import com.carl.framework.core.execption.BizException;
import com.carl.framework.core.page.PageParam;
import com.carl.framework.core.pay.wx.DefaultWXPayResult;
import com.carl.framework.core.third.wx.pay.js.JSChooseWXAuthPay;
import com.carl.framework.ui.ctrl.BaseCtrl;
import com.carl.framework.util.MapBuilder;
import com.carl.framework.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private IStopCartService stopCartService;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private IOrderGoodsCommentService orderGoodsCommentService;

    @Autowired
    private IWechatOrderService wechatOrderService;


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
    public ModelAndView myOrders() {
        ModelAndView view = new ModelAndView(freemarker("myOrders"));
        view.addObject("title", "我的订单");

        return view;
    }

    @RequestMapping(value = "/myOrders.json", method = RequestMethod.GET)
    @ResponseBody
    public Object fetchOrders(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        //获取当前用户信息
        UserInfo userInfo = UserUtils.currUser();
        return success(orderService.queryOrderByUsername(userInfo.getUsername(), new PageParam(page, pageSize)));
    }

    //订单详情
    @RequestMapping(value = "/fill", method = RequestMethod.POST)
    public ModelAndView orderFill(HttpServletRequest request, @RequestParam("carts-choose[]") Integer goodsId[]) {
        StopCart stopCart = stopCartService.obtainCart(request);
        //返回订单数据
        List<Map<String, Object>> data = new ArrayList<>();
        float totalPrice = 0f;
        if (stopCart != null) {
            List<CartGoods> goodsList = stopCart.getGoodsById(goodsId);
            List<GoodsPojo> goodsPojos = goodsService.listGoods(goodsId);

            for (GoodsPojo goodsPojo : goodsPojos) {
                for (CartGoods goods : goodsList) {
                    if (goods.getGoodsId() == goodsPojo.getId()) {
                        data.add(MapBuilder.<String, Object>build().p("goods", goodsPojo).p("qat", goods));
                        //计算价格
                        totalPrice += goods.getQuantity() * goodsPojo.getPrice();
                        break;
                    }
                }
            }
        }
        ModelAndView view = new ModelAndView(freemarker("orderFill"));
        view.addObject("title", "填写订单");
        view.addObject("data", data);
        view.addObject("totalPrice", String.format("%.2f", totalPrice));
        try {
            SendAddress address = addressService.queryDefaultAddress(UserUtils.currUser().getUsername());
            view.addObject("address", address);
        } catch (BizException e) {
            e.printStackTrace();
        }
        return view;
    }

    @RequestMapping(value = "/create.action", method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestBody OrderCreateParam orderCreateParam) {
        //返回前端参数
        MapBuilder returnParam = MapBuilder.build();
        //获取当前用户信息
        UserInfo userInfo = UserUtils.currUser();
        OrderCreateBean orderCreate = new OrderCreateBean();
        try {
            SendAddress address = addressService.querySimpleAddressById(orderCreateParam.getAddressId());
            //地址信息设置
            orderCreate.setAddress(address.getDetail())
                    .setContactName(address.getContactsName())
                    .setContactNumber(address.getContactsPhone())
                    .setUsername(userInfo.getUsername())
                    .setMessage(orderCreateParam.getMessage())
                    .setImpatient(orderCreateParam.isVexedly())
            ;
            //总价设置
            List<GoodsPojo> goodsPojos = goodsService.listGoods(orderCreateParam.getGoodsIds());
            float totalPrice = 0f;
            List<OrderGoodsItem> orderGoodsItems = new ArrayList<>(goodsPojos.size());
            for (GoodsPojo goodsPojo : goodsPojos) {
                for (OrderCreateParam.OrderGoodsParam goodsParam : orderCreateParam.getGoods()) {
                    if (goodsParam.getId() == goodsPojo.getId()) {
                        OrderGoodsItem item = new OrderGoodsItem();
                        item.setUnitPrice(goodsPojo.getPrice())
                                .setGoodsImgId(goodsPojo.getMainImgId())
                                .setGoodsImgPath(goodsPojo.getMainImgPath())
                                .setQuantity(goodsParam.getQt())
                                .setGoodsId(goodsPojo.getId())
                                .setGoodsTitle(goodsPojo.getTitle());
                        //价格
                        totalPrice += goodsPojo.getPrice() * goodsParam.getQt();
                        orderGoodsItems.add(item);
                        continue;
                    }
                }
            }

            orderCreate.setPrice(totalPrice).setItems(orderGoodsItems);
            OrderPojo pojo = orderService.createOrder(orderCreate);
            returnParam.p("order", pojo);

            //创建订单成功

            //1. 进行微信统一下单接口
            DefaultWXPayResult result = wechatOrderService.createOrder(pojo);
            returnParam.p("app", wechatOrderService.createJSPayParam(result));

            //统一下单接口成功
            if (!StringUtil.isNull(result.getTradeType())) {
                JSChooseWXAuthPay pay = wechatOrderService.createJSPayConfigParam(result);
                returnParam.p("payData", pay);
            } else {
                return fail(result.getReturnMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return fail(e.getMessage());
        }
        return success(returnParam);
    }

    @ResponseBody
    @RequestMapping("/{id}/delete")
    public Object deleteOrder(@PathVariable("id") String id) {
        return orderService.removeOrder(id, UserUtils.currUser().getUsername()) ? success() : fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/{id}/detail")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView(freemarker("detail"));
        OrderPojo orderPojo = orderService.findByIdAndOthers(id,
                MapBuilder.<String, Object>build().p("username", UserUtils.currUser().getUsername()));
        view.addObject("order", orderPojo);
        view.addObject("title", "订单详情");
        return view;
    }

    //评论
    @RequestMapping("/{id}/comment")
    public ModelAndView goComment(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView(freemarker("comment"));
        OrderPojo orderPojo = orderService.findByIdAndOthers(id,
                MapBuilder.<String, Object>build().p("username", UserUtils.currUser().getUsername()));
        view.addObject("order", orderPojo);
        view.addObject("title", "评价晒单");
        return view;
    }


    //提交评论页面
    @RequestMapping(value = "/{orderId}/{goodsId}/commentOrder", method = RequestMethod.GET)
    public ModelAndView goCommentOrdersSubmit(@PathVariable("orderId") String orderId, @PathVariable("goodsId") int goodsId) {
        ModelAndView view = new ModelAndView(freemarker("commentOrdersSubmit"));
        OrderPojo orderPojo = orderService.findByIdAndOthers(orderId,
                MapBuilder.<String, Object>build().p("username", UserUtils.currUser().getUsername()).p("goodsId", goodsId).p("isComment", false));
        if (orderPojo == null || orderPojo.getItems().isEmpty()) {
            //todo 已评论或者没有该商品，处理异常
        }
        //判断
        view.addObject("order", orderPojo);
        view.addObject("goods", orderPojo.getItems().get(0));
        view.addObject("title", "评价晒单");
        return view;
    }

    //提交评论页面
    @RequestMapping(value = "/commentOrder", method = RequestMethod.POST)
    public ModelAndView submitCommentOrders(CommentSubmitParam commentSubmitParam) {
        ModelAndView view = new ModelAndView(freemarker("commentSuccess"));

        view.addObject("title", "评价晒单");

        try {
            orderGoodsCommentService.saveComment(new GoodsComment().setContent(commentSubmitParam.getContent())
                    .setGoodsId(commentSubmitParam.getGoodsId())
                    .setOrderId(commentSubmitParam.getOrderId())
                    .setUsername(UserUtils.currUser().getUsername())
                    .setGrade(commentSubmitParam.getGrade()));
        } catch (BizException e) {
            e.printStackTrace();
            view.setViewName(freemarker("commentFail"));
        }

        return view;
    }


    //提交订订单后删除购物车数量
    @RequestMapping(value = "/cart.action", method = RequestMethod.POST)
    @ResponseBody
    public Object handleCart(@RequestBody OrderCreateParam orderCreateParam, HttpServletRequest request, HttpServletResponse response) {

        //购物车处理

        if (orderCreateParam.getGoods() != null) {
            for (OrderCreateParam.OrderGoodsParam goodsParam : orderCreateParam.getGoods()) {
                logger.debug(String.format("购物车处理商品，id：%s，qt：%s", goodsParam.getId(), goodsParam.getQt()));
                stopCartService.removeGoodsInCookie(request, response, goodsParam.getId(), goodsParam.getQt());
            }
        }
        return success();
    }
}
