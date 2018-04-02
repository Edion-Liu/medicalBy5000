<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" import="javax.servlet.jsp.jstl.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base>
    
    <title></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	</head>

<link href="<%=request.getContextPath() %>/framework/ace/css/font-awesome.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/framework/ace/css/ace-navbar.css" rel="stylesheet">

	<body class="navbar-fixed">

		<div class="sidebar" id="sidebar">
			<script type="text/javascript">
				try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
			</script>
			
			<ul class="nav nav-list">
					
					<li>
						<c:forEach items="${menus}" var="menu" varStatus="st">  
							<c:if test="${menu.level==1 && menu.leaf==1}">
							    <c:if test="${!st.first}">
									</li>
									<li>
								</c:if>
									<a id="menu_one_${menu.id}" href="/view${menu.url}<c:if test="${fn:contains(menu.url, '?')}">&</c:if><c:if test="${!fn:contains(menu.url, '?')}">?</c:if>menuId=menu_one_${menu.id}">
										<i class="${menu.iconname}"></i>
										<span class="menu-text"> ${menu.displayName} </span>
									</a>
								
							</c:if>
							<c:if test="${menu.level==1 && !(menu.leaf==1)}">
								<c:if test="${!st.first}">
									</li>
									<li>
								</c:if>
									<a id="menu_one_${menu.id}" href="#" class="dropdown-toggle">
										<i class="${menu.iconname}"></i>
										<span class="menu-text">${menu.displayName}</span>
			
										<b class="arrow icon-angle-down"></b>
									</a>
								<ul class="submenu">
							</c:if>
							<c:if test="${menu.level==2 && menu.leaf==1}">
								<li>
									<a id="menu_two_${menu.id}" href="/view${menu.url}<c:if test="${fn:contains(menu.url, '?')}">&</c:if><c:if test="${!fn:contains(menu.url, '?')}">?</c:if>menuId=menu_two_${menu.id}">
										<i class="${menu.iconname}"></i>
										${menu.displayName}
									</a>
								</li>
							</c:if>
									
							<c:if test="${st.last}">
								<c:if test="${menu.level==2 && menu.leaf ==1}">
									</ul>
								</c:if>
							</c:if> 
						 </c:forEach> 
						 
					</li>

				</ul><!-- /.nav-list -->
				
			<div class="sidebar-collapse" id="sidebar-collapse">
				<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
			</div>

			<script type="text/javascript">
				try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
			</script>
			
	</div><!-- /.menu-container -->

	<script type="text/javascript">
	function getHeight() {
	    return document.body.clientHeight ;
	}
	
	$(function() {
		var menuId = "${menuId}";
		if(typeof(menuId) != "undefined"){
			if(menuId.indexOf("menu_one_") != -1){
				$("#"+menuId).parent().addClass("active");
			}
			if(menuId.indexOf("menu_two_") != -1){
				$("#"+menuId).parents("ul").show();
				$("#"+menuId).parent().addClass("active");
			}
			
		}
		
		$("#sidebar-collapse").click(function(){
			if($(this).width()<50){
				$(".main-content").css("margin-left","190px");
			}else{
				$(".main-content").css("margin-left","49px");
			}
		});
		
// 		$("nav-list")
// 		var menuurl ="/permission/getMenu";
// 		getDataPOST(menuurl,null,function(json){
// 			if(json != null && json.status=="ok"){
// 				var jsonDate = JSON.parse(json.jsonData);
				
// 				if(typeof(jsonDate) != "undefined" && jsonDate.length >0){
// 					var nav_obj = $(".nav-list");
// 					nav_obj.empty();
// 					for (var i = 0; i < jsonDate.length; i++) {
// 						if(jsonDate[i].level ==1){
// 							var m_li = $("<li > </li>");
// 							var m_a = $("<a href=\""+jsonDate[i].url+"\"> </a>");
// 							var m_i = $("<i class=\"icon-dashboard\"> </i>");
// 							var m_span = $("<span class=\"menu-text\">"+jsonDate[i].displayName+" </span>");
						
// 							m_a.append(m_i);
// 							m_a.append(m_span);
// 							m_a.appendTo(m_li);
						
// 							m_li.appendTo(nav_obj);
// 						}
// 				    }
// 				}
// 			}
			
// 		},function(){});
	})
	</script>
	
	</body>
</html>
