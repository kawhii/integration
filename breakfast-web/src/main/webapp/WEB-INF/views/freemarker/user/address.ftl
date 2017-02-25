<#include "freemarker/base/mallBase.ftl">
<section class="contain">
    <header class="header">
        <a href="javascript:history.go(-1);"><i class="fa fa-chevron-left fa-1x return"></i></a>
        <p>${title!'收货地址'}</p>
    </header>
    <!-- address -->
    <main class="address">
        <div class="address-main">
        <#if submitOrder>
            <form action="/order/fill" method="post" id="ID_form">
            <#--再次购买以及直接购买的区别-->
                <#if order.rebuy>
                    <input type="hidden" name="orderId" value="${order.data}"/>
                <#else>
                    <#list order.data as id>
                        <input type="hidden" name="carts-choose[]" value="${id}"/>
                    </#list>
                </#if>

                <input type="hidden" name="addressId" id="ID_addressId"/>
            </form>
        </#if>
        <#list address as item>
            <div class="address-main-info  ${item.default?string('address-main-infoBg','')}">

                <div class="clickable">
                    <input type="hidden" class="addressId" value="${item.id}"/>
                    <p>
                        收货人：<span>${item.contactsName}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话：<span>${item.contactsPhone}</span>
                    </p>
                </div>
                <p>收货地址：<span>${item.detail}</span></p>
                <div class="address-main-edit">
                    <div class="address-choose">
                        <div class="address-choosebox ${item.default?string('carts-chooseboxBg','')}"></div>
                        <input type="checkbox" name="address-choose[]"
                        ${item.default?string('checked="false"','')}/>
                        <label>默认地址</label>
                    </div>
                    <div class="address-main-editHome">
                        <a href="/user/addressEdit/${item.id}">
                            <div class="address-edit">

                                <i class="fa fa-edit fa-lg"></i>
                                <p>编辑</p>

                            </div>
                        </a>
                        <div class="address-trash">
                            <a href="javascript:void(0)">
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
            <a href="/user/addAddress.html">
                <button type="button" value=""><i class="fa fa-plus"></i>
                    <p>新增地址</p></button>
            </a>
        </div>
        <script>
            (function () {
                var submitOrder = ${submitOrder?string('true', 'false')};
                if (submitOrder) {
                    $(".address-main .address-main-info .clickable").click(function () {
                        var addressId = $(this).find('.addressId').val();
                        $('#ID_addressId').val(addressId);
                        $('#ID_form').submit();
                    });
                }
            })();
        </script>
        <script src="/js/~/user/address.js"></script>
    </main>
    <!-- address -->

</section>

<#include "freemarker/base/mallEnd.ftl">