<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title></title>
</head>
<a></a>
<body ontouchstart>

<a href="http://120.25.78.234:8024/"  style="width: 200px;height: 500px;font-size: 100px;">W3School</a>
	<div class="container" id="container">
		<div class="page  js_show" id='menuDiv'>
			 
	    	
		</div>
	</div>
    
    <script type="text/javascript">
    window.onload=function(){
//     	$(document).attr("title",'${menuName}')
     var menu_data =  JSON.parse('${menuData}');
        $("#menuDiv").empty();
        var menuDiv = '<div class="weui-cells" >';
        
   		for(var i = 0;i< menu_data.length ; i++){
   			menuDiv += '<div class="weui-cell weui-cell_access" onClick="openUrl(\'${basepath}\',\''+menu_data[i].menuUrl+'\',\''+menu_data[i].menuType+'\')">'+
				            '<div class="weui-cell__hd" style="position: relative;margin-right: 10px;">'+
				            '<img src="${basepath}/myres/img'+menu_data[i].icoPath+'" style="width: 50px;display: block"/>'+
				        '</div>'+
				        '<div class="weui-cell__bd">'+
				            '<p>'+menu_data[i].menuName+'</p>'+
				            '<p style="font-size: 13px;color: #888888;"></p>'+
				        '</div>'+
				        '<div class="weui-cell__ft"></div>'+
				    '</div>';	
   		}
   		menuDiv += '</div>';
   		
		$("#menuDiv").html(menuDiv);
		
	}
	
	
</script>

</body>
</html>
