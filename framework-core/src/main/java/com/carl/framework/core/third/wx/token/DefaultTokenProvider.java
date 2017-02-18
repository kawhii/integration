package com.carl.framework.core.third.wx.token;

import com.carl.framework.core.pay.RequestException;
import com.carl.framework.util.request.IRequester;
import com.carl.framework.util.request.JsonUrlRequester;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class DefaultTokenProvider implements ITokenProvider {
    protected final Log logger = LogFactory.getLog(DefaultTokenProvider.class);
    private AccessTokenTradeParam param;

    private AccessTokenResult token;

    private IRequester<AccessTokenTradeParam> urlRequester = new JsonUrlRequester();

    public AccessTokenTradeParam getParam() {
        return param;
    }

    public DefaultTokenProvider setParam(AccessTokenTradeParam param) {
        this.param = param;
        return this;
    }

    @Override
    public AccessTokenResult token() {
        return token;
    }

    @Override
    public void refresh() throws TokenRefreshException {
        if (getParam() == null) {
            throw new TokenRefreshException("参数必须");
        }

        try {
            AccessTokenResult result = urlRequester.request(param, AccessTokenResult.class);
            token = result;
        } catch (RequestException e) {
            e.printStackTrace();
            throw new TokenRefreshException(e);
        }
    }

    @Override
    public boolean isExpires() {
        throw new IsExpiresException();
    }
}
