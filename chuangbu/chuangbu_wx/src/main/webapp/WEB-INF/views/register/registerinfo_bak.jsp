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
	                    <input class="weui-input" type="tel" placeholder="请输入电话号">
	                </div>
	            </div>
	            <div class="weui-cell ">
	                <div class="weui-cell__hd">
	                    <label class="weui-label">家属电话</label>
	                </div>
	                <div class="weui-cell__bd">
	                    <input class="weui-input" type="tel" placeholder="请输入电话号">
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
	                    <input class="weui-input" type="docterCode" value="${docterName}" disabled="true">
	                </div>
	                <div class="weui-cell__ft">
	                    
	                </div>
	            </div>
	            <div class="weui-cell ">
	                <div class="weui-cell__hd">
	                    <label class="weui-label">就诊医生</label>
	                </div>
	                <div class="weui-cell__bd">
	                    <input class="weui-input" type="text" value="${deptName}" disabled="true">
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
            <a class="weui-btn weui-btn_primary" href="javascript:" id="showTooltips">支付</a>
        </div>
        
          <input type="button" value="qrcode" onclick="qrcode();"/>  
          <input type="button" value="upload" onclick="uploadImg();"/>  
    <input type="button" value="获取当前位置" onclick="getLocation();"/>  
        
             <%@include file="./../inc/tabbar.jsp"%>
		</div>
	</div>
    <script src="<%=request.getContextPath() %>/framework/weui/js/weui.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/app/common/common.js"></script>
    <script src="<%=request.getContextPath() %>/framework/bootstrap/js/jquery-1.9.1.min.js"></script>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js"> </script>
    <script type="text/javascript" src="http://counter.sina.com.cn/ip/" charset="gb2312"></script>  
    
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
	
	
	wx.config({  
	    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。  
	    appId: '${appId}', // 必填，公众号的唯一标识  
	    timestamp: '${ timestamp}' , // 必填，生成签名的时间戳  
	    nonceStr: '${ nonceStr}', // 必填，生成签名的随机串  
	    signature: '${ signature}',// 必填，签名，见附录1  
	    jsApiList: ['chooseImage','getLocation','openLocation'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2  
	});  
	   
	wx.ready(function(){  
	    alert("ready");  
	});  
	   
	wx.error(function (res) {
	  alert("调用微信jsapi返回的状态:"+res.errMsg);
	});
	   
	/*   
	function chooseWXPay() {
		$.ajax({
            type: "GET",
            url: "/ajax/pay/followUp/record/list",
            data: {totalFee:'${charge}',spBillCreateIP:ILData[0],patientId:"123"},
            dataType: "json",
            success: function(json){
            	if(json.status =='ok'){
            		var query = $("#queryBody"); 
            		$(query).empty();
                    var data =  JSON.parse(json.data);
                    var tbody ="";
            		for(var i = 0 ; i < data.length ; i++){
            			if(i%2==0){
	            			tbody += "<tr >"
            			}else{
	            			tbody += "<tr class=\"success\" >"
            			}
	            		tbody += "<td>" +  (i+1) + "</td><td>" +  data[i].name + "</td><td> <span class=\"glyphicon glyphicon-headphones\"></span></td></tr>"
            		}
            		$(query).html(tbody);
                }
            }
        });
	}   */
	   
	function qrcode() {  
		wx.scanQRCode({
		    needResult: 0, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
		    scanType: ["qrCode","barCode"], // 可以指定扫二维码还是一维码，默认二者都有
		    success: function (res) {
				    var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
				}
		});
	}
	   
	function uploadImg() {  
	    wx.checkJsApi({  
	        jsApiList: ['chooseImage','openLocation','getLocation'], // 需要检测的JS接口列表，所有JS接口列表见附录2,  
	        success: function(res) {  
	            // 以键值对的形式返回，可用的api值true，不可用为false  
	            // 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}  
	            alert(res);  
	            wx.chooseImage({  
	                  count: 1, // 默认9  
	                  sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有  
	                  sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有  
	                  success: function (res) {  
	                    var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片  
	                    alert(localIds);  
	                  }  
	                });  
	        }  
	    });  
	}
	   
	function getLocation() {  
	       
	    var latitude = "";  
	    var longitude = "";  
	       
	    wx.getLocation({
	        type: 'gcj02', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'  
	        success: function (res) {  
	            latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90  
	            longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。  
	            var speed = res.speed; // 速度，以米/每秒计  
	            var accuracy = res.accuracy; // 位置精度  
	               
	               
	            wx.openLocation({  
	                latitude: latitude, // 纬度，浮点数，范围为90 ~ -90  
	                longitude: longitude, // 经度，浮点数，范围为180 ~ -180。  
	                name: '你当前的位置', // 位置名  
	                address: 'currentLocation', // 地址详情说明  
	                scale: 26, // 地图缩放级别,整形值,范围从1~28。默认为最大  
	                infoUrl: '' // 在查看位置界面底部显示的超链接,可点击跳转  
	            });  
	               
	        }  
	    });  
	       
	}  
</script>

</body>
</html>
