<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>科左后旗人医院</title>
    <link rel="stylesheet" href="./../../framework/weui/style/weui.css"/>
    <link rel="stylesheet" href="./../../css/theme_default.css"/>
</head>

<body ontouchstart>
	<div class="head_back">
	 	<span class="back" onclick="history.go(-1)">返回</span>
	 	院内办公
	 	<span class="refresh" onclick="location.reload()">刷新</span>
	 </div>
	<div class="container" id="container">
		<div class="page js_show" >
	        
			<article class="weui-article">
	            <section>
                    <div class="eChartsDiv">
						<div id="main" style="height:400px;"></div>
					</div>
					<div class="eChartsDiv">
						<div id="main2" style="height:200px;"></div>
					</div>
					<div class="eChartsDiv">
						<div id="main3" style="height:200px;"></div>
					</div>
	            </section>
	                
	        </article>
             <%@include file="./../inc/tabbar.jsp"%>
		</div>
	</div>
    <script src="<%=request.getContextPath() %>/framework/weui/js/weui.min.js"></script>
    <script src="<%=request.getContextPath() %>/framework/echarts/js/echarts.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/myecharts.js"></script>
    <script src="<%=request.getContextPath() %>/js/app/common/common.js"></script>
    <script src="<%=request.getContextPath() %>/framework/bootstrap/js/jquery-1.9.1.min.js"></script>
    
<script type="text/javascript">
	function initWin(){
		$.ajax({
	        type: "GET",
	        url: "/ajax/statistical/global/data",
	        data: null,
	        dataType: "json",
	        success: function(json){
	        	if(json.status =='ok')
	                var data =  JSON.parse(json.data);
	        		setData(data);
	            }
	    });
			
	}

	function setData(data){
		
		//初始化医院财务收入饼图
	    var obj =document.getElementById("main");
		var p_data = data.incomeData;
		var p_title = '医院财务收入分析';
		var p_focusName = '';
		var option = MyECharts.ChartOptionTemplates.Pie(obj, p_data, p_title,p_focusName);
		var opt = MyECharts.ChartConfig(obj, option);
		MyECharts.Charts.RenderChart(opt);

		//初始化住院情况
		var obj2 = document.getElementById("main2");
		var p_data2 = data.inoutData;
		var p_title2 = "住院情况";
		var p_subTitle2 = "单位 ：X-时间    Y-人数";
		var option2 = MyECharts.ChartOptionTemplates.Lines(p_data2, null,p_title2+";"+p_subTitle2,false,true);
		var opt2 = MyECharts.ChartConfig(obj2, option2);
		MyECharts.Charts.RenderChart(opt2);
		
		//初始化住院收入
		var obj3 = document.getElementById("main3");
		var p_data3 = data.weekIncomeData;
		var p_title3 = "住院收入";
		var p_subTitle3 = "单位 ：X-时间    Y-元";
		var option3 = MyECharts.ChartOptionTemplates.Lines(p_data3, null,p_title3+";"+p_subTitle3,false,true);
		var opt3 = MyECharts.ChartConfig(obj3, option3);
		MyECharts.Charts.RenderChart(opt3);
			
	}

	$(document).ready(function() {
		initWin();
	});
		
</script>

</body>
</html>
