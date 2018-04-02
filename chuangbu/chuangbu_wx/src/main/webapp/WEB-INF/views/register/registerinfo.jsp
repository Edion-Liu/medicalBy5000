<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ include file="./../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>本院祝您早日康复！</title>
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


			<div class="weui-cells__title">请完善红框信息</div>
			<div class="weui-cells weui-cells_form">
				<div class="weui-cell">
					<div class="weui-cell__hd">
						<label class="weui-label mylabel">诊疗卡</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" type="text" pattern="[0-9]*"
							placeholder="请输入诊疗卡号" />
					</div>
					<div class="weui-cell__ft">
						<a class="weui-btn weui-btn_plain-primary" href="javascript:"
							onClick="findPerData(this)">查询</a>
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
							onClick="findPerData(this)">查询</a>
					</div>
				</div>
			</div>
			<div class="weui-cells__title">患者信息</div>
			<div class="weui-cells weui-cells_form">
				<div class="weui-cell">
					<div class="weui-cell__hd">
						<label class="weui-label">就诊卡号</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" type="text" name="CardID"
							placeholder="就诊卡号">
					</div>
					<div class="weui-cell__ft"></div>
				</div>
				<div class="weui-cell weui-cell_warn">
					<div class="weui-cell__hd">
						<label class="weui-label">身份证号</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" type="text" name="CertificateNo" id="CertificateNo"
							placeholder="身份证号">
					</div>
					<div class="weui-cell__ft">
					</div>
				</div>
				<div class="weui-cell weui-cell_warn">
					<div class="weui-cell__hd">
						<label class="weui-label">姓名</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" type="text" name="personName"
							placeholder="请输入姓名">
					</div>
					<div class="weui-cell__ft"></div>
				</div>
				<div
					class="weui-cell weui-cell_select weui-cell_select-after weui-cell_warn">
					<div class="weui-cell__hd">
						<label class="weui-label">性别</label>
					</div>
					<div class="weui-cell__bd">
						<select class="weui-select" id="personSex">
							<option value="0">男</option>
							<option value="1">女</option>
						</select>
					</div>
				</div>
				<div class="weui-cell weui-cell_warn">
					<div class="weui-cell__hd">
						<label class="weui-label">年龄</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" type="text" name="age"
							pattern="[0-9]{0,3}" placeholder="请输入年龄" />
					</div>
				</div>
				<div class="weui-cell weui-cell_warn">
					<div class="weui-cell__hd">
						<label for="" class="weui-label">出生日期</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" type="date" name='personCSRQ' value="" />
					</div>
				</div>
				<div class="weui-cell weui-cell_warn">
					<div class="weui-cell__hd">
						<label class="weui-label">病人电话</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" name="PhoneCode" type="tel"
							placeholder="请输入电话号">
					</div>
				</div>
				<div class="weui-cell ">
					<div class="weui-cell__hd">
						<label class="weui-label">家属电话</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" name="PhoneCodeContact" type="tel"
							placeholder="请输入电话号">
					</div>
				</div>
			</div>
			<div class="weui-cells__title">挂号信息</div>
			<div class="weui-cells weui-cells_form">
				<div class="weui-cell ">
					<div class="weui-cell__hd">
						<label class="weui-label">就诊科室</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" type="doctorCode" value="${deptName}"
							disabled="true">
					</div>
					<div class="weui-cell__ft"></div>
				</div>
				<div class="weui-cell ">
					<div class="weui-cell__hd">
						<label class="weui-label">就诊医生</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" type="text" value="${doctorName}"
							disabled="true">
					</div>
					<div class="weui-cell__ft"></div>
				</div>
				<div class="weui-cell ">
					<div class="weui-cell__hd">
						<label class="weui-label">科室位置</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" type="text" value="门诊三楼西侧"
							disabled="true">
					</div>
				</div>
				<div class="weui-cell ">
					<div class="weui-cell__hd">
						<label class="weui-label">本次支付</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" type="text" pattern="[0-9]*"
							value="${charge}元" disabled="true">
					</div>
				</div>
			</div>

			<!-- <label for="weuiAgree" class="weui-agree"> <input
				id="weuiAgree" type="checkbox" class="weui-agree__checkbox">
				<span class="weui-agree__text"> 阅读并同意<a
					href="javascript:void(0);">《相关条款》</a>
			</span>
			</label> -->

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

			getOpenIdDayRegisterCount();
			
			$('#showPayDialog').on('click', function() {
				if(count < 20){
					if(!$(this).hasClass("weui-btn_disabled")){
						
						var CardID = $("input[name='CardID']").val();
						var personName = $("input[name='personName']").val();
						var personSex = $("#personSex").find("option:selected").text();
						var personCSRQ = $("input[name='personCSRQ']").val();
						var CertificateNo = $("input[name='CertificateNo']").val();
						var PhoneCode = $("input[name='PhoneCode']").val();
						var PhoneCodeContact = $("input[name='PhoneCodeContact']").val();
						if(isStrNULL(personName)  || isStrNULL(personSex) || 
								isStrNULL(personCSRQ) || isStrNULL(CertificateNo) ||
								isStrNULL(PhoneCode)){
							alert("标红字段不能为空！");
							return ;
						}else{
							$(this).addClass("weui-btn_disabled");
							$payDialog.fadeIn(200);
							pay(CardID,personName,personSex,personCSRQ,CertificateNo,
									PhoneCode,PhoneCodeContact);
						}
					}
				}else{
					alert("用户今日挂号已经超过限制，请明天再次挂号");
				}
			});
			
			$("#CertificateNo").change(function(){
				getPersonIdData($(this).val());
			});

		});

		function findPerData(eve) {
			var card_no = $(eve).parent().prev().children(":first").val();
			if (card_no != null && card_no.length > 0) {
				$.ajax({
					type : "GET",
					url : "${basepath}/ajax/common/register/mzghService/per",
					data : {
						cardNo : card_no
					},
					dataType : "json",
					success : function(json) {
						if (json.status == 'ok'){
							$("input[name='CardID']").val(card_no);
							var data = JSON.parse(json.data);
							var body = data.Body;
							$("input[name='personName']").val(body.PatientName);
							$("#personSex").val(body.Sex == '女' ? '1' : '0');
	
							var myDate = new Date();
							var cDate = myDate.getFullYear(); //获取完整的年份(4位,1970-????) 
	
							var csrq = body.Birthday;
							csrq_str = csrq.substr(0, 4);
							var age = parseInt(cDate) - parseInt(csrq_str);
							$("input[name='age']").val(age);
							var personCSRQ = csrq.substr(0, csrq.indexOf(" "));
							$("input[name='personCSRQ']").val(personCSRQ.replace(/\//g, "-"));
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

		function pay(CardID,personName,personSex,personCSRQ,CertificateNo,
				PhoneCode,PhoneCodeContact) {
			
			var orderData = {
					CardID : CardID,
					CustomerName : personName,
					Sex : personSex,
					Birthday : personCSRQ,
					CertificateNo : CertificateNo,
					PhoneCode : PhoneCode,
					PhoneCodeContact : PhoneCodeContact,
					deptCode : '${deptCode}',
					deptName : '${deptName}',
					doctorCode : '${doctorCode}',
					doctorName : '${doctorName}',
					charge : '${charge}',
					spBillCreateIP : returnCitySN["cip"],
					openId : getOpenId('${appId}','${basepath}') ,
					timestamp : '${ timestamp}', // 必填，生成签名的时间戳  
					nonceStr : '${ nonceStr}' // 必填，生成签名的随机串  
				};
			var orderUrl = "${basepath}/view/pay/wxJsAPI/registerCreatOrder";
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
								var url = '${basepath}/view/pay/wxJsAPI/registerSeccess?outTradeNo='+json.outTradeNo;
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

		function getPersonIdData(cardId) {
			 if(!/^\d{6}((?:19|20)((?:\d{2}(?:0[13578]|1[02])(?:0[1-9]|[12]\d|3[01]))|(?:\d{2}(?:0[13456789]|1[012])(?:0[1-9]|[12]\d|30))|(?:\d{2}02(?:0[1-9]|1\d|2[0-8]))|(?:(?:0[48]|[2468][048]|[13579][26])0229)))\d{2}(\d)[xX\d]$/.test(cardId)){  
			      alert('身份证号非法.');  
			      return;  
			 }
			 var csrq = (cardId).substr(6,4)+'-'+(cardId).substr(10,2)+'-'+(cardId).substr(12,2);
			 $("input[name='personCSRQ']").val(csrq);
			 var sex = parseInt(cardId.substr(16,1))% 2 == 1?'男':'女';
			 $("#personSex").val(sex == '女' ? '1' : '0');
			 
			//获取年龄 
			 var myDate = new Date(); 
			 var month = myDate.getMonth() + 1; 
			 var day = myDate.getDate(); 
			 var age = myDate.getFullYear() - cardId.substring(6, 10) - 1; 
			 if (cardId.substring(10, 12) < month || cardId.substring(10, 12) == month && cardId.substring(12, 14) <= day) { 
			 	age++; 
			 }
			 $("input[name='age']").val(age);
		}
		
		var count = 0 ;
		function getOpenIdDayRegisterCount(){
			$.ajax({
	            type: "GET",
	            url: "${basepath}/ajax/pay/tencent/getOpenIdDayRegisterCount",
	            data: {openId:getOpenId('${appId}','${basepath}') },
	            dataType: "json",
	            success: function(json){
	            	if(json.status =='ok'){
	            		var data =  JSON.parse(json.data);
	            		count = data.count;
	            	}
	            }
			})
		}

	</script>

</body>
</html>
