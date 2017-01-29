/**
 * @date 2017/1/28
 *
 * @author Carl
 * @note
 * --------------------
 * @depend
 * @modify
 * 版权所有.(c)2008-2017.广州市森锐科技股份有限公司
 */
!(function () {
    'use strict';
    var carl = {};


    //队列
    var requestQuen = [];

    function request(url, data, callback, opt) {
        var defSetting = {filterError: false, mask: true, get: true};
        var setting = $.extend({}, defSetting, opt);

        function startMask(setting) {
            if (setting.mask) {
                requestQuen.push(1);
            }
            //mask
            if (requestQuen.length == 1 && setting.mask) {
                showMask();
            }
        }

        //请求完成mask
        function completeMask(setting) {
            if (setting.mask) {
                requestQuen.splice(0, 1);
                //取消遮罩层
                if (requestQuen.length == 0) {
                    hideMask();
                }
            }
        }

        startMask(setting);

        $.ajax({
            type: setting.get ? 'GET' : 'POST',
            url: url,
            contentType: setting.get ? null : "application/json; charset=utf-8",
            data: data ? (setting.get ? data : JSON.stringify(data)) : '',
            dataType: "json",
            success: function (data) {
                completeMask(setting);
                if (callback) {
                    callback(data);
                }
            },
            error: function (data) {
                completeMask(setting);
                if (callback) {
                    callback(data);
                }
            }
        });
        /*$[setting.get ? 'get' : 'post'](url, data, function (data) {
         completeMask(setting);
         if (callback) {
         callback(data);
         }

         }, 'json');*/
    }

    /**
     * 异步请求
     * @param url 路径
     * @param params 参数
     * @param callback 回调函数
     * @param opt 可选参数
     */
    carl.request = function (url, params, callback, opt) {
        request(url, params, callback, opt);
    };


    //兼容火狐、IE8
    //显示遮罩层
    function showMask(msg) {
        msg = msg ? msg : '加载中...';
        $("#ID_mask").html(msg);
        $("#ID_mask").addClass("plusHint");
        $("#ID_mask").show();
    }

    //隐藏遮罩层
    function hideMask() {
        $("#ID_mask").removeClass("plusHint");
        $("#ID_mask").hide();
    }

    /**
     * 吐丝
     * @param msg
     */
    carl.toast = function (msg) {
        showMask(msg);
        setTimeout(hideMask, 800);
    };

    window.carl = carl;
}(window));
