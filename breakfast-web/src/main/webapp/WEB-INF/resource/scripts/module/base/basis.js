
$(function(){

    var bodyHeight = $(document).height();
    //FIXME 解决高度设置的问题
    // $(".contain").height(bodyHeight);

    /*============== home首页 ================ */
    //首页点击添加商品提示
    // $(".home-plus i,.details-foot button,.carts-goodsRight").on("touchstart",function(event){
    //     if(event.originalEvent.changedTouches.length == 1){
    //         event.preventDefault();
    //         $(".home-plusHint").addClass("plusHint");
    //         setTimeout(removeHint,1000);
    //     }
    // });
    // function removeHint(){
    //     $(".home-plusHint").removeClass("plusHint");
    // }

    //图片切换
    main_imgLength = $(".main_img ul li").size();
    $("#main_imgTotal").html(main_imgLength);

    /*============== details商品详情 ================ */
    //var $(".main_img img").height();

    //点击购物车提示加入成功
    /*$(".details-foot button").on("touchstart",function(event){
        if(event.originalEvent.changedTouches.length == 1) {
            event.preventDefault();

            $(".details-footHint").show();
        }
    });*/

    /*============== cars购物车 ================ */
    var cartsHeight = $(".carts-goods").height();
    $(".carts-goodsRight").height(cartsHeight).css("line-height",cartsHeight+"px");

    //实现向左滑动删除商品
    var x,y,x1,y1,xDiffer,yDiffer;
    $(".carts-goods").on("touchstart",function(event){
        var e = event.originalEvent.changedTouches[0];
        if(event.originalEvent.changedTouches.length == 1){
           // event.preventDefault();

            x = e.clientX;
            y = e.clientY;
        }
    });

    $(".carts-goodsLeft").on("touchmove",function(event){
        var e = event.originalEvent.changedTouches[0];
        if(event.originalEvent.changedTouches.length == 1){
            event.preventDefault();

            x1 = e.clientX;
            y1 = e.clientY;

            xDiffer = x1 - x;
            yDiffer = y1 - y;

            /*if(xDiffer >= 0 && xDiffer <= 50){
                $(this).css("left",-xDiffer+"px");
                $(this).parent().find(".carts-goodsRight").css("right",-(50-xDiffer)+"px");
            }else{
                $(this).css("left","-50px");
                $(this).parent().find(".carts-goodsRight").css("right","0");
            }*/

        }
    });

    $(".carts-goodsLeft").on("touchend",function(event){
        var e = event.originalEvent.changedTouches[0];
        if(event.originalEvent.changedTouches.length == 1){
           // event.preventDefault();

            if(xDiffer < 0){
                $(this).animate({
                    left: "-50px"
                });
                $(this).parent().find(".carts-goodsRight").animate({
                    right: "0"
                });
            }else if(xDiffer > 0){
                $(this).animate({
                    left: "0"
                });
                $(this).parent().find(".carts-goodsRight").animate({
                    right: "-50px"
                });
            }
        }
    });

    //点击删除购物车商品弹出提示框
    /*$(".carts-goodsRight").on("touchstart",function(event){
        if(event.originalEvent.changedTouches.length == 1){
            event.preventDefault();

            $("#cartsdeleteHint").show(500);
        }
    });

    $(".popupHintBtn button").on("touchstart",function(event){
        if(event.originalEvent.changedTouches.length == 1){
            event.preventDefault();

            $("#cartsdeleteHint").hide(500);
        }
    });*/

    //复选按钮的选中与未选中
    $(".carts-choose").on("touchstart",function(event){
        if(event.originalEvent.changedTouches.length == 1) {
            event.preventDefault();
            if ($(this).parentsUntil(".carts-main").find(".carts-choosebox").hasClass("carts-chooseboxBg")) {
                $(this).parentsUntil(".carts-main").find(".carts-choosebox").removeClass("carts-chooseboxBg");
                $(this).parentsUntil(".carts-main").find("input").prop("checked", false);
                cartsNum();
            } else {
                $(this).parentsUntil(".carts-main").find(".carts-choosebox").addClass("carts-chooseboxBg");
                $(this).parentsUntil(".carts-main").find("input").prop("checked", true);
                cartsNum();
            }
        }
    });

    //计算购物车选中商品数量和总价格
    function cartsNum(){
        var cartsNum = $(".carts-main input:checked").length;
        $(".cartsNum").text(cartsNum);

        //计算商品总数量
        var divNum = $(".carts-main>div").size();

        //计算被选中商品总价格
        var priceTotal = 0;
        for(var i=0;i<divNum;i++){
            var choosediv = $(".carts-main>div:eq("+i+")");
            if(choosediv.find(".carts-choosebox").hasClass("carts-chooseboxBg")){
                var price = choosediv.find(".carts-goods-price").html().substring(1);
                var singleNum = choosediv.find(".singleNum").html();
                priceTotal += parseInt(price) * parseInt(singleNum);
                $(".priceTotal").html("￥"+priceTotal.toFixed(2));
            }
        }

        //当选中商品为0时，总价格为0
        if(cartsNum == 0){
            $(".priceTotal").html("￥0.00");
        }
    }
    cartsNum();

    //单个商品的数量加减
    /*$(".carts-minus").on("touchstart",function(event){
        if(event.originalEvent.changedTouches.length == 1) {
            event.preventDefault();
            var singleNum = parseInt($(this).parent().find(".singleNum").html());
            if (singleNum > 1) {
                $(this).parent().find(".singleNum").html(singleNum - 1);
            } else {
                $(this).parent().find(".singleNum").html(1);
            }
            cartsNum();
        }
    });
    $(".carts-plus").on("touchstart",function(event){
        if(event.originalEvent.changedTouches.length == 1) {
            event.preventDefault();
            var singleNum = parseInt($(this).parent().find(".singleNum").html());
            if (singleNum <= 10000) {
                $(this).parent().find(".singleNum").html(singleNum + 1);
            } else {
                $(this).parent().find(".singleNum").html(10000);
            }
            cartsNum();
        }
    });*/

    //全选商品
    $(".carts-chooseAllbox,.carts-chooseAllbox_p").on("touchstart",function(event){
        if(event.originalEvent.changedTouches.length == 1) {
            event.preventDefault();
            if ($(".carts-chooseAllbox").hasClass("carts-chooseboxBg")) {
                $(".carts-chooseAllbox").parent().find("input").prop("checked", false);
                $(".carts-chooseAllbox").removeClass("carts-chooseboxBg");

                $(".carts-main input").prop("checked", false);
                $(".carts-choosebox").removeClass("carts-chooseboxBg");

                cartsNum();
            } else {
                $(".carts-chooseAllbox").parent().find("input").prop("checked", true);
                $(".carts-chooseAllbox").addClass("carts-chooseboxBg");

                $(".carts-main input").prop("checked", true);
                $(".carts-choosebox").addClass("carts-chooseboxBg");

                cartsNum();
            }
        }
    });

    //点击购物车编辑功能
    var editHide = 0;
    $(".carts-edit").on("touchstart",function(event){
        if(event.originalEvent.changedTouches.length == 1) {
            event.preventDefault();

            if(editHide == 0){
                $(this).html("完成");
                $(this).val(0);
                $(".carts-price p").hide();
                $(".carts-count").html('删除( <span class="cartsNum">0</span> )');
                editHide = 1;

                cartsNum();
            }else{
                $(this).html("编辑");
                $(this).val(1);
                $(".carts-price p").show();
                $(".carts-count").html('结算( <span class="cartsNum">0</span> )');
                editHide = 0;

                cartsNum();
            }

        }
    });

    /*============== orders-fill填写订单================ */
    //复选按钮的选中与未选中
    $(".orders-fill-choose").on("touchstart",function(event){
        if(event.originalEvent.changedTouches.length == 1){
            event.preventDefault();

            if($(this).find(".orders-fill-choosebox").hasClass("carts-chooseboxBg")){
                $(this).find(".orders-fill-choosebox").removeClass("carts-chooseboxBg");
                $(this).find("input").prop("checked", false);
            }else{
                $(this).find(".orders-fill-choosebox").addClass("carts-chooseboxBg");
                $(this).find("input").prop("checked", true);
            }

        }
    });

    //点击返回弹出提示框
    $("#orders-fillReturn").on("touchstart",function(event){
        if(event.originalEvent.changedTouches.length == 1){
            event.preventDefault();

            $("#returnHint").show(500);
        }
    });

    $("#returnHint ul>li").on("touchstart",function(event){
        if(event.originalEvent.changedTouches.length == 1){
            event.preventDefault();

            $("#returnHint").hide(500);
        }
    });



    /*============== address收货地址 ================ */
    //复选按钮的选中与未选中
    /*$(".address-choose").on("touchstart",function(event){
        if(event.originalEvent.changedTouches.length == 1) {
            event.preventDefault();

            /!*$(".address-main-info").removeClass("address-main-infoBg");
            $(this).parents(".address-main-info").addClass("address-main-infoBg");*!/
            $(".address-main-info").find(".address-choosebox").removeClass("carts-chooseboxBg");
            $(".address-main-info").find("input").prop("checked", false);
            $(this).find(".address-choosebox").addClass("carts-chooseboxBg");
            $(this).find("input").prop("checked", true);
        }
    });*/

    $(".address-main-info").on("touchstart",function(event){
        if(event.originalEvent.changedTouches.length == 1) {
           // event.preventDefault();

            $(".address-main-info").removeClass("address-main-infoBg");
            $(this).addClass("address-main-infoBg");
        }
    });

    /*============== address-details收货人 ================ */
    //复选按钮的选中与未选中
    $(".address-details-choose").on("touchstart",function(event){
        if(event.originalEvent.changedTouches.length == 1){
           // event.preventDefault();

            if($(this).find(".address-details-choosebox").hasClass("carts-chooseboxBg")){
                $(this).find(".address-details-choosebox").removeClass("carts-chooseboxBg");
                $(this).find("input").prop("checked", false);
            }else{
                $(this).find(".address-details-choosebox").addClass("carts-chooseboxBg");
                $(this).find("input").prop("checked", true);
            }

        }
    });

    //点击删除订单弹出提示框
    $(".ordersDeleteBtn").on("touchstart",function(event){
        if(event.originalEvent.changedTouches.length == 1){
            event.preventDefault();

            $("#deleteHint").show(500);
        }
    });

    $("#deleteHint ul>li").on("touchstart",function(event){
        if(event.originalEvent.changedTouches.length == 1){
            event.preventDefault();

            $("#deleteHint").hide(500);
        }
    });




});