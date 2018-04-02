<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../commons/taglibs.jsp"%>
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
	<title>来院导航</title>
</head>
<body>
	<div id="allmap"></div>
<script type="text/javascript" src="http://api.map.baidu.com/api?ak=V8hIVogqKEv3bibNQUFSsPW0&v=2.0"></script>
<script type="text/javascript">
	var appconf = JSON.parse('${appConf}');
	// 百度地图API功能
	var map = new BMap.Map("allmap");            // 创建Map实例
	var point = new BMap.Point(appconf.longitude, appconf.latitude); // 创建点坐标
	map.centerAndZoom(point,15);                 // 初始化地图,设置中心点坐标和地图级别。

	
	var content = '<div style="margin:0;line-height:20px;padding:0px;">' +
    '地址：'+appconf.address+'<br>' +
    '<a href="javascript:;" style="margin-top:5px;" class="weui-btn weui-btn_mini weui-btn_primary" onClick="openUrl(\'${basepath}\',\'/navigation/navigation_in\')">进入院内</a>'+
  '</div>';
  
	map.enableScrollWheelZoom(true);
	var marker = new BMap.Marker(point);  //创建标注
	map.addOverlay(marker);    // 将标注添加到地图中
	var opts = {
		width : 200,    // 信息窗口宽度
		height: 100,     // 信息窗口高度
		title : appconf.name, // 信息窗口标题
		enableAutoPan : true //自动平移
	}
	var infoWindow = new BMap.InfoWindow(content, opts);  // 创建信息窗口对象
	marker.addEventListener("click", function(e){          
		map.openInfoWindow(infoWindow,point); //开启信息窗口
	});
	
</script>

</body>
</html>