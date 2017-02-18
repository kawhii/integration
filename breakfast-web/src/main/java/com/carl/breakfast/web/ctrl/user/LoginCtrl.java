package com.carl.breakfast.web.ctrl.user;

import com.carl.breakfast.dao.sys.pojo.UserInfo;
import com.carl.breakfast.web.ctrl.buyer.OrderCtrl;
import com.carl.breakfast.web.service.IUserService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import static com.carl.breakfast.web.filter.UserInfoAuthenticationFilter.USER_INFO_ATTR_KEY;

/**
 * @author Carl
 * @date 2016/11/20
 */
@Controller
@RequestMapping("/u")
public class LoginCtrl extends BaseCtrl {

    @Autowired
    private IUserService userService;



    protected static final Log logger = LogFactory.getLog(OrderCtrl.class);

    //微信appid
    @Value("${wx.appid}")
    private String appId;
    @Value("${wx.secret}")
    private String secret;

    private IRequester<AccessTokenParam> urlRequester = new JsonUrlRequester();


    @Override
    protected String getModuleName() {
        return "user";
    }

    /**
     * 主要转发freemarker
     * @return
     */
    @RequestMapping(value = "/login")
    public Object login(@Value("${url.index}") String indexUrl) {
        if(SecurityUtils.getSubject().isAuthenticated()) {
            return new ModelAndView(new RedirectView(indexUrl));
        }
        return freemarker("login");
    }

    @RequestMapping(value = "/logout")
    public Object logout(@Value("${url.index}") String indexUrl) {
        return new ModelAndView(new RedirectView(indexUrl));
    }

    @RequestMapping("/wxl")
    public ModelAndView wxLogin(@RequestParam("code") String code, @RequestParam("state") String state) {
        //登陆
        try {
            wxlogin(code);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            //todo 微信登陆异常处理
        }
        return new ModelAndView(new RedirectView("/goods/index.html"));
    }

    /**
     * 利用微信的code进行登陆
     *
     * @param code
     * @throws Exception
     */
    private void wxlogin(String code) throws Exception {
        logger.info("微信登陆：" + code);
        AccessTokenParam tokenParam = new AccessTokenParam(appId, secret, code);
//        AccessTokenResult accessTokenResult = urlRequester.request(tokenParam, AccessTokenResult.class);
        AccessTokenResult accessTokenResult = new AccessTokenResult().setOpenid("112233");
        //获取openid失败
        if (accessTokenResult.getErrcode() != 0) {
            throw new AuthenticationException("获取openid失败");
        }
        UserInfo userInfo = userService.findByUsername(accessTokenResult.getOpenid());
        if(userInfo == null) {
            logger.info("openid不存在进行注册。");
            userInfo = new UserInfo().setUsername(accessTokenResult.getOpenid());
            userService.registerOpenId(userInfo);
        }
        WXAuthenticationToken wxAuthenticationToken = new WXAuthenticationToken(accessTokenResult);
        SecurityUtils.getSubject().login(wxAuthenticationToken);
        SecurityUtils.getSubject().getSession().setAttribute(USER_INFO_ATTR_KEY, userInfo);
        logger.info("【" + code + "】登陆成功");
    }
}
