<#include "freemarker/base/mallBase.ftl">
<section class="contain">
    <header class="header">
        <a href="javascript:history.go(-1);"><i class="fa fa-chevron-left fa-1x return"></i></a>
        <p>${title!'收货地址'}</p>
    </header>
    <!-- address -->
    <main class="address">
        <div class="address-main">

        <#list address as item>
            <div class="address-main-info  ${item.default?string('address-main-infoBg','')}">
                <input type="hidden" id="${item.id}"/>
                <p>收货人：<span>${item.contactsName}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话：<span>${item.contactsPhone}</span></p>
                <p>收货地址：<span>${item.detail}</span></p>
                <div class="address-main-edit">
                    <div class="address-choose">
                        <div class="address-choosebox ${item.default?string('carts-chooseboxBg','')}"></div>
                        <input type="checkbox" name="address-choose[]"
                               ${item.default?string('checked="false"','')}/>
                        <label>默认地址</label>
                    </div>
                    <div class="address-main-editHome">
                        <div class="address-edit">
                            <a href="address-details.html">
                                <i class="fa fa-edit fa-lg"></i>
                                <p>编辑</p>
                            </a>
                        </div>
                        <div class="address-trash">
                            <a href="#">
                                <i class="fa fa-trash-o fa-lg"></i>
                                <p>删除</p>
                            </a>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </#list>
        </div>

        <div class="address-foot">
            <a href="address-details.html"><button type="button" value=""><i class="fa fa-plus"></i><p>新增地址</p></button></a>
        </div>
        <script src="/js/~/user/address.js"></script>
    </main>
    <!-- address -->

</section>

<#include "freemarker/base/mallEnd.ftl">