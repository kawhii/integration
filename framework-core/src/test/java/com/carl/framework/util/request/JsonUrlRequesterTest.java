package com.carl.framework.util.request;

import com.carl.framework.core.third.wx.token.AccessTokenAuthParam;
import com.carl.framework.core.third.wx.token.AccessTokenParam;
import com.carl.framework.core.third.wx.token.AccessTokenResult;
import com.carl.framework.core.third.wx.token.BaseResult;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/2/18.
 */
public class JsonUrlRequesterTest {

    @Test
    //获取accessToken
    public void main() throws Exception {
        IRequester<AccessTokenParam> urlRequester = new JsonUrlRequester();
        AccessTokenParam param = new AccessTokenParam("wx6d72707ef14de6c0", "234", "031QCk8a2xCJOQ02kOba2GVt8a2QCk8p");
        AccessTokenResult result = urlRequester.request(param, AccessTokenResult.class);
        System.out.println(result);
    }

    @Test
    //获取accessToken
    public void auth() throws Exception {
        IRequester<AccessTokenAuthParam> urlRequester = new JsonUrlRequester();
        AccessTokenAuthParam param = new AccessTokenAuthParam("nHLkV3uLHx_xujLrj8dNhEuNpvCEGYpqakc4BtGyk6U8R-3zkADv9iqF3PeVkhUZPXpn0kDxU6O_e7JEMexQW_iAFDcUuk8MMsKl7DWLxlM", "o71CQwOCjLONHssbX3zsfJ413FJ4");
        BaseResult result = urlRequester.request(param, BaseResult.class);
        System.out.println(result);
    }
}