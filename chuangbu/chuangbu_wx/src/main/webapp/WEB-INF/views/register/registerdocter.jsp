<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>当日挂号-${deptName}</title>
    <style type="text/css">
    .weui-navbar__item.weui-bar__item_on {
	    background-color: #9BD1EF;
	}
    .weui-tab__panel .weui-flex__item {
	    background-color: #9BD1EF;
		height: 90px;
		border-radius: 10px;
		margin: 1px;
		padding-top: 5px;
		padding-left: 5px;
		font-size: 14px;
	}
    .weui-tab__panel .placeholder label{
	    color: #0000FF;
    	font-weight:bold;
    	font-family:"Microsoft YaHei",微软雅黑,"MicrosoftJhengHei",华文细黑,STHeiti,MingLiu;
    	font-size: 16px;
	}
    </style>
</head>
<body ontouchstart>
	<div class="container" id="container">
		<div class="page js_show" >
	        
			<div class="page__bd" style="height: 100%;">
		        <div class="weui-tab">
		            <div class="weui-tab__panel">
		            	<div id="docter">
							
				        </div>
		            </div>
		        </div>
		    </div>
			
			<div class="weui-footer">
                <p class="weui-footer__text">
            </div>
		</div>
	</div>
    <script src="<%=request.getContextPath()%>/js/app/common/wxopenid.js"></script>
	<script src="<%=request.getContextPath()%>/js/common.js"></script>
<script type="text/javascript">

	$(function(){
		getOpenIdDayRegisterCount();
		setDocterData();
	});
	
	function setDocterData(){
		$.ajax({
            type: "GET",
            url: "${basepath}/ajax/common/register/mzghService/docter",
            data: {deptCode:"${deptCode}"},
            dataType: "json",
            success: function(json){
            	if(json.status =='ok')
                    var data =  JSON.parse(json.data);
            		$("#docter").empty();
            		var docterDiv = '<div class="weui-flex menu_flex">';
            		var body = data.Body;
            		var i = 0
            		if(body.length > 0){
	            		for(;i< body.length ; i++){
	            				if(i%3==0){
	            					docterDiv += '</div><div class="weui-flex menu_flex">';	
	                			}
	            				docterDiv += '<div class="weui-flex__item"><div class="placeholder" onClick="registerInfo(\''+body[i].DoctorName+'\',\'${deptName}\',\''+body[i].Charge+'\',\''+body[i].DoctorCode+'\')"><label>'+body[i].DoctorName+'</label> &nbsp;&nbsp;&nbsp; '+body[i].Charge+'元<br>'+body[i].Professional+'<br>七日就诊 '+body[i].Statistics+'人</div></div>';
	            		}
            		}else{
            			docterDiv += '<div class="weui-flex__item"><div class="placeholder" onClick="registerInfo(\''+body.List.DoctorName+'\',\'${deptName}\',\''+body.List.Charge+'\',\''+body.List.DoctorCode+'\')"><label>'+body.List.DoctorName+'</label> &nbsp;&nbsp;&nbsp; '+body.List.Charge+'元<br>'+body.List.Professional+'<br>七日就诊 '+body.List.Statistics+'人</div></div>';
            			i++;
            		}
            		while (i%3!=0){
            			docterDiv += '<div class="weui-flex__item" style="background-color: #fff;"></div>';
            			i++
            		}
            		docterDiv += '</div>';
            		$("#docter").html(docterDiv);
                }
        });
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
	
	function registerInfo(docterName,deptName,charge,docterCode){
		if(count < 20){
			location.href = '${basepath}/view/pay/wxJsAPI/register?docterName='+docterName+'&deptName='+deptName+'&charge='+charge+'&doctorCode='+docterCode+'&deptCode=${deptCode}';
		}else{
			alert("用户今日挂号已经超过限制，请明天再次挂号");
		}
// 		location.href = '/view/register/info/'+docterName+'/'+deptName+'/'+charge+'/'+docterCode+'/${deptCode}';
	}
	
</script>

</body>
</html>
