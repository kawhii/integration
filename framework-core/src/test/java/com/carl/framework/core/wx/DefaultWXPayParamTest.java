package com.carl.framework.core.wx;

import com.carl.framework.core.pay.wx.DefaultWXPayParam;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by Administrator on 2017/2/5.
 */
public class DefaultWXPayParamTest {
    @Test
    public void genXml() throws Exception {
        DefaultWXPayParam defaultWXPayParam = new DefaultWXPayParam();
        defaultWXPayParam.setAppid("123Appid")
                .setSignType("sigType")
                .setDetail("{goodsId:1}");
        JAXBContext context = JAXBContext.newInstance(DefaultWXPayParam.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(defaultWXPayParam, writer);
        System.out.println(writer.toString());

    }
}