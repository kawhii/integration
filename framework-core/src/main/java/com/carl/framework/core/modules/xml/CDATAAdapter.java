package com.carl.framework.core.modules.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * CDATA适配器
 *
 * @author Carl
 * @date 2017/2/5
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class CDATAAdapter extends XmlAdapter<String, String> {
    private static final String CDATA_END = "]]>";
    private static final String CDATA_BEGIN = "<![CDATA[";

    @Override
    public String unmarshal(String v) throws Exception {
        if (v.startsWith(CDATA_BEGIN) && v.endsWith(CDATA_END)) {
            v = v.substring(CDATA_BEGIN.length(), v.length() - CDATA_END.length());
        }
        return v;
    }

    @Override
    public String marshal(String v) throws Exception {
        return CDATA_BEGIN + v + CDATA_END;
    }
}
