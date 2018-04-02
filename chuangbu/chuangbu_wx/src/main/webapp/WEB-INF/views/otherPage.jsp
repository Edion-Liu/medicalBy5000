<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title></title>
</head>
<body ontouchstart>
	<div class="container" id="container">
		<div class="page  js_show" >
<!-- 			 <iframe id="myIframe" src="" scrolling="no" style="width: 100%;height: 90%;"></iframe> -->
	    	<jsp:include page="${menuUrl}" flush="true"/>
		</div>
	</div>
    
    <script type="text/javascript">
    window.onload=function(){
    	$(document).attr("title",'${menuName}')
// 		$("#myIframe").attr("src",'${menuUrl}');
//     	setIframeHeight(document.getElementById('myIframe'));
	}
	
    function setIframeHeight(iframe) {
    	if (iframe) {
	    	var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
	    	if (iframeWin.document.body) {
	    		iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
	    	}
    	}
    };
	
</script>

</body>
</html>
