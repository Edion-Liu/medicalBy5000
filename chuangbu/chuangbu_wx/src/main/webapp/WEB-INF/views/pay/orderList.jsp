<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>成功挂号记录</title>
    <style type="text/css">
    .page__bd,.container{
    	background-color:#EAEAEB;
    }
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
		<div class="page js_show" >
	        
			<div class="page__bd">
		         <div class="weui-form-preview">
		           
		        </div>
		    </div>
			
			<div class="weui-footer">
                <p class="weui-footer__text">
            </div>
		</div>
	</div>
    <script src="<%=request.getContextPath() %>/js/common.js"></script>
    <script src="<%=request.getContextPath() %>/js/app/common/wxopenid.js"></script>
    
<script type="text/javascript">

	$(function(){

		getOrderData();
	});
	
	function getOrderData() {
		$.ajax({
			type : "GET",
			url : "${basepath}/ajax/pay/tencent/getOrderData",
			data : {
				openId : getOpenId('${appId}','${basepath}') 
			},
			dataType : "json",
			success : function(json) {
				if (json.status == 'ok'){
					var data = JSON.parse(json.data);
					var html ="";
					for(var n in data){
						var fee = data[n].totalFee;
						fee = Number(fee)/100;
						html += '<div class="weui-form-preview"> <div class="weui-form-preview__bd">'+
						'	<div class="weui-form-preview__item">'+
						'		<label class="weui-form-preview__label">挂号信息</label>'+
						'		<span class="weui-form-preview__value">'+data[n].body+'</span>'+
						'	</div>'+
						'	<div class="weui-form-preview__item">'+
						'		<label class="weui-form-preview__label">支付金额</label>'+
						'		<span class="weui-form-preview__value">￥'+fee+'</span>'+
						'	</div>'+
						'	<div class="weui-form-preview__item">'+
						'		<label class="weui-form-preview__label">就诊日期</label>'+
						'		<span class="weui-form-preview__value">'+data[n].visitDate+'</span>'+
						'	</div>'+
						'	<div class="weui-form-preview__item">'+
						'		<label class="weui-form-preview__label">就诊序号</label>'+
						'		<span class="weui-form-preview__value">'+data[n].indexNo+'</span>'+
						'	</div>'+
						'</div>'+
						'<div class="weui-form-preview__ft">'+
						'	<a class="weui-form-preview__btn weui-form-preview__btn_primary" href="${basepath}/view/pay/wxJsAPI/registerSeccess?outTradeNo='+data[n].outTradeNo+'">查看详情</a>'+
						'</div></div><br>'; 
					}
// 					$(".weui-form-preview").append(html);
					$(".page__bd").append(html);
				}
			}
		});
}
</script>

</body>
</html>
