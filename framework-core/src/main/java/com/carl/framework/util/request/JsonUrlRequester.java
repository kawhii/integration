package com.carl.framework.util.request;

import com.alibaba.fastjson.JSON;
import com.carl.framework.core.pay.AbsRequestParam;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * 直接通过url获取json
 *
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@Component
public class JsonUrlRequester<P extends AbsRequestParam> extends BaseRequester<P> {
    @Override
    protected <T> T parseResult(InputStream inputStream, Class<T> resultType) throws Exception {
        return JSON.parseObject(inputStream, resultType);
    }

    @Override
    protected HttpMethod method() {
        return HttpMethod.GET;
    }
}
