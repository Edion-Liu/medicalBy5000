<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>本院祝您早日康复</title>
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
		<div class="page__bd">
			
			<div class="weui-cells weui-cells_form">
				<div class="weui-cell weui-cell_warn">
					<div class="weui-cell__bd">
						<H2>支付成功</H2>
					</div>
				</div>
				<div class="weui-cell ">
					<div class="weui-cell__hd">
					</div>
					<div class="weui-cell__bd" style="text-align:center;">
						<img id="barcode1"/>
					</div>
					<div class="weui-cell__ft"></div>
				</div>
				<div class="weui-cell ">
					<div class="weui-cell__hd">
						<label class="weui-label">门诊号</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" type="text" id="OutpatientNo"
							placeholder="门诊号">
					</div>
					<div class="weui-cell__ft"></div>
				</div>
				<div class="weui-cell ">
					<div class="weui-cell__hd">
						<label class="weui-label">流水号</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" type="text" id="SerialNo"
							placeholder="流水号">
					</div>
					<div class="weui-cell__ft"></div>
				</div>
				
				<div class="weui-cell">
					<div class="weui-cell__bd">
						<label id="orderInfo">
							
						</label>
					</div>
				</div>
				
			</div>

		</div>
	</div>
    
    <script src="<%=request.getContextPath() %>/framework/JsBarcode/JsBarcode.all.js"></script>
    
<script type="text/javascript">

	$(function(){
		var orderInfo = JSON.parse('${orderInfo}');
		if(!isStrNULL(orderInfo.outpatientNo) ){
			JsBarcode("#barcode1", orderInfo.outpatientNo,
					{ 
				width: 2,//较细处条形码的宽度
				height: 80, //条形码的宽度，无高度直接设置项，由位数决定，可以通过CSS去调整，见下
				format: "CODE128",
				//displayValue: true,//是否在条形码下方显示文字
				//text:"门诊号",//覆盖显示的文本
				font:"monospace", 
				textAlign:"center", 
				fontSize: 12,
				backgroundColor:"", 
				margin:0//设置条形码周围的空白边距
				});
		}
		
		$("#OutpatientNo").val(orderInfo.outpatientNo);
		$("#SerialNo").val(orderInfo.serialNo);
		
		var htmlstr = "患者<font color=\"red\">"+orderInfo.customerName+"</font> 在科室<font color=\"red\"> "+orderInfo.deptName+"</font> 医生 <font color=\"red\"> "+orderInfo.doctorName+"</font> 门诊缴费成功！<br>";
		$("#orderInfo").append(htmlstr);
		
	});
	
	
</script>

</body>
</html>
