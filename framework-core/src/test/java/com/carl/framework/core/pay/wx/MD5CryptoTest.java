package com.carl.framework.core.pay.wx;

import com.carl.framework.util.MapBuilder;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Create by Administrator on 2017/2/6.
 */
public class MD5CryptoTest {

    @Test
    public void sign() throws Exception {
        MD5Crypto md5Crypto = new MD5Crypto();
        Map<String,String> param = MapBuilder.<String, String>build().p("appid", "2").p("key", "aa");
        System.out.println(md5Crypto.sign(param));
    }
}