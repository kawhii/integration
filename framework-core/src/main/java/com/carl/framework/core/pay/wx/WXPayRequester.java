package com.carl.framework.core.pay.wx;

import com.carl.framework.util.MapBuilder;
import com.carl.framework.util.request.BaseRequester;
import com.carl.framework.core.pay.crypto.CryptoException;
import com.carl.framework.util.XmlUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.JDOMException;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 微信网络请求
 *
 * @author Carl
 * @date 2017/2/5
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@Component("wxPayRequester")
public class WXPayRequester extends BaseRequester<WXRequestParam> {
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
    protected <T> T parseResult(InputStream inputStream, Class<T> resultType) throws Exception {
        return parseStreamAndReturn(inputStream, resultType);
    }

    @Override
    protected HttpMethod method() {
        return HttpMethod.POST;
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

    @Override
    protected MapBuilder<String, List<String>> headers() {
        ArrayList<String> type = new ArrayList<>(Arrays.asList(new String[]{"application/xml"}));
        return super.headers().p("content-type", type);
    }

    @Override
    protected byte[] body(WXRequestParam param)  throws Exception {
        //是否签名
        if (isCreateSign()) {
            setSign(param.getBody(), param.getSecKey());
        }
        //获取到xml内容
        byte[] content = XmlUtils.obj2xmlByte(param.getBody());

        logger.debug(IOUtils.toString(new ByteArrayInputStream(content), "UTF-8"));
        return content;
    }
}
