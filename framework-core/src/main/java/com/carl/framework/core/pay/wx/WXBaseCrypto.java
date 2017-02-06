package com.carl.framework.core.pay.wx;

import com.carl.framework.core.pay.crypto.CryptoException;
import com.carl.framework.core.pay.crypto.ICrypto;
import com.carl.framework.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Carl
 * @date 2017/2/6
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
public abstract class WXBaseCrypto implements WXCrypto, ICrypto {
    protected static final Log logger = LogFactory.getLog(WXBaseCrypto.class);

    /**
     * 具体见<a href="https://pay.weixin.qq.com/wiki/tools/signverify/">校验签名</a>
     * 具体见<a href="https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=4_3">官方说明</a>
     *
     * @param params
     * @return
     * @throws CryptoException
     */
    @Override
    public String sign(Map<String, String> params, String secKey) throws CryptoException {
        TreeMap<String, String> sortMap = new TreeMap<>(params);
        StringBuilder sb = new StringBuilder();
        Set es = sortMap.entrySet();//所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v)
                    && !"sign".equals(k)/* && !"key".equals(k)*/) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append(appenKeyName());
        sb.append("=" + secKey);
        logger.debug("加密串：" + sb.toString());
        String res = fromHexString(sb.toString());
        return !StringUtil.isNull(res) ? res.toUpperCase() : null;
    }

    /**
     * 对字符串进行加密
     *
     * @param str
     * @return
     */
    protected abstract String fromHexString(String str);

    /**
     * 追加的keyname
     *
     * @return
     */
    protected abstract String appenKeyName();
}
