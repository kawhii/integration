
$(function(){
	/*------------使广告轮播图的高度适应浏览器------------*/
	function main_img(){
		var main_imgHeight;
		if($(window).width() >= 480){
			main_imgHeight=$(".main_img ul li img:first").height();
		}else{
			main_imgHeight=$(".main_img ul li img:last").height();
		}
		$(".main_img").height(main_imgHeight);
	}
	//打开窗口时触发
	window.onload=function(){
		main_img();
	};
	//改变浏览器分辨率时触发
	window.onresize=function(){
		main_img();
	};

	/*------------鼠标手指左右滑动切换图片------------*/
	//鼠标经过img_gallery时显示左右切换按钮
	$(".img_gallery").hover(function(){
		$("#btn_prev,#btn_next").fadeIn();
	},function(){
		$("#btn_prev,#btn_next").fadeOut();
	});

	$dragBln = false;

	$(".main_img").touchSlider({
		flexible : true,
		speed : 200,
		btn_prev : $("#btn_prev"),
		btn_next : $("#btn_next"),
		paging : $(".point a"),
		counter : function (e){
			$(".point a").removeClass("on").eq(e.current-1).addClass("on");//图片顺序点切换
            $("#main_imgCurrent").html(e.current);
		}
	});

	$(".main_img").bind("mousedown", function(){
		$dragBln = false;
	});

	$(".main_img").bind("dragstart", function(){
		$dragBln = true;
	});

	$(".main_img a").click(function(){
		if($dragBln){
			return false;
		}
	});

	//设置定时器timer，5秒钟就进行点击btn_next的效果
	timer = setInterval(function(){
		$("#btn_next").click();
	}, 5000);

	//鼠标经过img_gallery时清除timer，离开时执行timer
	$(".img_gallery").hover(function(){
		clearInterval(timer);
	},function(){
		timer = setInterval(function(){
			$("#btn_next").click();
		},5000);
	});

	//手指点击main_img时清除timer，离开时执行timer
	$(".main_img").bind("touchstart",function(){
		clearInterval(timer);
	}).bind("touchend", function(){
		timer = setInterval(function(){
			$("#btn_next").click();
		}, 5000);
	});

});