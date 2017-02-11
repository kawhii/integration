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
                    <img src="${var_domain_url}/file/img/~/${item.goodsImgPath}" alt=""/>
                </div>
                <div class="comment-orders-goods-name">${item.goodsTitle}</div>
                <div class="comment-orders-goods-btn">
                    <a href="/order/${order.id}/${item.goodsId}/commentOrder"><button type="button">评价晒单</button></a>
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