<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>当日挂号</title>
    <style type="text/css">
    .weui-navbar__item.weui-bar__item_on {
	    background-color: #9BD1EF;
	}
    .weui-tab__panel .weui-panel__hd{
    	color: #0000FF;
    	font-weight:bold;
    	font-family:"Microsoft YaHei",微软雅黑,"MicrosoftJhengHei",华文细黑,STHeiti,MingLiu";
    	font-size: 16px;
    }
    .weui-tab__panel .weui-flex__item {
	    background-color: #9BD1EF;
	    text-align: center;
	    height: 45px;
	}
    .weui-tab__panel .weui-flex__item h4{
	    line-height: 25px;
	}
    .weui-tab__panel .placeholder .title {
	    color: #000;
	}
    </style>
</head>
<body ontouchstart>
	<div class="container" id="container">
		<div class="page js_show" >
	        
			<div class="page__bd" style="height: 100%;">
		        <div class="weui-tab">
		            <div class="weui-navbar">
		                <div class="weui-navbar__item weui-bar__item_on dept">
		             		选择科室
		                </div>
		                <div class="weui-navbar__item docter">
		                	 选择医生
		                </div>
		            </div>
		            <div class="weui-tab__panel">
		            	<div id="dept" >
		            		<div id ="zjdept"></div>
						     <div id ="ptdept"></div>
				        </div>
		            	<div id="docter" style="display: none;">
							<div class="weui-panel__hd">专家组</div>
							<div class="weui-flex menu_flex">
					            <div class="weui-flex__item"><div class="placeholder">
									<h4 class="title"></h4>
								</div></div>
					            <div class="weui-flex__item"><div class="placeholder">
									<h4 class="title"></h4>
								</div></div>
					            <div class="weui-flex__item"><div class="placeholder">
									<h4 class="title"></h4>
								</div></div>
					        </div>
							<div class="weui-panel__hd">普通组</div>
							<div class="weui-flex menu_flex">
					            <div class="weui-flex__item"><div class="placeholder">
									<h4 class="title"></h4>
								</div></div>
					            <div class="weui-flex__item"><div class="placeholder">
									<h4 class="title"></h4>
								</div></div>
					            <div class="weui-flex__item"><div class="placeholder">
									<h4 class="title"></h4>
								</div></div>
					        </div>
				        </div>
		            </div>
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
		getOpenId('${appId}','${basepath}') ;
	    $('.weui-navbar__item').on('click', function () {
	        $(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
	        if($(this).hasClass("docter")){
	        	$("#dept").hide();
	        	$("#docter").show();
	        }else{
	        	$("#docter").hide();
	        	$("#dept").show();
	        }
	        
	    });
	    
	    var zjdept = $("#zjdept").html(); 
    	if(zjdept == null || zjdept.length == 0) {
        	setDeptData();
    	}
    	
	});
	
	function setDeptData(){
		$.ajax({
            type: "GET",
            url: "${basepath}/ajax/common/register/mzghService/dept",
            data: null,
            dataType: "json",
            success: function(json){
            	if(json.status =='ok')
                    var data =  JSON.parse(json.data);
            		$("#zjdept").empty();
            		$("#ptdept").empty();
            		
            		var zjdiv = '<div class="weui-panel__hd">专家组</div><div class="weui-flex menu_flex">';
            		var zj = 0 ;
            		
            		var ptdiv = '<div class="weui-panel__hd">普通组</div><div class="weui-flex menu_flex">';
            		var pt = 0 ;
            		
            		var body = data.Body;
            		if(body.length > 0){
	            		for(var i = 0 ;i< body.length; i++){
	            			if('专家门诊' == body[i].VisitType){
	            				if(zj%3==0){
	            					zjdiv += '</div><div class="weui-flex menu_flex">';	
	                			}
	            				zjdiv += '<div class="weui-flex__item"><div class="placeholder" onClick="docter(\''+body[i].DeptCode+'\',\''+body[i].DeptName+'\')"><h4 class="title">'+body[i].DeptName+'</h4></div></div>';
	            				zj++;
	            			}else{
	            				if(pt%3==0){
	            					ptdiv += '</div><div class="weui-flex menu_flex">';	
	                			}
	            				ptdiv += '<div class="weui-flex__item"><div class="placeholder" onClick="docter(\''+body[i].DeptCode+'\',\''+body[i].DeptName+'\')"><h4 class="title">'+body[i].DeptName+'</h4></div></div>';
	            				pt++;
	            			}
	            		}
            		}else{
            			if('专家门诊' == body.List.VisitType){
            				if(zj%3==0){
            					zjdiv += '</div><div class="weui-flex menu_flex">';	
                			}
            				zjdiv += '<div class="weui-flex__item"><div class="placeholder" onClick="docter(\''+body.List.DeptCode+'\',\''+body.List.DeptName+'\')"><h4 class="title">'+body.List.DeptName+'</h4></div></div>';
            				zj++;
            			}else{
            				if(pt%3==0){
            					ptdiv += '</div><div class="weui-flex menu_flex">';	
                			}
            				ptdiv += '<div class="weui-flex__item"><div class="placeholder" onClick="docter(\''+body.List.DeptCode+'\',\''+body.List.DeptName+'\')"><h4 class="title">'+body.List.DeptName+'</h4></div></div>';
            				pt++;
            			}
            		}
            		while (zj%3!=0){
            			zjdiv += '<div class="weui-flex__item" style="background-color: #fff;"></div>';
            			zj++
            		}
            		while (pt%3!=0){
            			ptdiv += '<div class="weui-flex__item" style="background-color: #fff;"></div>';
            			pt++
            		}
            		
            		zjdiv += '</div>';
            		ptdiv += '</div>';
            		$("#zjdept").html(zjdiv);
            		$("#ptdept").html(ptdiv);
                }
        });
	}
	
	function docter(deptCode,deptName){
		location.href = '${basepath}/view/register/docter/'+deptCode+'/'+deptName;
	}
	
</script>

</body>
</html>
