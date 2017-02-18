package com.carl.framework.util.request;

import com.carl.framework.core.third.wx.token.AccessTokenParam;
import com.carl.framework.core.third.wx.token.AccessTokenResult;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/2/18.
 */
public class JsonUrlRequesterTest {

    @Test
    public void main() throws Exception {
        IRequester<AccessTokenParam> urlRequester = new JsonUrlRequester();
        AccessTokenParam param = new AccessTokenParam("wx6d72707ef14de6c0", "234", "031QCk8a2xCJOQ02kOba2GVt8a2QCk8p");
        AccessTokenResult result = urlRequester.request(param, AccessTokenResult.class);
        System.out.println(result);
    }
}