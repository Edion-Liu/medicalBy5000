<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>院内办公</title>
</head>

<body ontouchstart>
	<div class="container" id="container">
		<div class="page flex js_show" >
			<div class="weui-grids">
		        <a href="javascript:;" class="weui-grid" onClick="openReprot()">
		            <div class="weui-grid__icon">
		                <img src="./../../myres/img/office/reprot.png" alt="">
		            </div>
		            <p class="weui-grid__label">今日动态</p>
		        </a>
		        <a href="javascript:;" class="weui-grid" onClick="openFollowUp()">
		            <div class="weui-grid__icon">
		                <img src="./../../myres/img/office/reprot.png" alt="">
		            </div>
		            <p class="weui-grid__label">随访系统</p>
		        </a>
		        <a href="javascript:;" class="weui-grid">
		            <div class="weui-grid__icon">
		                <img src="./../../myres/img/office/reprot.png" alt="">
		            </div>
		            <p class="weui-grid__label">转诊系统</p>
		        </a>
	        
	    	</div>
		</div>
	</div>
    
<script type="text/javascript">

	$(document).ready(function() {
		
	});
	
	function openReprot(){
		 location.href = '${basepath}/view/office/report';
	}
	function openFollowUp(){
		 location.href = '${basepath}/view/office/followup';
	}
		
</script>

</body>
</html>
