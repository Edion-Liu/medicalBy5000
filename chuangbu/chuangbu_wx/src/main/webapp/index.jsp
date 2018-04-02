<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>XXX医院</title>
    <link rel="stylesheet" href="./framework/weui/style/weui.css"/>
    <link rel="stylesheet" href="./../css/theme_default.css"/>
</head>
<body ontouchstart>
	<div class="container" id="container">
	<div class="page flex js_show" >
	
	        <div class="weui-flex head_bj">
	            <div class="weui-flex__item"><div class="placeholder">
					<img id="head_bj" src="./img/40b0be0.jpg" alt="">
				</div></div>
	        </div>
	        <div class="weui-flex menu_flex">
	            <div class="weui-flex__item"><div class="placeholder bg_1">
	            	<h4 class="title">医院概况</h4>
					<img src="./img/base/4752f64.png" alt="" >
				</div></div>
	            <div class="weui-flex__item"><div class="placeholder bg_2">
					<h4 class="title">医院名医</h4>
					<img src="./img/base/3b1a743.png" alt="" >
				</div></div>
	            <div class="weui-flex__item"><div class="placeholder bg_3">
					<h4 class="title">医院导航</h4>
					<img src="./img/base/7cb6c6b.png" alt="" >
				</div></div>
	        </div>
	        <div class="weui-flex menu_flex">
	            <div class="weui-flex__item"><div class="placeholder bg_4">
					<h4 class="title">科室信息</h4>
					<img src="./img/base/06fe43d.png" alt="" >
				</div></div>
	            <div class="weui-flex__item"><div class="placeholder bg_5">
					<h4 class="title">就诊须知</h4>
					<img src="./img/base/8e2d3d3.png" alt="" >
				</div></div>
	        </div>
	        <div class="weui-flex menu_flex">
	            <div class="weui-flex__item"><div class="placeholder bg_6">
	            	<h4 class="title">健康百科</h4>
					<img src="./img/base/a2377f1.png" alt="" >
				</div></div>
	            <div class="weui-flex__item"><div class="placeholder bg_7">
					<h4 class="title">预约挂号</h4>
					<img src="./img/base/b8cacb2.png" alt="" >
				</div></div>
	            <div class="weui-flex__item"><div class="placeholder bg_8">
					<h4 class="title">门诊缴费</h4>
					<img src="./img/base/4362a5b.png" alt="" >
				</div></div>
	        </div>
	        <div class="weui-flex menu_flex">
	            <div class="weui-flex__item"><div class="placeholder bg_1">
					<h4 class="title">个人中心</h4>
					<img src="./img/base/ba1eb5d.png" alt="" >
				</div></div>
	            <div class="weui-flex__item"><div class="placeholder bg_2">
					<h4 class="title">挂号记录</h4>
					<img src="./img/base/63122da.png" alt="" >
				</div></div>
	        </div>
	        <div class="weui-flex menu_flex">
	            <div class="weui-flex__item"><div class="placeholder bg_3">
	            	<h4 class="title">检查报告</h4>
					<img src="./img/base/c5b9c39.png" alt="" >
				</div></div>
	            <div class="weui-flex__item"><div class="placeholder bg_4">
					<h4 class="title">费用查询</h4>
					<img src="./img/base/27c9cea.png" alt="" >
				</div></div>
	            <div class="weui-flex__item"><div class="placeholder bg_5">
					<h4 class="title">体检中心</h4>
					<img src="./img/base/6570ea7.png" alt="" >
				</div></div>
	        </div>
	        <div class="weui-flex menu_flex">
	            <div class="weui-flex__item"><div class="placeholder bg_6">
					<h4 class="title">诊疗查询</h4>
					<img src="./img/base/00f0c25.png" alt="" >
				</div></div>
	            <div class="weui-flex__item"><div class="placeholder bg_7">
					<h4 class="title">药品查询</h4>
					<img src="./img/base/cf5b3fe.png" alt="" >
				</div></div>
	        </div>	        

	    	
            <div class="weui-footer">
                <p class="weui-footer__text">Copyright © 2016-2030 创步科技</p>
            </div>
		</div>
	</div>
    <script src="./framework/weui/js/weui.min.js"></script>
    
<script type="text/javascript">
    window.onload=function(){
      setInterval("setHeadBj()",1000*3);
      
	}
	var i = 1;
	var headbjs = ['40b0be0','f66ad28'];
	function setHeadBj(){
		if(i>=headbjs.length){
			i=0;
		}
		var headBj = document.getElementById("head_bj");
		headBj.src="./img/"+headbjs[i]+".jpg";
		i++;
	}
</script>

</body>
</html>
