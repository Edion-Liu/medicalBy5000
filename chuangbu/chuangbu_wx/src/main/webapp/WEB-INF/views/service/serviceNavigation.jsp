<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>为您服务</title>
</head>
<body ontouchstart>
	<div class="container" id="container">
		<div class="page  js_show" >
			 <div class="weui-cells">
	            <div class="weui-cell weui-cell_access" onClick="openUrl('${basepath}','/view/common/navigation','02')">
	                <div class="weui-cell__hd" style="position: relative;margin-right: 10px;">
	                    <img src="./../../myres/img/base/navigation_net.png" style="width: 50px;display: block"/>
	                </div>
	                <div class="weui-cell__bd">
	                    <p>来院导航</p>
	                    <p style="font-size: 13px;color: #888888;">医院位置</p>
	                </div>
	                <div class="weui-cell__ft"></div>
	            </div>
	            <div class="weui-cell weui-cell_access" onClick="openUrl('${basepath}','/healthylift/healthylift_${appId}','01')">
	                <div class="weui-cell__hd" style="position: relative;margin-right: 10px;">
	                    <img src="./../../myres/img/base/healthylift_info.png" style="width: 50px;display: block"/>
	                </div>
	                <div class="weui-cell__bd">
	                    <p>绿色生活</p>
	                    <p style="font-size: 13px;color: #888888;">绿色生活</p>
	                </div>
	                <div class="weui-cell__ft"></div>
	            
	        </div>
	                
	        </article>
	    	
		</div>
	</div>
    

</body>
</html>
