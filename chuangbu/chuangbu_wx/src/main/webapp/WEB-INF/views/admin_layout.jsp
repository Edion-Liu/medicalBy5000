<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>

<title><sitemesh:write property='title' /></title>
<head><sitemesh:write property='head' /></head>

<body >


	<%@ include file="./../commons/layout/header.jsp"%>
						
	<sitemesh:write property='body' />
			
	<%@ include file="./../commons/layout/footer.jsp"%>

</body>
</html>
