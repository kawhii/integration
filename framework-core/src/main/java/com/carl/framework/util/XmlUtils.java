package com.carl.framework.util;

import org.apache.commons.io.IOUtils;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Carl
 * @date 2017/2/6
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public abstract class XmlUtils {

    /**
     * 对象转输出流
     * @param obj
     * @return
     * @throws JAXBException
     */
    public static byte[] obj2xmlByte(Object obj) throws JAXBException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //把对象转成xml
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(obj, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /**
     * 对象转xml字符串
     * @param obj
     * @return
     * @throws JAXBException
     */
    public static String obj2xmlStr(Object obj) throws JAXBException, IOException {
        byte[] bytes = obj2xmlByte(obj);
        return IOUtils.toString(new ByteArrayInputStream(bytes) , "UTF-8");
    }

    /**
     * 把xml文件转换为map形式，其中key为有值的节点名称，并以其所有的祖先节点为前缀，用
     * "."相连接。如：SubscribeServiceReq.Send_Address.Address_Info.DeviceType
     *
     * @param xmlStr xml内容
     * @return Map 转换为map返回
     */
    public static Map<String, String> xml2Map(String xmlStr) throws JDOMException, IOException {
        TreeMap<String, String> rtnMap = new TreeMap<>();
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(new StringReader(xmlStr));
        // 得到根节点
        Element root = doc.getRootElement();
        String rootName = root.getName();
        // 调用递归函数，得到所有最底层元素的名称和值，加入map中
        convert(root, rtnMap, rootName);
        return rtnMap;
    }

    public static Map<String, String> xml2Map(InputStream inputStream) throws JDOMException, IOException {
        return xml2Map(IOUtils.toString(inputStream));
    }

    /**
     * 递归函数，找出最下层的节点并加入到map中，由xml2Map方法调用。
     *
     * @param e        xml节点，包括根节点
     * @param map      目标map
     * @param lastname 从根节点到上一级节点名称连接的字串
     */
    @SuppressWarnings("rawtypes")
    public static void convert(Element e, Map<String, String> map, String lastname) {
        if (e.getAttributes().size() > 0) {
            Iterator it_attr = e.getAttributes().iterator();
            while (it_attr.hasNext()) {
                Attribute attribute = (Attribute) it_attr.next();
                String attrname = attribute.getName();
                String attrvalue = e.getAttributeValue(attrname);
                // map.put( attrname, attrvalue);
                map.put(lastname + "." + attrname, attrvalue); // key 根据根节点 进行生成
            }
        }
        List children = e.getChildren();
        Iterator it = children.iterator();
        while (it.hasNext()) {
            Element child = (Element) it.next();
            /* String name = lastname + "." + child.getName(); */
            String name = child.getName();
            // 如果有子节点，则递归调用
            if (child.getChildren().size() > 0) {
                convert(child, map, lastname + "." + child.getName());
            } else {
                // 如果没有子节点，则把值加入map
                map.put(name, child.getText());
                // 如果该节点有属性，则把所有的属性值也加入map
                if (child.getAttributes().size() > 0) {
                    Iterator attr = child.getAttributes().iterator();
                    while (attr.hasNext()) {
                        Attribute attribute = (Attribute) attr.next();
                        String attrname = attribute.getName();
                        String attrvalue = child.getAttributeValue(attrname);
                        map.put(lastname + "." + child.getName() + "." + attrname, attrvalue);
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws JDOMException, IOException {
        String str = "<xml><appid><a>aaaa</a><b>bbbbceshi</b></appid><attach>支付测试</attach><body>APP支付测试</body><mch_id>10000100</mch_id><nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>"
                + "<notify_url>http://wxpay.weixin.qq.com/pub_v2/pay/notify.v2.php</notify_url><out_trade_no>1415659990</out_trade_no><spbill_create_ip>14.23.150.211</spbill_create_ip>"
                + "<total_fee>1</total_fee><trade_type>APP</trade_type><sign>0CB01533B8C1EF103065174F50BCA001</sign></xml>";

        System.out.println(xml2Map(str));
    }
}
