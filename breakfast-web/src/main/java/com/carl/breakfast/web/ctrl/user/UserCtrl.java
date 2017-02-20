package com.carl.breakfast.web.ctrl.user;

import com.carl.breakfast.dao.pojo.user.AddressExt;
import com.carl.breakfast.dao.sys.pojo.UserInfo;
import com.carl.breakfast.web.bean.AddressDetailBean;
import com.carl.breakfast.web.bean.AddressParamBean;
import com.carl.breakfast.web.ctrl.buyer.OrderCtrl;
import com.carl.breakfast.web.service.IAddressService;
import com.carl.breakfast.web.service.ICommonAddressService;
import com.carl.breakfast.web.service.IUserService;
import com.carl.breakfast.web.service.impl.CommonAddressService;
import com.carl.breakfast.web.utils.UserUtils;
import com.carl.framework.core.third.wx.auth.WXAuthenticationToken;
import com.carl.framework.core.third.wx.token.AccessTokenParam;
import com.carl.framework.core.third.wx.token.AccessTokenResult;
import com.carl.framework.ui.ctrl.BaseCtrl;
import com.carl.framework.util.request.IRequester;
import com.carl.framework.util.request.JsonUrlRequester;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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
    private IAddressService addressService;
    @Autowired
    private CommonAddressService commonAddressService;

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
            if (addressService.removeAddressById(id)) {
                return success("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        return fail("删除失败");
    }

    @RequestMapping(value = "/addAddress.html", method = RequestMethod.GET)
    public ModelAndView addAddressPage() {
        ModelAndView view = new ModelAndView(freemarker("addressEdit"));
        Object flow = commonAddressService.listByType(ICommonAddressService.Type.FLOW);
        Object build = commonAddressService.listByType(ICommonAddressService.Type.BUILD);
        view.addObject("flow", flow);
        view.addObject("build", build);
        view.addObject("title", "收货人");
        return view;
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    @ResponseBody
    public Object addAddress(@Valid @RequestBody
                                     AddressParamBean paramBean,
                             BindingResult result) {
        if (result.hasErrors()) {
            return fail("非法输入");
        }
        try {
            String username = UserUtils.currUser().getUsername();
            AddressDetailBean bean = new AddressDetailBean();
            bean.setUsername(username)
                    .setId(paramBean.getId())
                    .setDefault(paramBean.isDefault())
                    .setContactsName(paramBean.getcName())
                    .setContactsPhone(paramBean.getcPhone())
                    .setDetailAddress(new AddressExt().setVal(paramBean.getDetail())
                            .setKeyAs(IAddressService.DETAIL).setKeyName("详细地址"))
                    .setSchool(new AddressExt().setVal(paramBean.getSchool())
                            .setKeyAs(IAddressService.SCHOOL).setKeyName("学校"))
                    .setFlow(new AddressExt().setVal(paramBean.getFlow())
                            .setKeyAs(IAddressService.FLOW).setKeyName("楼层"))
                    .setBuild(new AddressExt().setVal(paramBean.getBuild())
                            .setKeyAs(IAddressService.BUILD).setKeyName("楼栋"))
                    .setHouseNumber(new AddressExt().setVal(paramBean.getHouseNum())
                            .setKeyAs(IAddressService.HOUSE_NUM).setKeyName("门牌"));
            addressService.addAddress(bean);
        } catch (Exception e) {
            e.printStackTrace();
            return fail(e.getMessage());
        }

        return success();
    }

    @RequestMapping(value = "/addressUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Object addressUpdate(@Valid @RequestBody
                                     AddressParamBean paramBean,
                             BindingResult result) {
        if (result.hasErrors()) {
            return fail("非法输入");
        }
        try {
            addressService.removeAddressById(paramBean.getId());
            String username = UserUtils.currUser().getUsername();
            AddressDetailBean bean = new AddressDetailBean();
            bean.setUsername(username)
                    .setId(paramBean.getId())
                    .setDefault(paramBean.isDefault())
                    .setContactsName(paramBean.getcName())
                    .setContactsPhone(paramBean.getcPhone())
                    .setDetailAddress(new AddressExt().setVal(paramBean.getDetail())
                            .setKeyAs(IAddressService.DETAIL).setKeyName("详细地址"))
                    .setSchool(new AddressExt().setVal(paramBean.getSchool())
                            .setKeyAs(IAddressService.SCHOOL).setKeyName("学校"))
                    .setFlow(new AddressExt().setVal(paramBean.getFlow())
                            .setKeyAs(IAddressService.FLOW).setKeyName("楼层"))
                    .setBuild(new AddressExt().setVal(paramBean.getBuild())
                            .setKeyAs(IAddressService.BUILD).setKeyName("楼栋"))
                    .setHouseNumber(new AddressExt().setVal(paramBean.getHouseNum())
                            .setKeyAs(IAddressService.HOUSE_NUM).setKeyName("门牌"));
            addressService.addAddress(bean);
        } catch (Exception e) {
            e.printStackTrace();
            return fail(e.getMessage());
        }

        return success();
    }

    @RequestMapping("/addressEdit/{addressId}")
    public ModelAndView addressEdit(@PathVariable("addressId") int address) {
        AddressDetailBean detailBean = addressService.queryAddressById(address);

        ModelAndView view = new ModelAndView(freemarker("addressEdit"));
        Object flow = commonAddressService.listByType(ICommonAddressService.Type.FLOW);
        Object build = commonAddressService.listByType(ICommonAddressService.Type.BUILD);
        view.addObject("flow", flow);
        view.addObject("build", build);
        view.addObject("title", "收货人");
        view.addObject("data", detailBean);
        return view;
    }

    /**
     * 个人页面
     * @return
     */
    @RequestMapping("/person.html")
    public ModelAndView personPage() {
        ModelAndView view = new ModelAndView(freemarker("person"));
        return view;
    }
}
