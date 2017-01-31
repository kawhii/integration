/**
 * @date 2017/1/31
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
    function getParams() {
        var formParamArray = $('#ID_addressForm').serializeArray();
        var res = {};
        for (var idx in formParamArray) {
            res[formParamArray[idx].name] = formParamArray[idx].value;
        }
        return res;
    }

    //点击提交
    $('.address-details-footRight button').bind('click', function () {
        carl.request("/user/addAddress", getParams(), function (data) {
            if(data.header.code == 0) {
                carl.toast("新增地址成功");
                location.href = "user/address.html";
            } else {
                carl.toast(data.header.message);
            }
        }, {get: false});
    });
}());
