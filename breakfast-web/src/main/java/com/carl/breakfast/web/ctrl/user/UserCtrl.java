package com.carl.breakfast.web.ctrl.user;

import com.carl.breakfast.web.service.impl.AddressService;
import com.carl.breakfast.web.utils.UserUtils;
import com.carl.framework.ui.ctrl.BaseCtrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户控制器
 *
 * @author Carl
 * @date 2017/1/30
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
@RequestMapping("/user")
@Controller
public class UserCtrl extends BaseCtrl {
    @Autowired
    private AddressService addressService;

    @Override
    protected String getModuleName() {
        return "user";
    }

    @RequestMapping("/address.html")
    public ModelAndView address() {
        ModelAndView view = new ModelAndView(freemarker("address"));
        try {
            String username = UserUtils.currUser().getUsername();
            view.addObject("address", addressService.queryAddressByUsername(username));
            view.addObject("title", "收货地址");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    @RequestMapping("/setDefaultAddress")
    @ResponseBody
    public Object setDefaultAddress(@RequestParam("addressId") int id) {
        try {
            String username = UserUtils.currUser().getUsername();
            addressService.setDefaultAddress(username, id);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        return success();
    }

    @RequestMapping("/removeAddress")
    @ResponseBody
    public Object removeAddress(@RequestParam("addressId") int id) {
        try {
            UserUtils.currUser().getUsername();
            if(addressService.removeAddressById(id)) {
                return success("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        return fail("删除失败");
    }

    @RequestMapping("/addAddress.html")
    public ModelAndView setDefaultAddress() {
        ModelAndView view = new ModelAndView(freemarker("addressEdit"));

        return view;
    }
}
