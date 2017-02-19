package com.carl.framework.core.third.wx.pay.js;

import com.carl.framework.core.pay.wx.WXBaseCrypto;
import org.apache.shiro.crypto.hash.Sha1Hash;

/**
 * 对jsticket进行加密穿
 * <p>
 * <p>
 * 签名算法
 * 签名生成规则如下：参与签名的字段包括noncestr（随机字符串）, 有效的jsapi_ticket, timestamp（时间戳）, url（当前网页的URL，不包含#及其后面部分） 。对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1。这里需要注意的是所有参数名均为小写字符。对string1作sha1加密，字段名和字段值都采用原始值，不进行URL 转义。
 * 即signature=sha1(string1)。 示例：
 * noncestr=Wm3WZYTPz0wzccnW
 * jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg
 * timestamp=1414587457
 * url=http://mp.weixin.qq.com?params=value
 * 步骤1. 对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1：
 * jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg&noncestr=Wm3WZYTPz0wzccnW&timestamp=1414587457&url=http://mp.weixin.qq.com?params=value
 * 步骤2. 对string1进行sha1签名，得到signature：
 * 0f9de62fce790f9a083d5c99e95740ceb90c27ed
 * 注意事项
 * 1.签名用的noncestr和timestamp必须与wx.config中的nonceStr和timestamp相同。
 * 2.签名用的url必须是调用JS接口页面的完整URL。
 * 3.出于安全考虑，开发者必须在服务器端实现签名的逻辑。
 * 如出现invalid signature 等错误详见附录5常见错误及解决办法。
 *
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public abstract class JSTicketCrypto extends WXBaseCrypto {
    @Override
    protected String appendKeyName() {
        return null;
    }

    protected abstract Method signType();

    public enum Method {
        MD5,
        SHA1
    }

    @Override
    protected boolean resultUpperCase() {
        return false;
    }
}
