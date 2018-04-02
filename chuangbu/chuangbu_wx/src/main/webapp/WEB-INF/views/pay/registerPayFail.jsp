<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>支付失败</title>
    <style type="text/css">
    .weui-btn{
    	line-height: 1.5;
    }
    .mylabel{
    	width: 70px;
    }
    </style>
</head>
<body ontouchstart>
	 <div class="container" id="container">
		<div class="page__bd" >
	         <div class="weui-btn-area">
	            <a class="weui-btn weui-btn_primary" href="javascript:" id="showTooltips" onclick="history.go(-2)">返回支付</a>
	        </div>
	    </div>
	</div>
    
    <script src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js"> </script>
    
<script type="text/javascript">

	$(function(){
		$("#weuiAgree").click(function(){
// 			  alert($("#weuiAgree:checked"));
		});
	});
	
	
	   
	function back(){
		var url = '/view/common/L3JlZ2lzdGVyL3JlZ2lzdGVy';
		location.href = url;
	}
	
</script>

</body>
</html>
