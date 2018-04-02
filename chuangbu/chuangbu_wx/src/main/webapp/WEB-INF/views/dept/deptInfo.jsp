<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title></title>
</head>
<body ontouchstart>
	<div class="container" id="container">
		<div class="page js_show" id="deptInfoDiv">
	        
			
		</div>
	</div>

<script type="text/javascript">
window.onload=function(){ 
	initDeptInfo();
}

function initDeptInfo(){
	$.ajax({
        type: "GET",
        url: "${basepath}/ajax/common/getDeptData",
        data: {deptId:'${deptId}'},
        dataType: "json",
        success: function(json){
        	if(json.status =='ok'){
        		var info_data =  JSON.parse(json.data);
        		
        		$(document).attr("title",info_data.name)
        		$("#head_title").text(info_data.name);
        		
        		$("#deptInfoDiv").empty();
                var deptInfoDiv = '<article class="weui-article"><section>';
                deptInfoDiv += '<img src="./../../myres/img/${appId}_synopsis.jpg" alt="" >';
                deptInfoDiv += '<h4 class="title">【简介】</h4>';
                deptInfoDiv += '<p>'+getDate(info_data.synopsis)+'</p>';
                deptInfoDiv += '<h4 class="title">【团队组成】</h4>';
                deptInfoDiv += '<p>'+getDate(info_data.team)+'</p>';
                deptInfoDiv += '<h4 class="title">【科室擅长】</h4>';
                deptInfoDiv += '<p>'+getDate(info_data.specialty)+'</p>';
                deptInfoDiv += '<h4 class="title">【科研成果】</h4>';
                deptInfoDiv += '<p>'+getDate(info_data.achievements)+'</p>';
                
                deptInfoDiv += '</section></article>';
           		
        		$("#deptInfoDiv").html(deptInfoDiv);
        	}
        }
	})
}

function getDate(str){
	return isStrNULL(str) ? '暂无':str;
}
</script>

</body>
</html>
