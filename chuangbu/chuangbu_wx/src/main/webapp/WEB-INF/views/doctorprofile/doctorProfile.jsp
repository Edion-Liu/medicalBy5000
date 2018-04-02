<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>医生简介</title>
</head>
<body ontouchstart>
	<div class="container" id="container">
		<div class="page  js_show" id="menuDiv">
			 
	    	
		</div>
	</div>
    
<script type="text/javascript">
    window.onload=function(){ 
    	initDocter();
    }
	function newopenUrl(url){
		location.href = url;
	}
	
	function initDocter(){
		$.ajax({
            type: "GET",
            url: "${basepath}/ajax/common/getDorterMenu",
            data: null,
            dataType: "json",
            success: function(json){
            	if(json.status =='ok'){
            		var menu_data =  JSON.parse(json.data);

            		$("#menuDiv").empty();
                    var menuDiv = '<div class="weui-cells" >';
                    
               		for(var i = 0;i< menu_data.length ; i++){
               			var str = !isStrNULL(menu_data[i].deptName)?menu_data[i].deptName:'';
               			str += !isStrNULL(menu_data[i].title)?'&nbsp;&nbsp;'+menu_data[i].title:'';
               			str += !isStrNULL(menu_data[i].position)?'&nbsp;&nbsp;'+menu_data[i].position:'';
               			
               			menuDiv += '<div class="weui-cell weui-cell_access" onClick="openUrl(\'${basepath}\',\''+getDate(menu_data[i].pageUrl,'/doctorprofile/doctorInfo')+'?docterId='+menu_data[i].id+'\',\''+menu_data[i].pageUrlType+'\')">'+
            				            '<div class="weui-cell__hd" style="position: relative;margin-right: 10px;">'+
            				            '<img src="${basepath}/myres/img'+menu_data[i].photoPath+'" style="width: 50px;display: block"/>'+
            				        '</div>'+
            				        '<div class="weui-cell__bd">'+
            				            '<p>'+menu_data[i].name+'</p>'+
            				            '<p style="font-size: 13px;color: #888888">'+str+'</p>'+
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
