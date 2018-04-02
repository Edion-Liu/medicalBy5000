<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>

<title><sitemesh:write property='title' /></title>
<head><sitemesh:write property='head' /></head>

<body class="navbar-fixed">

	<%@ include file="./../commons/layout/header.jsp"%>
	
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<%@ include file="./../commons/layout/navbar.jsp"%>

				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){
							}
						</script>

						<ul class="breadcrumb">
							<li class="active">
								<i class="icon-home home-icon"></i>
								<a href="#">首页</a>
							</li>
						</ul><!-- .breadcrumb -->

					</div>

						
					<sitemesh:write property='body' />
				</div><!-- /.main-content -->

			</div><!-- /.main-container-inner -->

		</div>

<!-- 模态框（Modal） -->


	<script type="text/javascript">

	
	</script>
	
</body>
</html>
