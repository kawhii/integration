<#include "freemarker/base/mallBase.ftl">
<section class="contain">
    <header class="header">
        <a href="javascript:history.go(-1);"><i class="fa fa-chevron-left fa-1x return"></i></a>
        <a href="javascript:void(0)">
            <button type="button" id="comment-ordersSubmit">提交
            </button>
        </a>
        <p>${order.orderNo}-${goods.goodsTitle}</p>
    </header>

    <!-- comment-ordersSubmit -->
    <main class="comment-ordersSubmit">
        <form id="ID_submitForm" method="post" action="/order/commentOrder">
            <div class="comment-orders-goodsSubmit">
                <div class="comment-orders-goodsSubmit-top">
                    <div class="comment-orders-goodsSubmit-img">
                        <img src="${var_domain_url}/file/img/~/${goods.goodsImgPath}" style="width: 50px;height: 50px"
                             alt=""/>
                    </div>
                    <div class="comment-orders-goodsSubmitDetails">
                        <p>评量</p>
                        <p>
                            <i class="fa fa-star fa-1x"></i>
                            <i class="fa fa-star fa-1x"></i>
                            <i class="fa fa-star fa-1x"></i>
                            <i class="fa fa-star fa-1x"></i>
                            <i class="fa fa-star fa-1x"></i>
                        </p>
                    </div>
                    <div class="clearfix"></div>
                </div>

                <div class="comment-orders-goodsSubmit-content">
                    <textarea name="content" id="ID_content" placeholder="如果你无法简洁的表达你的想法，那只说明你还不够了解它。--爱因斯坦"></textarea>
                </div>
            </div>
        </form>
        <script>
            //提交
            $('#comment-ordersSubmit').click(function () {
                if (!$("#ID_content").val()) {
                    carl.toast("分享一下想法咯~", {
                        timeout: 1200
                    });
                    $("#ID_content").focus();
                    return;
                }
                $('#ID_submitForm').submit();
            });
        </script>
    </main>
    <!-- comment-orders -->
</section>
<#include "freemarker/base/mallEnd.ftl">