<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title></title>
</head>
<body ontouchstart>
	<div class="container" id="container" style="padding-top: 0px;">
		<div class="page flex js_show" id ="menuDiv">
	
		</div>
	</div>
    <%@ include file="./../commons/layout/footer.jsp"%>

    
<script type="text/javascript">
    window.onload=function(){
    	$(document).attr("title",'${org_app_name}')
     var menu_data =  JSON.parse('${org_menu_key}');
        $("#menuDiv").empty();
        var menuDiv = '<div class="weui-flex head_bj">'+
					            '<div class="weui-flex__item"><div class="placeholder">'+
								'<img id="head_bj" src="./myres/img/${appId}_head_1.jpg" alt=""></div></div>'+
					    '</div>';
        var i = 0;
        var n = 4;
   		for(;i< menu_data.length ; i++){
   				if(i%n==0){
   					menuDiv += '</div><div class="weui-flex menu_flex">';	
       			}
   				if('03'==menu_data[i].menuType){
   					
	   				menuDiv += '<div class="weui-flex__item"><div class="placeholder menu outpatientPay" onClick="openUrl(\'${basepath}\',\''+menu_data[i].menuUrl+'\',\''+menu_data[i].menuType+'\')"><img src="./myres/img/'+menu_data[i].icoPath+'" alt="" ><h4 class="title">'+menu_data[i].menuName+'</h4></div></div>';
   				}else{
   					
	   				menuDiv += '<div class="weui-flex__item"><div class="placeholder menu outpatientPay" onClick="openUrl(\'${basepath}\',\''+menu_data[i].menuUrl+'?menuId='+menu_data[i].id+'\',\''+menu_data[i].menuType+'\')"><img src="./myres/img/'+menu_data[i].icoPath+'" alt="" ><h4 class="title">'+menu_data[i].menuName+'</h4></div></div>';
   				}
   		}
        while (i%n!=0){
        	menuDiv += '<div class="weui-flex__item" style="background-color: #fff;"></div>';
			i++
		}
        menuDiv += '</div>';
		$("#menuDiv").html(menuDiv);
		
	//设置图片切换
      setInterval("setHeadBj()",1000*3);
	}
	var i = 1;
	var headbjs = ['head_1','head_2','head_3'];
	function setHeadBj(){
		if(i>=headbjs.length){
			i=0;
		}
		var headBj = document.getElementById("head_bj");
		headBj.src="./myres/img/${appId}_"+headbjs[i]+".jpg";
		i++;
	}
	
</script>

</body>
</html>
