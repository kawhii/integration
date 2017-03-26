<#include "freemarker/base/mallBase.ftl">
<section class="contain">
    <header class="header">
        <a href="javascript:history.go(-1);"><i class="fa fa-chevron-left fa-1x return"></i></a>
        <p>评价晒单-${order.orderNo}</p>
    </header>

    <!-- comment-orders -->
    <main class="comment-orders">
    <#list order.items as item>
        <div class="comment-orders-goods">
            <div class="comment-orders-goods-img">
                <img src="${var_domain_url}/file/img/~/${item.goodsImgPath}" style="width: 50px;height: 50px" alt=""/>
            </div>
            <div class="comment-orders-goods-name">${item.goodsTitle}</div>
            <div class="comment-orders-goods-btn">
                <#if item.comment == false>
                    <#--<a href="/order/${order.id}/${item.goodsId}/commentOrder">
                        <button type="button">评价晒单</button>
                    </a>-->
                </#if>
            </div>
            <div class="clearfix"></div>
        </div>
    </#list>
    </main>
    <!-- comment-orders -->
</section>
<script>

</script>
<#include "freemarker/base/mallEnd.ftl">