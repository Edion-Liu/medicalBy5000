<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRM</title>
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

</style>
<body style="text-align: center;">
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="./../framework/bootstrap/css/bootstrap.min.css">

	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet" href="./../framework/bootstrap/css/bootstrap-theme.min.css">

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="./../framework/bootstrap/js/jquery-1.9.1.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="./../framework/bootstrap/js/bootstrap.min.js"></script>

	<div class="container Absolute-Center" >
		<div class="col-sm-10 col-sm-offset-1 col-md-4 col-md-offset-4 form-box">
			<div class="form-top">
				<div class="form-top-left">
					<h2>客户管理系统</h2>
					<p>请输入您的用户名和密码登录。</p>
				</div>
				<div class="form-top-right">
					<i class="fa fa-lock"></i>
				</div>
			</div>
			<div class="form-bottom">
				<form role="form" action="/login" method="post" class="login-form">
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