package com.carl.framework.util.request;

import com.carl.framework.core.pay.AbsRequestParam;
import com.carl.framework.core.pay.RequestException;
import com.carl.framework.util.MapBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.AsyncClientHttpRequest;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.OkHttpClientHttpRequestFactory;

import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public abstract class BaseRequester<P extends AbsRequestParam> implements IRequester<P> {

    public <T> T request(P param, Class<T> resultType) throws RequestException {
        try {
            //请求工厂
            OkHttpClientHttpRequestFactory factory = new OkHttpClientHttpRequestFactory();
            factory.setConnectTimeout(param.getConnectTimeOut());
            factory.setReadTimeout(param.getReadTimeOut());
            factory.setWriteTimeout(param.getWriteTimeout());

            HttpRequest request;
            if (param.isSync()) {
                //设置头部
                request = factory.createRequest(new URI(param.getUrl()), method());
            } else {
                request = factory.createAsyncRequest(new URI(param.getUrl()), method());
            }

            Map<String, List<String>> headers = headers();
            if (headers != null && !headers.isEmpty()) {
                request.getHeaders().putAll(headers);
            }

            byte[] content = body(param);

            if (content != null) {
                ((HttpOutputMessage) request).getBody().write(content);
            }

            ClientHttpResponse response;
            //请求并且获取内容
            if (param.isSync()) {
                response = ((ClientHttpRequest) request).execute();
            } else {
                response = ((AsyncClientHttpRequest) request).executeAsync().get();
            }
            //请求成功
            if (response.getStatusCode().is2xxSuccessful()) {
                return parseResult(response.getBody(), resultType);
            } else {
                RequestException ex = new RequestException("微信接口请求失败");
                ex.setParam(param);
                throw ex;
            }
        } catch (Exception e) {
            throw new RequestException(e);
        }
    }

    /**
     * 请求头
     *
     * @return
     */
    protected MapBuilder<String, List<String>> headers() {
        return MapBuilder.build();
    }

    /**
     * 请求头
     *
     * @return
     */
    protected byte[] body(P param) throws Exception {
        return null;
    }

    /**
     * 解析结果集
     * @param inputStream
     * @param resultType
     * @param <T>
     * @return
     * @throws Exception
     */
    protected abstract <T> T parseResult(InputStream inputStream, Class<T> resultType) throws Exception;

    /**
     * 请求方法
     * @return
     */
    protected abstract HttpMethod method();
}
