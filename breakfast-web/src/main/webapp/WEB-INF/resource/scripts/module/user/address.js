/**
 * @date 2017/1/30
 *
 * @author Carl
 * @note
 * --------------------
 * @depend
 * @modify
 * 版权所有.(c)2008-2017.卡尔工作室
 */
!(function () {
    'use strict';

    //删除
    $(".address-trash").on("touchstart", function (event) {
        var idInput = $(this).parent().parent().parent('.address-main-info').find('input[type="hidden"]');
        var id = idInput.val();
        var _this = this;
        carl.request("/user/removeAddress", {addressId: id}, function (d) {
            if (d.header.code == 0) {
                idInput.parent().parent().remove();
            }
        });
    });
    //选中
    $(".address-choose").on("touchstart", function (event) {
        if (event.originalEvent.changedTouches.length == 1) {
            event.preventDefault();
            var idInput = $(this).parent().parent().find('input');
            var id = idInput.val();
            var _this = this;
            //修改默认地址
            carl.request("/user/setDefaultAddress", {addressId: id}, function (d) {
                if (d.header.code == 0) {
                    /*$(".address-main-info").removeClass("address-main-infoBg");
                     $(this).parents(".address-main-info").addClass("address-main-infoBg");*/
                    $(".address-main-info").find(".address-choosebox").removeClass("carts-chooseboxBg");
                    $(".address-main-info").find("input").prop("checked", false);
                    $(_this).find(".address-choosebox").addClass("carts-chooseboxBg");
                    $(_this).find("input").prop("checked", true);
                }
            });
        }
    });
}());
