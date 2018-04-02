<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>今日动态</title>
</head>

<body ontouchstart>
	<div class="container" id="container">
		<div class="page js_show" >
	        
	        <div class="page__bd" style="height: 100%;">
		        <div class="weui-tab">
		            <div class="weui-navbar">
		                <div class="weui-navbar__item weui-bar__item_on allhosp">
		             		全院动态
		                </div>
		                <div class="weui-navbar__item clinic">
		                	 门诊动态
		                </div>
		                <div class="weui-navbar__item hosp">
		                	 住院动态
		                </div>
		                <div class="weui-navbar__item medicalSkill">
		                	 医技动态
		                </div>
		            </div>
		            <div class="weui-tab__panel">
		            	<div id="allhosp" >
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
				        </div>
		            	<div id="clinic" style="display: none;">
							1
				        </div>
		            	<div id="hosp" style="display: none;">
							2
				        </div>
		            	<div id="medicalSkill" style="display: none;">
							3
				        </div>
		            </div>
		        </div>
		    </div>
		    
			
		</div>
	</div>
    <script src="<%=request.getContextPath() %>/framework/echarts/js/echarts.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/myecharts.js"></script>
    
<script type="text/javascript">
	function initWin(){
		$.ajax({
	        type: "GET",
	        url: "${basepath}/ajax/statistical/global/data",
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
	
	$(function(){
	    $('.weui-navbar__item').on('click', function () {
	        $(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
	        if($(this).hasClass("clinic")){
	        	$(".weui-tab__panel").children().hide();
	        	$("#clinic").show();
	        }else if($(this).hasClass("hosp")){
	        	$(".weui-tab__panel").children().hide();
	        	$("#hosp").show();
	        }else if($(this).hasClass("medicalSkill")){
	        	$(".weui-tab__panel").children().hide();
	        	$("#medicalSkill").show();
	        }else if($(this).hasClass("allhosp")){
	        	$(".weui-tab__panel").children().hide();
	        	$("#allhosp").show();
	        }
	        
	    });
    	
	});
		
</script>

</body>
</html>
