<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">

</head>

<body >
	<div class="head_back">
	 	<span class="back" onclick="history.go(-1)">返回</span>
	 	<label id="head_title"></label>
	 	<span class="refresh" onclick="location.reload()">刷新</span>
	 </div>
	
</body>

<script type="text/javascript">
 	window.onload=function(){
 	  var title= $(document).attr("title");
 	  title = title!=null && title.length>20 ?'':title;
      $("#head_title").text(title);
	}
</script>
</html>
