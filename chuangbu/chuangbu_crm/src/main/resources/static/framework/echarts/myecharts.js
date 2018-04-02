var MyECharts = {
	ChartConfig : function(container, option) {//container:为页面要渲染图表的容器，option为已经初始化好的图表类型的option配置  

		option = {
			chart : {},
			option : option,
			container : container
		};

		return option;

	},//加载Echarts配置文件
	
	LabelFromatter : {
			FormateLabelPin : {
						normal : {
								label : {
									formatter : function (params){
										return  params.value+'('+params.percent + '%)'
									},
									textStyle: {
										baseline : 'top'
									}
								}
						}
				}
		},
		
	ChartDataFormate : {
		FormateNOGroupData : function(data) {//data的格式如上的Result1，这种格式的数据，多用于饼图、单一的柱形图的数据源  

			var categories = [];

			var datas = [];

			for (var i = 0; i < data.length; i++) {

				categories.push(data[i].name || "");

				datas.push({
					name : data[i].name,
					value : data[i].value || 0
				});

			}

			return {
				category : categories,
				data : datas
			};

		},
		
		FormateDBPieData : function(data) {//data的格式如上的Result1，这种格式的数据，多用于饼图、单一的柱形图的数据源  

			var categories = [];
			
			var outRings = [];
			var inRings = [];

			for (var i = 0; i < data.length; i++) {

				categories.push(data[i].name || "");
				
				if((data[i].group||"").indexOf('in')!=-1){
					inRings.push({
					name : data[i].name,
					value : data[i].value || 0
					});
				}else{
					outRings.push({
					name : data[i].name,
					value : data[i].value || 0
					});
				}

				
				

			}


			return {
				category : categories,
				inRing : inRings,
				outRing : outRings,
			};

		},

		FormateGroupData : function(data, type, is_stack) {//data的格式如上的Result2，type为要渲染的图表类型：可以为line，bar，is_stack表示为是否是堆积图，这种格式的数据多用于展示多条折线图、分组的柱图  

			var chart_type = 'line';

			if (type)

				chart_type = type || 'line';

			var xAxis = [];

			var group = [];

			var series = [];

			for (var i = 0; i < data.length; i++) {

				for (var j = 0; j < xAxis.length && xAxis[j] != data[i].name; j++)
					;

				if (j == xAxis.length)

					xAxis.push(data[i].name);

				for (var k = 0; k < group.length && group[k] != data[i].group; k++)
					;

				if (k == group.length)

					group.push(data[i].group);

			}

			for (var i = 0; i < group.length; i++) {

				var temp = [];

				for (var j = 0; j < data.length; j++) {

					if (group[i] == data[j].group) {

						temp.push(data[j].value);

					}

				}

				switch (type) {

				case 'bar':

					var series_temp = {
						name : group[i],
						data : temp,
						barMaxWidth : 20,
						barMinHeight: 1,
						type : chart_type,
						 markPoint : {
							data : [
								{type : 'max', name: '最大值'},
								{type : 'min', name: '最小值'}
							]
						},
						markLine : {
							data : [
								{type : 'average', name: '平均值'}
							]
						}
					};

					if (is_stack)

						series_temp = $.extend({}, {
							stack : 'stack'
						}, series_temp);

					break;
				case 'line':

					var series_temp = {
						name : group[i],
						data : temp,
						type : chart_type
					};

					if (is_stack)

						series_temp = $.extend({}, {
							stack : 'stack'
						}, series_temp);

					break;

				default:

					var series_temp = {
						name : group[i],
						data : temp,
						type : chart_type
					};

				}

				series.push(series_temp);

			}

			return {
				category : group,
				xAxis : xAxis,
				series : series
			};
		}
	},//数据格式化
	ChartOptionTemplates : {
		CommonOption : {//通用的图表基本配置  

			tooltip : {

				trigger : 'axis'//tooltip触发方式:axis以X轴线触发,item以每一个数据项触发  

			},

			toolbox : {

				show : true, //是否显示工具栏  

				feature : {

					mark : true,

					dataView : {
						readOnly : false
					}, //数据预览  

					restore : true, //复原  

					saveAsImage : true
				//是否保存图片  

				}

			}

		},

		CommonLineOption : {//通用的折线图表的基本配置  

			tooltip : {

				trigger : 'axis'

			},

			toolbox : {

				show : true,

				feature : {

					dataView : {
						readOnly : false
					}, //数据预览  

					restore : true, //复原  

					saveAsImage : true, //是否保存图片  

					magicType : [ 'line', 'bar' ]
				//支持柱形图和折线图的切换  

				}

			}

		},

		Pie : function(obj,data, name) {//data:数据格式：{name：xxx,value:xxx}...  

			var pie_datas = MyECharts.ChartDataFormate.FormateNOGroupData(data);

			var option = {
				color : [ 
						'#33C399', '#EF874F', '#5BB2D2', '#8493D0', '#EEBE61', 
						'#87D37A', '#EAD83D', '#ABC374', '#AA8C8A', '#E387BB', 
						'#E387BB'],
				//图表标题
				title: {
						text: name, //正标题开
						//x: obj.clientWidth*0.60-35, //标题水平方向位置
						x: "center", //标题水平方向位置
						//y: "center", //标题垂直方向位
						//正标题样式
						textStyle: {
							fontSize:20
						}
				},

				tooltip : {

					trigger : 'item',

					formatter : "{b}: {c} <br/> 占比:  {d}%" 

				},

				legend : {
					orient: 'horizontal',
			        bottom: '2px',
					data : pie_datas.category
				},
				
				calculable: true,

				series : [

				{

					name : name || "",

					type : 'pie',

					radius : [50, 80],
					center: ['50%', '40%'],
					itemStyle : MyECharts.LabelFromatter.FormateLabelPin,
					x: '60%',
					width: '35%',
					funnelAlign: 'left',
					max: 1048,
					

					data : pie_datas.data

				}

				]

			};

			return $.extend({}, MyECharts.ChartOptionTemplates.CommonOption,
					option);

		},
		DBPie : function(obj,data, title) {//双环data:数据格式：{name：xxx,value:xxx}...  

			var pie_datas = MyECharts.ChartDataFormate.FormateDBPieData(data);
			
			var subtext = '';
			if(title.indexOf(";") > 0){
				subtext = title.substr(title.indexOf(";")+1,title.length);
				title = title.indexOf(";") > 0 ? title.substr(0,title.indexOf(";")) : title;
			}			

			var option = {
				
				color : [ 
							'#33C399', '#EF874F', '#5BB2D2', '#8493D0', '#EEBE61', 
							'#87D37A', '#EAD83D', '#ABC374', '#AA8C8A', '#E387BB', 
							'#E387BB'],
				
				title : {
					text: title,
					subtext : subtext,
					x : 'center',
					textStyle : {
						fontSize : 20,
						fontFamily : '微软雅黑,宋体',
						fontWeight : 'normal'
					}
				},

				
				tooltip: {
					trigger: 'item',
					formatter : "{b}: {c} <br/> 占比:  {d}%" 
				},
				legend: {
					orient: 'vertical',
					x: 'left',
					data:pie_datas.category
				},
				toolbox: {
					show : false
				},

				  series: [
					{
						name:pie_datas.inRingName,
						type:'pie',
						selectedMode: 'single',
						radius: [0, '30%'],

						label: {
							normal: {
								position: 'inner'
							}
						},
						labelLine: {
							normal: {
								show: false
							}
						},
						data:pie_datas.inRing
					},
					{
						name:pie_datas.outRingName,
						type:'pie',
						radius: ['40%', '55%'],

						data:pie_datas.outRing
					}
				]

			};

			return $.extend({}, MyECharts.ChartOptionTemplates.CommonOption,
					option);

		},

		Lines : function(data, name, title,is_stack) { //data:数据格式：{name：xxx,group:xxx,value:xxx}...  

			var stackline_datas = MyECharts.ChartDataFormate.FormateGroupData(
					data, 'line', is_stack);
			var subtext = '';
			if(title.indexOf(";") > 0){
				subtext = title.substr(title.indexOf(";")+1,title.length);
				title = title.indexOf(";") > 0 ? title.substr(0,title.indexOf(";")) : title;
			}
			var option = {
				color : [ 
							'#33C399', '#EF874F', '#5BB2D2', '#8493D0', '#EEBE61', 
							'#87D37A', '#EAD83D', '#ABC374', '#AA8C8A', '#E387BB', 
							'#E387BB'],
				title : {
					text: title,
					subtext : subtext,
					x : 'center',
					textStyle : {
						fontSize : 20,
						fontFamily : '微软雅黑,宋体',
						fontWeight : 'normal'
					}
				},			
				legend : {
					orient: 'horizontal',
			        bottom: '2px',
					data : stackline_datas.category

				},
				toolbox: {
					show : true,
					feature : {
						mark : {show: false},
						dataView : {show: true, readOnly: false},
						magicType : {show: true, type: ['line', 'bar']},
						restore : {show: false},
						saveAsImage : {show: false}
					}
				},
				xAxis : [ {

					type : 'category', //X轴均为category，Y轴均为value  

					data : stackline_datas.xAxis,

					boundaryGap : false
				//数值轴两端的空白策略  

				} ],

				yAxis : [ {

					name : name || '',

					type : 'value',

					splitArea : {
						show : true
					}

				} ],

				series : stackline_datas.series

			};

			return $.extend({}, MyECharts.ChartOptionTemplates.CommonLineOption,
					option);

		},

		Bars : function(data, name, title,is_stack) {//data:数据格式：{name：xxx,group:xxx,value:xxx}...  

			var bars_dates = MyECharts.ChartDataFormate.FormateGroupData(data,
					'bar', is_stack);

			var legendShow = bars_dates.category.length > 1 ? true : false;
			var subtext = '';
			if(title.indexOf(";") > 0){
				subtext = title.substr(title.indexOf(";")+1,title.length);
				title = title.indexOf(";") > 0 ? title.substr(0,title.indexOf(";")) : title;
			}			
			var option = {
				color: [
				        '#42B3BF','#b6a2de','#5ab1ef','#ffb980','#d87a80',
				        '#8d98b3','#e5cf0d','#97b552','#95706d','#dc69aa',
				        '#07a2a4','#9a7fd1','#588dd5','#f5994e','#c05050',
				        '#59678c','#c9ab00','#7eb00a','#6f5553','#c14089'
				    ],
				    
				title : {
					text: title,
					subtext : subtext,
					x : 'center',
					textStyle : {
						fontSize : 20,
						fontFamily : '微软雅黑,宋体',
						fontWeight : 'normal'
					}
				},

				legend : {
					show : legendShow,
					orient: 'horizontal',
			        bottom: '2px',
					data:bars_dates.category
					},
				
				toolbox: {
					show : true,
					feature : {
						mark : {show: false},
						dataView : {show: true, readOnly: false},
						magicType : {show: true, type: ['line', 'bar']},
						restore : {show: true},
						saveAsImage : {show: false}
					}
				},
	
				calculable : true,
				
				xAxis : [ {

					type : 'category',

					data : bars_dates.xAxis

				} ],

				yAxis : [ {

					type : 'value'
					
						 }],

				series : bars_dates.series

			};

			return $.extend({}, MyECharts.ChartOptionTemplates.CommonLineOption,
					option);

		}
	},//初始化常用的图表类型
	
	Charts : {
		RenderChart : function(option) {

				if (option.chart && option.chart.dispose)

					option.chart.dispose();

				option.chart = echarts.init(option.container);

				window.onresize = option.chart.resize;

				option.chart.setOption(option.option);
				
				option.chart.setOption(option.option)
				
		}
	}
}