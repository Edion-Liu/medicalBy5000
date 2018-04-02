<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>科室简介</title>
</head>
<body ontouchstart>
	<div class="container" id="container">
		<div class="page  js_show" id="menuDiv">
	    	
		</div>
	</div>
    
<script type="text/javascript">
window.onload=function(){ 
	initDept();
}

function initDept(){
	$.ajax({
        type: "GET",
        url: "${basepath}/ajax/common/getDeptMenu",
        data: null,
        dataType: "json",
        success: function(json){
        	if(json.status =='ok'){
        		var menu_data =  JSON.parse(json.data);

        		$("#menuDiv").empty();
                var menuDiv = '<div class="weui-cells" >';
                
           		for(var i = 0;i< menu_data.length ; i++){
           			var str = !isStrNULL(menu_data[i].remark)?menu_data[i].remark:'';
           			var color = '#888888';
           			if(menu_data[i].level !=null && menu_data[i].level==1){
           				color = 'red';
           			}
           			
           			menuDiv += '<div class="weui-cell weui-cell_access" ';
					if('03'==menu_data[i].deptUrlType){
       					
						menuDiv += 'onClick="openUrl(\'${basepath}\',\''+getDate(menu_data[i].deptUrl,'/dept/deptInfo')+'\',\''+menu_data[i].deptUrlType+'\')">';
       				}else{
       					menuDiv += 'onClick="openUrl(\'${basepath}\',\''+getDate(menu_data[i].deptUrl,'/dept/deptInfo')+'?deptId='+menu_data[i].id+'\',\''+menu_data[i].deptUrlType+'\')">';
       				}
					menuDiv += 		'<div class="weui-cell__hd" style="position: relative;margin-right: 10px;">'+
        				            '<img src="${basepath}/myres/img'+menu_data[i].icoPath+'" style="width: 50px;display: block"/>'+
        				        '</div>'+
        				        '<div class="weui-cell__bd">'+
        				            '<p>'+menu_data[i].name+'</p>'+
        				            '<p style="font-size: 13px;color: '+color+'">'+str+'</p>'+
        				        '</div>'+
        				        '<div class="weui-cell__ft"></div>'+
        				    '</div>';	
           		}
           		menuDiv += '</div>';
           		
        		$("#menuDiv").html(menuDiv);
        	}
        }
	})
}

function getDate(str,def){
	return isStrNULL(str) ? def:str;
}
</script>

</body>
</html>
