<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;}
		#golist {display: none;}
		@media (max-device-width: 780px){#golist{display: block !important;}}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?ak=V8hIVogqKEv3bibNQUFSsPW0&v=2.0"></script>
	<title>院内导航</title>
	<link rel="stylesheet" href="./../../framework/weui/style/weui.css"/>
    <link rel="stylesheet" href="./../../css/theme_default.css"/>
</head>
<body>
	 <div class="head_back">
	 	<span class="back" onclick="history.go(-1)">返回</span>
	 	院内导航
	 	<span class="refresh" onclick="location.reload()">刷新</span>
	 </div>
	<div id="allmap"></div>
	<%@include file="./../inc/tabbar.jsp"%>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");            // 创建Map实例
	var point = new BMap.Point(122.380902, 42.955728); // 创建点坐标
	map.centerAndZoom(point,15);                 // 初始化地图,设置中心点坐标和地图级别。

	map.enableScrollWheelZoom(true);
	var marker = new BMap.Marker(point);  //创建标注
	map.addOverlay(marker);    // 将标注添加到地图中
	var opts = {
		width : 200,    // 信息窗口宽度
		height: 80,     // 信息窗口高度
		title : "科左后旗人民医院", // 信息窗口标题
		enableAutoPan : true //自动平移
	}
	var infoWindow = new BMap.InfoWindow("地址：科尔沁左翼后旗甘旗卡镇大青沟街铁东段", opts);  // 创建信息窗口对象
	marker.addEventListener("click", function(e){          
		map.openInfoWindow(infoWindow,point); //开启信息窗口
	});
</script>
