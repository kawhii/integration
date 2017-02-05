package com.carl.framework.core.pay.wx;

import com.carl.framework.core.pay.IPayRequester;
import com.carl.framework.core.pay.RequestException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.AsyncClientHttpRequest;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.OkHttpClientHttpRequestFactory;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.net.URI;

/**
 * 微信网络请求
 *
 * @author Carl
 * @date 2017/2/5
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@Component("wxPayRequester")
public class WXPayRequester implements IPayRequester<WXRequestParam> {

    @Override
    public <T> T request(WXRequestParam param, Class<T> resultType) throws RequestException {
        try {
            //请求工厂
            OkHttpClientHttpRequestFactory factory = new OkHttpClientHttpRequestFactory();
            factory.setConnectTimeout(param.getConnectTimeOut());
            factory.setReadTimeout(param.getReadTimeOut());
            factory.setWriteTimeout(param.getWriteTimeout());

            HttpRequest request;

            if (param.isSync()) {
                //设置头部
                request = factory.createRequest(new URI(param.getUrl()), HttpMethod.POST);
            } else {
                request = factory.createAsyncRequest(new URI(param.getUrl()), HttpMethod.POST);
            }

            request.getHeaders()
                    .add("content-type", "application/xml");
            request.getHeaders()
                    .add("cache-control", "no-cache");

            //把对象转成xml
            JAXBContext context = JAXBContext.newInstance(param.getBody().getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(param.getBody(), ((HttpOutputMessage) request).getBody());

            ClientHttpResponse response;
            //请求
            if (param.isSync()) {
                response = ((ClientHttpRequest) request).execute();
            } else {
                response = ((AsyncClientHttpRequest) request).executeAsync().get();
            }
            //请求成功
            if (response.getStatusCode().is2xxSuccessful()) {
                return parseStreamAndReturn(response.getBody(), resultType);
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
     * 解析六并且返回
     *
     * @param inputStream
     * @param type
     * @return
     * @throws Exception
     */
    private <T> T parseStreamAndReturn(InputStream inputStream, Class<T> type) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(type);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (T) jaxbUnmarshaller.unmarshal(inputStream);
    }
}
