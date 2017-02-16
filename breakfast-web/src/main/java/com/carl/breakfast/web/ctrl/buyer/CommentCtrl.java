package com.carl.breakfast.web.ctrl.buyer;

import com.carl.breakfast.web.service.IOrderGoodsCommentService;
import com.carl.framework.ui.ctrl.BaseCtrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carl
 * @date 2017/2/16
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
@RestController
@RequestMapping("/comment")
public class CommentCtrl extends BaseCtrl {
    @Autowired
    private IOrderGoodsCommentService orderGoodsCommentService;

    @Override
    protected String getModuleName() {
        return "comment";
    }

    @RequestMapping("/goods/{goodsId}")
    public Object goodsComment(@PathVariable("goodsId") int goodsId) {
        return success(orderGoodsCommentService.queryByGoodsId(goodsId));
    }
}
