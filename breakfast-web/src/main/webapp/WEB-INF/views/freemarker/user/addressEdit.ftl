<#include "freemarker/base/mallBase.ftl">
<section class="contain">
    <header class="header">
        <a href="javascript:history.go(-1);"><i class="fa fa-chevron-left fa-1x return"></i></a>
        <p>${title!'收货人'}</p>
    </header>
    <!-- address-details -->
    <main class="address-details">
        <div class="address-details-main">
            <ul>
                <li>
                    <label>收货人：</label>
                    <input type="text" value=""/>
                </li>
                <li>
                    <label>联系方式：</label>
                    <input type="text" value=""/>
                </li>
                <li>
                    <label>学校：</label>
                    <select>
                        <option>广州大学</option>
                    </select>
                </li>
                <li>
                    <label>楼栋：</label>
                    <select>
                        <#list build as item>
                            <option value="${item.id}">${item.info}</option>
                        </#list>
                    </select>
                </li>
                <li>
                    <label>楼层：</label>
                    <select>
                    <#list flow as item>
                        <option value="${item.id}">${item.info}</option>
                    </#list>
                    </select>
                </li>
                <li>
                    <label>门牌号：</label>
                    <input type="text" value=""/>
                </li>
                <li>
                    <textarea placeholder="详细地址：可不填"></textarea>
                </li>
            </ul>
        </div>

        <div class="address-details-foot">
            <div class="address-details-footLeft">
                <div class="address-details-choose">
                    <div class="address-details-choosebox"></div>
                    <input type="checkbox" name="address-details-choose[]"/>
                    <label>默认收货地址</label>
                </div>
            </div>
            <div class="address-details-footRight">
                <button type="button" value="" class="save">保存</button>
            </div>
        </div>
    </main>
    <!-- address-details -->

</section>

<#include "freemarker/base/mallEnd.ftl">