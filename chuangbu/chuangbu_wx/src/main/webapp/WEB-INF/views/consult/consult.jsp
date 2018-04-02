<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>科左后旗人民医院</title>
    <link rel="stylesheet" href="./../../framework/weui/style/weui.css"/>
    <link rel="stylesheet" href="./../../css/theme_default.css"/>
</head>
<body ontouchstart>
	<div class="head_back">
	 	<span class="back" onclick="history.go(-1)">返回</span>
	 	在线咨询
	 	<span class="refresh" onclick="location.reload()">刷新</span>
	 </div>
	<div class="container" id="container">
		<div class="page js_show" >
	        
			<article class="weui-article">
	            <section>
                     <img src="./../../myres/img/synopsis.jpg" alt="" >
	            	<h4 class="title">【简介】</h4>
                    <p>
                     	完善简介
                    </p>
					<h4 class="title">【科室擅长】</h4>
                    <p>
                     	完善组成
                    </p>
					<h4 class="title">【团队组成】</h4>
                    <p>
                     	 完善
                    </p>
					<h4 class="title">【先进设备】</h4>
                    <p>
                     	 完善设备
                    </p>
					<h4 class="title">【科研成果】</h4>
                    <p>
                     	 完善成果
                    </p>
                    
	            </section>
	                
	        </article>
             <%@include file="./../inc/tabbar.jsp"%>
		</div>
	</div>
    <script src="<%=request.getContextPath() %>/framework/weui/js/weui.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/app/common/common.js"></script>
    
<script type="text/javascript">
    window.onload=function(){ }   	
</script>

</body>
</html>
