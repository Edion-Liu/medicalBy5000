<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="./../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科左后旗人民医院</title>
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
.head_back {
	text-align: center;
	border-bottom: 1px solid #C0BFC4;
	padding: 5px 0px;
	position: fixed;
	top: 0px;
	left: 0px;
	width: 100%;
	z-index: 99;
 	line-height: 2em; 
 	font-size: 3em; 
 	 background-color: #4C9ED9; 
}
.head_back .back{
	float: left;
	margin-left: 10px;
}
.head_back .refresh{
	float: right;
	margin-right: 10px;
}
 .form-top-left h4 {
    font-size: 5em;
}
.form-top-left p {
    font-size: 2em;
}
.form-group input{
font-size: 3em;
height: 2em;
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
	<!-- Top content -->
	<div class="head_back">
	 	<span class="back" onclick="history.go(-1)">返回</span>
	 	<span class="refresh" onclick="location.reload()">刷新</span>
	</div>

	<div class="container Absolute-Center" >
		<div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 form-box">
			<div class="form-top">
				<div class="form-top-left">
					<h4>医疗办公系统</h4>
					<p>请输入您的用户名和密码登录。</p>
				</div>
				<div class="form-top-right">
					<i class="fa fa-lock"></i>
				</div>
			</div>
			<div class="form-bottom">
				<form role="form" action="${basepath}/login" method="post" class="login-form">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<input type="text" name="userName" placeholder="Username..."
									class="form-control" id="form-username">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<input type="password" name="password" placeholder="Password..."
									class="form-control" id="form-password">
							</div>
						</div>
					</div>
					<%-- <div class="form-group">
						<div class="row">
							<div class="col-sm-6">
								<input type="text" name="captcha" placeholder="captcha..."
									class="form-control" id="form-captcha">
								<img alt="captcha"
									style="width: 112px; height: 29px; cursor: pointer"
									src="${ctx}/static/images/kaptcha.jpg" title="点击更换"
									onclick="this.src='${ctx}/static/images/kaptcha.jpg?t=' + Math.random()">
							</div>
						</div>
					</div> --%>
					<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-log-in"></span>&nbsp; 登录</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>