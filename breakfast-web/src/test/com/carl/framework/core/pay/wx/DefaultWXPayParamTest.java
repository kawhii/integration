package com.carl.framework.core.pay.wx;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import java.io.StringWriter;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/2/5.
 */
public class DefaultWXPayParamTest {
    @Test
    public void genXml() throws Exception {
        DefaultWXPayParam defaultWXPayParam = new DefaultWXPayParam();
        defaultWXPayParam.setAppid("123Appid")
        .setSignType("sigType");
        JAXBContext context = JAXBContext.newInstance(DefaultWXPayParam.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(defaultWXPayParam, writer);
        System.out.println(writer.toString());

    }
}