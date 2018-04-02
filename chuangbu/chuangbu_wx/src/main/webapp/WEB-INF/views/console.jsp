<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="./../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微服务控制台</title>
</head>
<style type="text/css">

body{
	background-color: #4C9ED9 !important;
	color: #fff !important;
}

.Absolute-Center {
  width: 50%;  
  height: 50%;  
  overflow: auto;  
  margin: auto;  
  position: absolute;  
  top: 0; left: 0; bottom: 0; right: 0;  
}
.form-bottom button{
font-size: 3em;
height: 2em;
} 
</style>
<body style="text-align: center;">
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="${basepath}/framework/bootstrap/css/bootstrap.min.css">

	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet" href="${basepath}/framework/bootstrap/css/bootstrap-theme.min.css">

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="${basepath}/framework/bootstrap/js/jquery-1.9.1.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="${basepath}/framework/bootstrap/js/bootstrap.min.js"></script>

	<div class="container Absolute-Center" >
		<br>
		<br>
		<button type="submit" class="btn btn-default refresh-config"><span class="glyphicon glyphicon-refresh"></span>&nbsp; 刷新菜单</button>
	</div>
	
	 
<script type="text/javascript">
$(function(){
	
    $(".refresh-config").on('click',function(){
    	 $.ajax({
            type: "GET",
            url: "${basepath}/ajax/console/refresh/config",
            data: null,
            dataType: "json",
            success: function(json){
	            	if(json.status =='ok'){
	            		alert("刷新菜单成功！");
	            	}else{
	            		alert("刷新菜单失败！");
	            		
	            	}
            		
                }
        }); 
    });
    
});

	
</script>
</body>
</html>