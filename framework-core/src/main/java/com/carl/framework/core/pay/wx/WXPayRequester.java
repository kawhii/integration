package com.carl.framework.core.pay.wx;

import com.carl.framework.core.pay.IPayRequester;
import com.carl.framework.core.pay.RequestException;
import com.carl.framework.core.pay.crypto.CryptoException;
import com.carl.framework.util.XmlUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.JDOMException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.AsyncClientHttpRequest;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.OkHttpClientHttpRequestFactory;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

/**
 * 微信网络请求
 *
 * @author Carl
 * @date 2017/2/5
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@Component("wxPayRequester")
public class WXPayRequester implements IPayRequester<WXRequestParam> {
    protected static final Log logger = LogFactory.getLog(WXBaseCrypto.class);
    //是否自动生成 sign
    private boolean createSign = true;

    //默认签名为MD5
    private WXCrypto crypto = new MD5Crypto();

    public boolean isCreateSign() {
        return createSign;
    }

    public WXPayRequester setCreateSign(boolean createSign) {
        this.createSign = createSign;
        return this;
    }

    public WXCrypto getCrypto() {
        return crypto;
    }

    public WXPayRequester setCrypto(WXCrypto crypto) {
        this.crypto = crypto;
        return this;
    }

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

            //是否签名
            if (isCreateSign()) {
                setSign(param.getBody(), param.getSecKey());
            }

            //获取到xml内容
            byte[] content = XmlUtils.obj2xmlByte(param.getBody());

            logger.debug(IOUtils.toString(new ByteArrayInputStream(content)));

            //写出
            ((HttpOutputMessage) request).getBody().write(content);

            ClientHttpResponse response;
            //请求并且获取内容
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
     * 设置签名
     *
     * @param param
     * @param secKey 秘钥
     * @throws JAXBException
     * @throws IOException
     * @throws JDOMException
     * @throws CryptoException
     */
    protected void setSign(WXPayBaseParam param, String secKey) throws JAXBException, IOException, JDOMException, CryptoException {
        String xmlStr = XmlUtils.obj2xmlStr(param);
        Map<String, String> objMap = XmlUtils.xml2Map(xmlStr);
        String sign = crypto.sign(objMap, secKey);
        param.setSign(sign);
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
