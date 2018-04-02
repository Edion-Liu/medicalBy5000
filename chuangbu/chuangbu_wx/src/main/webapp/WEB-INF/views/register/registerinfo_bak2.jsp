<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>当日挂号详情</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/framework/weui/style/weui.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/theme_default.css"/>
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
	<div class="head_back">
	 	<span class="back" onclick="history.go(-1)">返回</span>
	 	旗医院祝您早日康复！
	 	<span class="refresh" onclick="location.reload()">刷新</span>
	 </div>
	<div class="container" id="container">
		<div class="page__bd" >
	        
			
			<div class="weui-cells__title">请完善红框信息</div>
	        <div class="weui-cells weui-cells_form">
	            <div class="weui-cell">
	                <div class="weui-cell__hd"><label class="weui-label mylabel">诊疗卡</label></div>
	                <div class="weui-cell__bd">
	                    <input class="weui-input" type="text" pattern="[0-9]*" placeholder="请输入诊疗卡号"/>
	                </div>
	                <div class="weui-cell__ft">
	                    <a class="weui-btn weui-btn_plain-primary" href="javascript:" onClick="findPerData(this)">查询</a>
	                </div>
	            </div>
	            <div class="weui-cell">
	                <div class="weui-cell__hd"><label class="weui-label mylabel">身份证</label></div>
	                <div class="weui-cell__bd">
	                    <input class="weui-input" type="text" pattern="[0-9]*" placeholder="请输入身份证号"/>
	                </div>
	                <div class="weui-cell__ft">
	                    <a class="weui-btn weui-btn_plain-primary" href="javascript:" onClick="findPerData(this)">查询</a>
	                </div>
	            </div>
	        </div>
			<div class="weui-cells__title">患者信息</div>
	        <div class="weui-cells weui-cells_form">
	            <div class="weui-cell weui-cell_warn">
	                <div class="weui-cell__hd">
	                    <label class="weui-label">就诊卡号</label>
	                </div>
	                <div class="weui-cell__bd">
	                    <input class="weui-input" type="text" name="CardID" placeholder="就诊卡号">
	                </div>
	                <div class="weui-cell__ft">
	                    
	                </div>
	            </div>
	            <div class="weui-cell weui-cell_warn">
	                <div class="weui-cell__hd">
	                    <label class="weui-label">身份证号</label>
	                </div>
	                <div class="weui-cell__bd">
	                    <input class="weui-input" type="text" name="CertificateNo" placeholder="身份证号">
	                </div>
	                <div class="weui-cell__ft">
	                    
	                </div>
	            </div>
	            <div class="weui-cell weui-cell_warn">
	                <div class="weui-cell__hd">
	                    <label class="weui-label">姓名</label>
	                </div>
	                <div class="weui-cell__bd">
	                    <input class="weui-input" type="text" name="personName" placeholder="请输入姓名">
	                </div>
	                <div class="weui-cell__ft">
	                    
	                </div>
	            </div>
	            <div class="weui-cell weui-cell_select weui-cell_select-after weui-cell_warn">
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
	                    <input class="weui-input" type="text" name="age" pattern="[0-9]{0,3}" placeholder="请输入年龄"/>
	                </div>
	            </div>
	            <div class="weui-cell weui-cell_warn">
	                <div class="weui-cell__hd"><label for="" class="weui-label">出生日期</label></div>
	                <div class="weui-cell__bd">
	                    <input class="weui-input" type="date" name='personCSRQ' value=""/>
	                </div>
	            </div>
	            <div class="weui-cell weui-cell_warn">
	                <div class="weui-cell__hd">
	                    <label class="weui-label">病人电话</label>
	                </div>
	                <div class="weui-cell__bd">
	                    <input class="weui-input" name="PhoneCode" type="tel" placeholder="请输入电话号">
	                </div>
	            </div>
	            <div class="weui-cell ">
	                <div class="weui-cell__hd">
	                    <label class="weui-label">家属电话</label>
	                </div>
	                <div class="weui-cell__bd">
	                    <input class="weui-input" name="PhoneCodeContact" type="tel" placeholder="请输入电话号">
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
	                    <input class="weui-input" type="doctorCode" value="${deptName}" disabled="true">
	                </div>
	                <div class="weui-cell__ft">
	                    
	                </div>
	            </div>
	            <div class="weui-cell ">
	                <div class="weui-cell__hd">
	                    <label class="weui-label">就诊医生</label>
	                </div>
	                <div class="weui-cell__bd">
	                    <input class="weui-input" type="text" value="${doctorName}" disabled="true">
	                </div>
	                <div class="weui-cell__ft">
	                    
	                </div>
	            </div>
	            <div class="weui-cell ">
	                <div class="weui-cell__hd">
	                    <label class="weui-label">科室位置</label>
	                </div>
	                <div class="weui-cell__bd">
	                    <input class="weui-input" type="text" value="门诊三楼西侧" disabled="true">
	                </div>
	            </div>
	            <div class="weui-cell ">
	                <div class="weui-cell__hd">
	                    <label class="weui-label">本次支付</label>
	                </div>
	                <div class="weui-cell__bd">
	                    <input class="weui-input" type="text" pattern="[0-9]*" value="${charge}元" disabled="true">
	                </div>
	            </div>
	        </div>
        
         <label for="weuiAgree" class="weui-agree">
            <input id="weuiAgree" type="checkbox" class="weui-agree__checkbox">
            <span class="weui-agree__text">
              	  阅读并同意<a href="javascript:void(0);">《相关条款》</a>
            </span>
        </label>

        <div class="weui-btn-area">
            <a class="weui-btn weui-btn_primary" href="javascript:" id="showTooltips" onclick="pay()">支付</a>
        </div>
        
             <%@include file="./../inc/tabbar.jsp"%>
		</div>
	</div>
    <script src="<%=request.getContextPath() %>/framework/weui/js/weui.min.js"></script>
    <script src="<%=request.getContextPath() %>/framework/bootstrap/js/jquery-1.9.1.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/app/common/common.js"></script>
    <script src="<%=request.getContextPath() %>/js/app/common/wxopenid.js"></script>
    <script src="<%=request.getContextPath() %>/js/common.js"></script>
    <script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>   
    
<script type="text/javascript">

	$(function(){
		$("#weuiAgree").click(function(){
// 			debugger;
// 			  alert($("#weuiAgree:checked"));
		});
	});
	
	function findPerData(eve){
		var card_no = $(eve).parent().prev().children(":first").val();
		if(card_no != null && card_no.length>0){
			$.ajax({
	            type: "GET",
	            url: "/ajax/common/register/mzghService/per",
	            data: {cardNo:card_no},
	            dataType: "json",
	            success: function(json){
	            	if(json.status =='ok')
	                    var data =  JSON.parse(json.data);
	            		var body = data.Body;
	            		$("input[name='personName']").val(body.personName);
	            		$("#personSex").val(body.personSex=='女'?'1':'0');
	            		
	            		var myDate = new Date();    
	            	    var cDate = myDate.getFullYear(); //获取完整的年份(4位,1970-????) 
	            	    
	            		var csrq = body.personCSRQ;
	            		csrq_str = csrq.substr(0,4);
	            		var age = parseInt(cDate)-parseInt(csrq_str); 
	            		$("input[name='age']").val(age);
	            		var personCSRQ = csrq.substr(0,csrq.indexOf(" "));
	            		$("input[name='personCSRQ']").val(personCSRQ.replace(/\//g,"-"));
	                }
	        });
		}
	}
	
	function pay(){
		var CardID = $("input[name='CardID']").val();
		var personName = $("input[name='personName']").val();
		var personSex = $("#personSex").find("option:selected").text();
		var age = $("input[name='age']").val();
		var personCSRQ = $("input[name='personCSRQ']").val();
		var CertificateNo = $("input[name='CertificateNo']").val();
		var PhoneCode = $("input[name='PhoneCode']").val();
		var PhoneCodeContact = $("input[name='PhoneCodeContact']").val();
		var DeptCode = '${deptCode}';
		var DoctorCode = '${doctorCode}';
		var cip = returnCitySN["cip"];
		
	var url = '/view/pay/wxJsAPI?CardID=' + CardID + '&CustomerName='
				+ personName + '&Sex=' + personSex + '&Birthday=' + personCSRQ
				+ '&CertificateNo=' + CertificateNo + '&PhoneCode=' + PhoneCode
				+ '&PhoneCodeContact=' + PhoneCodeContact + '&DeptCode='
				+ DeptCode + '&DoctorCode=' + DoctorCode
				+ '&charge=${charge}&spBillCreateIP=' + cip + '&openId='
				+ getOpenId();
		location.href = url;
	}
</script>

</body>
</html>
