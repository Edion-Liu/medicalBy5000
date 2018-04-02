<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>领导团队</title>
    <link rel="stylesheet" href="./../../framework/weui/style/weui.css"/>
    <link rel="stylesheet" href="./../../css/theme_default.css"/>
</head>
<body ontouchstart>
	<div class="head_back">
	 	<span class="back" onclick="history.go(-1)">返回</span>
	 	冯  涛
	 	<span class="refresh" onclick="location.reload()">刷新</span>
	 </div>
	<div class="container" id="container">
		<div class="page js_show" >
	
	        <div class="weui-flex doctor-flex" >
	            <div class="weui-flex__item"><div class="placeholder">
					<h4>姓名：<span>冯  涛</span></h4>
					<h4>科室：<span>副院长办公室</span></h4>
					<h4>职称：<span>副院长</span></h4>
					<h4>职务：<span>副院长</span></h4>
				</div></div>
	            <div class="weui-flex__item"><div class="placeholder">
					<img src="./../../myres/img/doctor/worker_ft.jpg" alt="" >
				</div></div>
	        </div>
	        <div class="weui-flex doctor-flex" >
	            <div class="weui-flex__item"><div class="placeholder">
					<h4>擅长：<span>填写完善 </span></h4>
				</div></div>
	        </div>
	        
			<article class="weui-article">
	            <section>
	            	<h4 class="title">【个人简介】</h4>
                    <p>
                     	 填写完善
                    </p> 
	            	<h4 class="title">【科研成果】</h4>
                    <p>
                     	 填写完善
                    </p>
	            	<h4 class="title">【发表文章】</h4>
                    <p>
                     	 填写完善
                    </p>
	            	<h4 class="title">【病历示范】</h4>
                    <p>
                     	 填写完善
                    </p>
                    
	            </section>
	                
	        </article>
	    	
             <%@include file="./../inc/tabbar.jsp"%>
		</div>
	</div>
    <script src="./../../framework/weui/js/weui.min.js"></script>
    <script src="./../../js/app/common/common.js"></script>
    
<script type="text/javascript">
    window.onload=function()
	{
      
	}    	
</script>

</body>
</html>
