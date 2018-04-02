<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ include file="./../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>门诊缴费</title>
 <style type="text/css">
.weui-btn {
	line-height: 1.5;
}
.pay-but{
	line-height: 2.5;
	font-size: 23px;
}
.mylabel {
	width: 70px;
}
</style>
</head>
<body ontouchstart>
	<div class="container" id="container">
		<div class="page__bd">

			<div class="weui-cells weui-cells_form">
				<div class="weui-cell">
					<div class="weui-cell__hd">
						<label class="weui-label mylabel">门诊号</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" type="text" pattern="[0-9]*"
							placeholder="请输入门诊号" />
					</div>
					<div class="weui-cell__ft">
						<a class="weui-btn weui-btn_plain-primary" href="javascript:"
							onClick="findData('OutpatientNo',this)">查询</a>
					</div>
				</div>
				<div class="weui-cell">
					<div class="weui-cell__hd">
						<label class="weui-label mylabel">身份证</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" type="text" pattern="[0-9]*"
							placeholder="请输入身份证号" />
					</div>
					<div class="weui-cell__ft">
						<a class="weui-btn weui-btn_plain-primary" href="javascript:"
							onClick="findData('CertificateNo',this)">查询</a>
					</div>
				</div>
			</div>
			<div class="weui-form-preview">
	            <div class="weui-form-preview__hd">
	                <div class="weui-form-preview__item">
	                    <label class="weui-form-preview__label">基本信息</label>
	                </div>
	            </div>
	            <div class="weui-form-preview__bd" id="ResQueryBill">
	                <div class="weui-form-preview__item" style="display: none;">
	                    <label class="weui-form-preview__label">门诊号</label>
	                    <span class="weui-form-preview__value" id="OutpatientNo"></span>
	                </div>
	                <div class="weui-form-preview__item" style="display: none;">
	                    <label class="weui-form-preview__label">流水号</label>
	                    <span class="weui-form-preview__value" id="SerialNo"></span>
	                </div>
	                <div class="weui-form-preview__item" style="display: none;">
	                    <label class="weui-form-preview__label">姓名</label>
	                    <span class="weui-form-preview__value" id="CustomerName"></span>
	                </div>
	                <div class="weui-form-preview__item" style="display: none;">
	                    <label class="weui-form-preview__label">科室名称</label>
	                    <span class="weui-form-preview__value" id="DeptName"></span>
	                </div>
	                <div class="weui-form-preview__item" style="display: none;">
	                    <label class="weui-form-preview__label">医生名称</label>
	                    <span class="weui-form-preview__value" id="DoctorName"></span>
	                </div>
	            </div>
	            
	         </div>
	         <input type="hidden" id="PrescNoAll" value="">
	         <div class="weui-form-preview">
	            <div class="weui-form-preview__hd">
	                <div class="weui-form-preview__item">
	                    <label class="weui-form-preview__label">门诊挂号信息</label>
	                    <em class="weui-form-preview__value" id="totalMoney">¥0</em>
	                </div>
	            </div>
	            <div class="weui-form-preview__bd" id="ResQueryPrescInfo">
	                
	            </div>
       		</div>
        	
        	<div class="weui-form-preview">
	            <div class="weui-form-preview__hd">
	                <div class="weui-form-preview__item">
	                    <label class="weui-form-preview__label">门诊挂号详情</label>
	                </div>
	            </div>
	        </div>
			<table id="PrescDetailInfoTable" class="table table-striped ">
				<thead>
					<tr >
						<th>
							药品名称
						</th>
						<th>
							单位/单价/数量
						</th>
						<th>
							金额
						</th>						
					</tr>
				</thead>
				<tbody >
					<tr>
						<td colspan="3" style="text-align: center;">
							暂无数据
						</td>
					</tr>
				</tbody>
			</table>
			
			

			<div class="weui-btn-area">
				<a class="weui-btn weui-btn_primary pay-but"  href="javascript:"
					id="showPayDialog">支付</a>
			</div>

			<div id="dialogs">
				<!--BEGIN dialog2-->
				<div class="js_dialog" id="payDialog" style="display: none;">
					<div class="weui-mask"></div>
					<div class="weui-dialog">
						<div class="weui-dialog__bd">
							<div class="weui-loadmore">
					            <i class="weui-loading"></i>
					            <span class="weui-loadmore__tips">订单正在生成中，请稍候...</span>
					        </div>
						</div>
					</div>
					<div class="weui-dialog__ft">
                </div>
				</div>
			</div>

		</div>
	</div>
	<script
	<script
	<script src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js">
		
	</script>
	<script src="<%=request.getContextPath()%>/js/app/common/wxopenid.js"></script>
	<script src="<%=request.getContextPath()%>/js/common.js"></script>
	<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>

	<script type="text/javascript">
		var $payDialog = $('#payDialog');
		$(function() {

			$('#showPayDialog').on('click', function() {
				if(!$(this).hasClass("weui-btn_disabled")){
					
					var OutpatientNo = $("#OutpatientNo").text();
					var SerialNo = $("#SerialNo").text();
					var CustomerName = $("#CustomerName").text();
					var DoctorName = $("#DoctorName").text();
					var DeptName = $("#DeptName").text();
					var totalMoney = $("#totalMoney").text();
					var totalMoney = totalMoney.substring(1,totalMoney.length);
					var prescNoAll = $("#PrescNoAll").val();
					
					if(isStrNULL(OutpatientNo) ){
						alert("门诊号不能为空！");
						return ;
					}else{
						$(this).addClass("weui-btn_disabled");
						$payDialog.fadeIn(200);
						pay(OutpatientNo, null,totalMoney,prescNoAll,SerialNo,CustomerName,DoctorName,DeptName);
					}
				}
			});
			
		});

		function findData(type,eve) {
			var val = $(eve).parent().prev().children(":first").val();
			outpatient_no = type=='OutpatientNo'? val : null;
			certificate_no = type=='CertificateNo'? val : null;
			
			$("#totalMoney").text('¥0');
			$("#PrescNoAll").val("");
			$("#ResQueryBill").children().hide();
			$("#ResQueryBill").children().find("span").text("");
			var $prescInfo = $("#ResQueryPrescInfo");
			$prescInfo.empty();
			var $prescDetailInfoTable = $("#PrescDetailInfoTable");
			$prescDetailInfoTable.find('tbody').empty();
							
			if (val != null && val.length > 0) {
				$.ajax({
					type : "GET",
					url : "${basepath}/ajax/common/outpatient/mzsfService/query",
					data : {
						OutpatientNo : outpatient_no,
						CertificateNo : certificate_no
					},
					dataType : "json",
					success : function(json) {
						if (json.status == 'ok'){
							var data = JSON.parse(json.data);
							var body = data.Body;
							//门诊基本信息
							var resQueryBill = body.ResQueryBill;
							if(resQueryBill != null){
								if(!isStrNULL(resQueryBill.OutpatientNo)){
									$("#OutpatientNo").parent().show();
									$("#OutpatientNo").text(resQueryBill.OutpatientNo);
								}
								if(!isStrNULL(resQueryBill.SerialNo)){
									$("#SerialNo").parent().show();
									$("#SerialNo").text(resQueryBill.SerialNo);
								}
								if(!isStrNULL(resQueryBill.CustomerName)){
									$("#CustomerName").parent().show();
									$("#CustomerName").text(resQueryBill.CustomerName);
								}
								if(!isStrNULL(resQueryBill.DoctorName)){
									$("#DoctorName").parent().show();
									$("#DoctorName").text(resQueryBill.DoctorName);
								}
								if(!isStrNULL(resQueryBill.DeptName)){
									$("#DeptName").parent().show();
									$("#DeptName").text(resQueryBill.DeptName);
								}
							}
							//门诊挂号信息
							var resQueryPrescInfo = body.ResQueryPrescInfo;
							
							if(resQueryPrescInfo != null){
								var total = 0;
								var PrescNoAll = "";
								if(resQueryPrescInfo.length>0){
			            			for(var i =0 ; i < resQueryPrescInfo.length ; i++){
			            				var money = resQueryPrescInfo[i].Money;
			            				total += parseInt(money);
			            				var html = '<div class="weui-form-preview__item" ><label class="weui-form-preview__label">'+resQueryPrescInfo[i].PrescName+'</label><span class="weui-form-preview__value">¥'+fomatFloat(money/100,2)+'</span></div>';
			                			$prescInfo.append(html);
			                			PrescNoAll = PrescNoAll.length==0 ? resQueryPrescInfo[i].PrescNo : PrescNoAll+'_'+resQueryPrescInfo[i].PrescNo;
			                		}
		                		}else{
		                			var money = resQueryPrescInfo.Money;
		            				total += parseInt(money);
		            				var html = '<div class="weui-form-preview__item" ><label class="weui-form-preview__label">'+resQueryPrescInfo.PrescName+'</label><span class="weui-form-preview__value">¥'+fomatFloat(money/100,2)+'</span></div>';
		                			$prescInfo.append(html);
		                			PrescNoAll = PrescNoAll.length==0 ? resQueryPrescInfo.PrescNo : PrescNoAll+'_'+resQueryPrescInfo.PrescNo;
		                		}
		                		$("#totalMoney").text('¥'+fomatFloat(total/100,2));
		                		$("#PrescNoAll").val(PrescNoAll);
		            		}else{
		            			$prescInfo.append('<div class="weui-form-preview__item" ><label class="weui-form-preview__label">无信息</label><span class="weui-form-preview__value"></span></div>');
		            		}
		            		
		            		//门诊挂号详情
		            		var detailInfo = body.ResQueryPrescDetailInfo;
							if(detailInfo != null){
								if(detailInfo.length>0){
			            			for(var i =0 ; i < detailInfo.length ; i++){
			            				var amount = detailInfo[i].Amount;
			            				var money = detailInfo[i].Money;
			            				$prescDetailInfoTable.find('tbody').append('<tr><td>'+detailInfo[i].PrescDetailName+'</td><td>'+detailInfo[i].Norm+'/'+fomatFloat(detailInfo[i].Price/100,4)+'/'+amount+'</td><td>'+fomatFloat(money/100,2)+'</td></tr>');
			                		}
			                	}else{
			                		var amount = detailInfo.Amount;
		            				var money = detailInfo.Money;
		            				$prescDetailInfoTable.find('tbody').append('<tr><td>'+detailInfo.PrescDetailName+'</td><td>'+detailInfo.Norm+'/'+fomatFloat(detailInfo.Price/100,4)+'/'+amount+'</td><td>'+fomatFloat(money/100,2)+'</td></tr>');
			                	}
		            		}else{
		            			$prescDetailInfoTable.find('tbody').append('<tr><td colspan="3" style="text-align: center;">暂无数据</td></tr>');
		            		}
		            		
						}
					}
				});
			}
		}

		wx.config({
			debug : false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。  
			appId : '${appId}', // 必填，公众号的唯一标识  
			timestamp : '${ timestamp}', // 必填，生成签名的时间戳  
			nonceStr : '${ nonceStr}', // 必填，生成签名的随机串  
			signature : '${ signature}',// 必填，签名，见附录1  
			jsApiList : [ 'chooseWXPay', 'scanQRCode' ]
		// 必填，需要使用的JS接口列表，所有JS接口列表见附录2
		});

		wx.ready(function() {

		});

		wx.error(function(res) {
			alert("调用微信jsapi返回的状态:" + res.errMsg);
		});

		function pay(outpatient_no, certificate_no,total_money,presc_no_all,serial_no,customer_name,doctor_name,dept_name) {
			var orderData = {
					OutpatientNo : outpatient_no,
					CertificateNo : certificate_no,
					charge : total_money,
					prescNoAll : presc_no_all,
					SerialNo : serial_no,
					CustomerName : customer_name,
					DoctorName : doctor_name,
					DeptName : dept_name,
					spBillCreateIP : returnCitySN["cip"],
					openId : getOpenId('${appId}','${basepath}'),
					timestamp : '${ timestamp}', // 必填，生成签名的时间戳  
					nonceStr : '${ nonceStr}' // 必填，生成签名的随机串  
				};
			var orderUrl = "${basepath}/view/pay/wxJsAPI/outpatientCreatOrder";
			$.ajax({
				type : "GET",
				url : orderUrl,
				data : orderData,
				dataType : "json",
				success : function(json) {
					if (json.status == 'ok') {
						wx.chooseWXPay({
							appId : '${appId}', // 必填，公众号的唯一标识 
							timestamp : '${ timestamp}', // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
							nonceStr : '${ nonceStr}', // 支付签名随机串，不长于 32 位
							package : json.prepayId, // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
							signType : 'MD5', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
							paySign : json.paysignature, // 支付签名
							success : function(res) {
								$payDialog.fadeOut(200);
								// 支付成功后的回调函数
								var url = '${basepath}/view/pay/wxJsAPI/outpatientSeccess?outTradeNo='+json.outTradeNo;
								location.href = url;
							}
						});
					}else{
						alert(json.msg);
						$payDialog.fadeOut(200);
					}
				}
			});
		}

	</script>

</body>
</html>
