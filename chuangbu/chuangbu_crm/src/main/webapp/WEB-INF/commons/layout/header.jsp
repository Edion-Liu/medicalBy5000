<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">

<link href="<%=request.getContextPath() %>/framework/ace/css/ace-header.css" rel="stylesheet">

</head>

<body class="navbar-fixed">
	<div class="navbar navbar-inverse navbar-fixed-top navbar-layoutit">
				
		<div class="navbar-header">
			<a class="navbar-brand" href="index"> 
				<i class="glyphicon glyphicon-link"></i>
			 	CRM客户管理系统 
			</a>
		</div>
		
		<div class="navbar-header pull-right">
			<ul class="nav navbar-nav navbar-right das-nav">
				<li class="dropdown">
					 <a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<img class="nav-user-photo" src="/img/avatars/user.jpg" alt="Jason's Photo" />
						<span class="user-info">
							<small>欢迎光临,</small>
							${user.name}
						</span>
						<i class="glyphicon glyphicon-chevron-down"></i>
					 </a>
					<ul class="dropdown-menu">
						<li>
							 <a href="#">设置</a>
						</li>
						<li class="divider"> </li>
						<li>
							 <a href="#">个人资料</a>
						</li>
						<li class="divider"> </li>
						<li>
							 <a href="<%=request.getContextPath() %>/logout">退出</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
	
</body>
</html>
