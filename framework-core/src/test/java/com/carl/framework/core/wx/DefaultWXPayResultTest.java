package com.carl.framework.core.wx;

import com.carl.framework.core.pay.wx.DefaultWXPayResult;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by Administrator on 2017/2/5.
 */
public class DefaultWXPayResultTest {
    @Test
    public void genXml() throws Exception {
        DefaultWXPayResult defaultWXPayParam = new DefaultWXPayResult();
        defaultWXPayParam.setAppid("123Appid")
                .setPrepayId("PrepayId")
                .setCodeUrl("www.url.com");
        JAXBContext context = JAXBContext.newInstance(DefaultWXPayResult.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(defaultWXPayParam, writer);
        System.out.println(writer.toString());
    }
}