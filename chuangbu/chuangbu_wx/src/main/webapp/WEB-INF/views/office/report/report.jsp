<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>今日动态</title>
    <!-- 引入 ECharts 文件 -->
   <%-- <script src="static/framework/echarts/echarts.simple.min.js"></script>--%>
    <style type="text/css">
        .button {

            border-radius: 8px;
            color: #ffffff;
            font-size: 16px;
            background: #44c767;
            border: solid #18ab29 1px;
            text-align: center;

        }

        .button:hover {
            color: #ffffff;
            background: #5cbf2a;

        }
        .eChartsDiv{
            clear: both;
        }
    </style>
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
                                    <%--//全院日收入组成及分析--%>
                                    <div class="eChartsDiv">
                                        <div id="main0" style="height:80px;width: 100%;font-size: larger;text-align: center;">
                                        <img src="<%=request.getContextPath() %>/img/smooth-drop.png" style="height: 30px;width: 30px;"/>  全院日收入组成及分析
                                        </div>
                                    </div>
				                    <div class="eChartsDiv">
                                        <div id="main_left" style="width: 13%;height: 400px;border:0px solid #9ED99D;float: left;">
                                            <div class="button">科室分类</div>
                                            <div class="button">科目分类</div>
                                        </div>
										<div id="main1" style="height:400px;border:0px solid #F00;width: 87%;float: left;">

										</div>
                                        <div id="main_bottom" style="clear:both;height:20px;border:0px solid #178FE5;width: 100%;">
                                                 <div class="button" style="float: left;width: 50%;">独立显示</div>
                                                 <div class="button" style="float: left;width: 50%;">混合显示</div>
                                        </div>

									</div>
									<div class="eChartsDiv">
										<div id="main2" style="height:400px;border:0px solid #F00;width: 100%;float: left;">

										</div>
									</div>
									<div class="eChartsDiv">
										<div id="main3" style="height:400px;border:0px solid #F00;width: 100%;">

										</div>
                                        <div id="main3_bottom" style="clear:both;height:20px;border:0px solid #178FE5;width: 100%;">
                                            <div class="button" style="float: left;width: 50%;">独立显示</div>
                                            <div class="button" style="float: left;width: 50%;">混合显示</div>
                                        </div>
									</div>
                                    <div class="eChartsDiv">
                                        <div id="main4" style="height:400px;border:0px solid #F00;width: 100%;">

                                        </div>
                                    </div>
                                    <%-- //全院月收入组成及分析--%>
                                    <div class="eChartsDiv">
                                        <div id="main5" style="height:80px;width: 100%;font-size: larger;text-align: center;">
                                            <img src="<%=request.getContextPath() %>/img/smooth-drop.png" style="height: 30px;width: 30px;"/>  全院月收入组成及分析
                                        </div>
                                    </div>
                                    <div class="eChartsDiv">
                                        <div id="main_left_yue" style="width: 13%;height: 400px;border:0px solid #9ED99D;float: left;">
                                            <div class="button">科室分类</div>
                                            <div class="button">科目分类</div>
                                        </div>
                                        <div id="main1_yue" style="height:400px;border:0px solid #F00;width: 87%;float: left;">

                                        </div>
                                        <div id="main_bottom_yue" style="clear:both;height:20px;border:0px solid #178FE5;width: 100%;">
                                            <div class="button" style="float: left;width: 50%;">独立显示</div>
                                            <div class="button" style="float: left;width: 50%;">混合显示</div>
                                        </div>

                                    </div>
                                    <div class="eChartsDiv">
                                        <div id="main2_yue" style="height:400px;border:0px solid #F00;width: 100%;">

                                        </div>
                                    </div>
                                    <div class="eChartsDiv">
                                        <div id="main3_yue" style="height:400px;border:0px solid #F00;">

                                        </div>

                                    </div>
                                   <%-- //医技月收入组成及分析--%>
                                    <div class="eChartsDiv">
                                        <div id="main5_yiji" style="height:80px;width: 100%;font-size: larger;text-align: center;">
                                            <img src="<%=request.getContextPath() %>/img/smooth-drop.png" style="height: 30px;width: 30px;"/>  医技月收入组成及分析
                                        </div>
                                    </div>
                                    <div class="eChartsDiv">
                                        <div id="main_left_yiji" style="width: 13%;height: 400px;border:0px solid #9ED99D;float: left;">
                                            <div class="button">科室分类</div>
                                            <div class="button">仪器分类</div>
                                        </div>
                                        <div id="main1_yue_yiji" style="height:400px;border:0px solid #F00;width: 87%;float: left;">

                                        </div>
                                        <div id="main_bottom_yiji" style="clear:both;height:20px;border:0px solid #178FE5;width: 100%;">
                                            <div class="button" style="float: left;width: 50%;">独立显示</div>
                                            <div class="button" style="float: left;width: 50%;">混合显示</div>
                                        </div>

                                    </div>
                                    <div class="eChartsDiv">
                                        <div id="main2_yue_yiji" style="height:400px;border:0px solid #F00;width: 100%;">

                                        </div>
                                    </div>
                                    <div class="eChartsDiv">
                                        <div id="main3_yue_yiji" style="height:400px;border:0px solid #F00;">

                                        </div>

                                    </div>

                                   <%--  检验月收入组成及分析--%>
                                    <div class="eChartsDiv">
                                        <div id="main0_jianyan" style="height:80px;width: 100%;font-size: larger;text-align: center;">
                                            <img src="<%=request.getContextPath() %>/img/smooth-drop.png" style="height: 30px;width: 30px;"/>  检验月收入组成及分析
                                        </div>
                                    </div>
                                    <div class="eChartsDiv">
                                        <div id="main_left_jianyan" style="width: 13%;height: 400px;border:0px solid #9ED99D;float: left;">
                                            <div class="button">科室分类</div>
                                            <div class="button">科目分类</div>
                                        </div>
                                        <div id="main1_jianyan" style="height:400px;border:0px solid #F00;width: 87%;float: left;">

                                        </div>
                                        <div id="main_bottom_jianyan" style="clear:both;height:20px;border:0px solid #178FE5;width: 100%;">
                                            <div class="button" style="float: left;width: 50%;">独立显示</div>
                                            <div class="button" style="float: left;width: 50%;">混合显示</div>
                                        </div>

                                    </div>
                                    <div class="eChartsDiv">
                                        <div id="main2_jianyan" style="height:400px;border:0px solid #F00;width: 100%;float: left;">

                                        </div>
                                    </div>
                                    <div class="eChartsDiv">
                                        <div id="main3_jianyan" style="height:400px;border:0px solid #F00;width: 100%;">

                                        </div>
                                        <div id="main3_bottom_jianyan" style="clear:both;height:20px;border:0px solid #178FE5;width: 100%;">
                                            <div class="button" style="float: left;width: 50%;">独立显示</div>
                                            <div class="button" style="float: left;width: 50%;">混合显示</div>
                                        </div>
                                    </div>
                                    <%--门诊挂号人数月分析--%>
                                        <div id="main0_menzhen" style="clear:both;height:80px;width: 100%;font-size: larger;text-align: center;">
                                            <img src="<%=request.getContextPath() %>/img/smooth-drop.png" style="height: 30px;width: 30px;"/>  门诊挂号人数月分析
                                        </div>
                                     <div class="eChartsDiv">
                                            <div id="main2_menzhen" style="height:400px;border:0px solid #F00;width: 100%;">

                                            </div>
                                        </div>
                                      <%--入出院人数月分析--%>
                                        <div id="main0_ruchu" style="clear:both;height:80px;width: 100%;font-size: larger;text-align: center;">
                                            <img src="<%=request.getContextPath() %>/img/smooth-drop.png" style="height: 30px;width: 30px;"/>  入出院人数月分析
                                        </div>
                                        <div class="eChartsDiv">
                                            <div id="main2_ruchu" style="height:400px;border:0px solid #F00;width: 100%;">

                                            </div>
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
	$(document).ready(function() {
        InitChart();

		//initWin();
	});


    /**
     * edsion
     */
    function InitChart() {
        // 基于准备好的dom，初始化echarts实例
        var myChart_main1 = echarts.init(document.getElementById('main1'));
        var myChart_main2 = echarts.init(document.getElementById('main2'));
        var myChart_main3 = echarts.init(document.getElementById('main3'));
        var myChart_main4 = echarts.init(document.getElementById('main4'));

        /**
         * 日
        /**
         * 饼图 全院日收入组成
         */
        // 指定图表的配置项和数据
        option_main1 = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            title: {
                text: '全院日收入组成',
               // subtext: '虚构数据', //子标题
                left: 'center'
            },
            legend: {
                orient: 'horizontal',
                bottom:'20',
                data:['直达','营销','搜索','邮件','联盟','视频','百度','谷歌','必应','其他']
            },
            series: [
                {
                    name:'来源',
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
                    data:[
                        {value:335, name:'直达', selected:true},
                        {value:679, name:'营销'},
                        {value:1548, name:'搜索'}
                    ]
                },
                {
                    name:'来源',
                    type:'pie',
                    radius: ['40%', '55%'],
                    label: {
                        normal: {
                             formatter: '{b}:\n{c}\n({d}%)\n ',
                           /* formatter: function (val) {  //让series 中的文字进行换行
                               // alert("数据："+val.toString());
                                return val.name.split("").join("\n");
                            },*/

                            backgroundColor: '#eee',
                            borderColor: '#aaa',
                            borderWidth: 1,
                            borderRadius: 4,
                            // shadowBlur:3,
                            // shadowOffsetX: 2,
                            // shadowOffsetY: 2,
                            // shadowColor: '#999',
                            // padding: [0, 7],
                            rich: {
                                a: {
                                    color: '#999',
                                    lineHeight: 22,
                                    align: 'center'
                                },
                                // abg: {
                                //     backgroundColor: '#333',
                                //     width: '100%',
                                //     align: 'right',
                                //     height: 22,
                                //     borderRadius: [4, 4, 0, 0]
                                // },
                                hr: {
                                    borderColor: '#aaa',
                                    width: '100%',
                                    borderWidth: 0.5,
                                    height: 0
                                },
                                b: {
                                    fontSize: 16,
                                    lineHeight: 33
                                },
                                per: {
                                    color: '#eee',
                                    backgroundColor: '#334455',
                                    padding: [2, 4],
                                    borderRadius: 2
                                }
                            }
                        }
                    },
                    data:[
                        {value:335, name:'直达'},
                        {value:310, name:'邮件'},
                        {value:234, name:'联盟'},
                        {value:135, name:'视频'},
                        {value:1048, name:'百度'},
                        {value:251, name:'谷歌'},
                        {value:147, name:'必应'},
                        {value:102, name:'其他'}
                    ]
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart_main1.setOption(option_main1);

        /**
         * 全院日收入-曲线分析
         */
        option_main2 = {
            title: {
                text: '全院日收-曲线分析',
                // subtext: '虚构数据', //子标题
                // left: 'center'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                orient: 'horizontal',
                bottom:'20',
                data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '15%',
                containLabel: true
            },
            toolbox: {
                feature: {
                 //   saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['周一','周二','周三','周四','周五','周六','周日']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name:'邮件营销',
                    type:'line',
                    stack: '总量',
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'联盟广告',
                    type:'line',
                    stack: '总量',
                    data:[220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name:'视频广告',
                    type:'line',
                    stack: '总量',
                    data:[150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name:'直接访问',
                    type:'line',
                    stack: '总量',
                    data:[320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name:'搜索引擎',
                    type:'line',
                    stack: '总量',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };
        myChart_main2.setOption(option_main2);

        /**
         * 支出方式组成
         * @type {{tooltip: {trigger: string, formatter: string}, title: {text: string, left: string}, legend: {orient: string, bottom: string, data: [*]}, series: [*]}}
         */
        option_main3 = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            title: {
                text: '支付方式组成',
                // subtext: '虚构数据', //子标题
                left: 'center'
            },
            legend: {
                orient: 'horizontal',
                bottom:'20',
                data:['直达','营销','搜索','邮件','联盟','视频','百度','谷歌','必应','其他']
            },
            series: [
                {
                    name:'来源',
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
                    data:[
                        {value:335, name:'直达', selected:true},
                        {value:679, name:'营销'},
                        {value:1548, name:'搜索'}
                    ]
                },
                {
                    name:'来源',
                    type:'pie',
                    radius: ['40%', '55%'],
                    label: {
                        normal: {
                           formatter: '{b}:\n{c}\n({d}%)\n ',
                            backgroundColor: '#eee',
                            borderColor: '#aaa',
                            borderWidth: 1,
                            borderRadius: 4,
                            // shadowBlur:3,
                            // shadowOffsetX: 2,
                            // shadowOffsetY: 2,
                            // shadowColor: '#999',
                            // padding: [0, 7],
                            rich: {
                                a: {
                                    color: '#999',
                                    lineHeight: 22,
                                    align: 'center'
                                },
                                // abg: {
                                //     backgroundColor: '#333',
                                //     width: '100%',
                                //     align: 'right',
                                //     height: 22,
                                //     borderRadius: [4, 4, 0, 0]
                                // },
                                hr: {
                                    borderColor: '#aaa',
                                    width: '100%',
                                    borderWidth: 0.5,
                                    height: 0
                                },
                                b: {
                                    fontSize: 16,
                                    lineHeight: 33
                                },
                                per: {
                                    color: '#eee',
                                    backgroundColor: '#334455',
                                    padding: [2, 4],
                                    borderRadius: 2
                                }
                            }
                        }
                    },
                    data:[
                        {value:335, name:'直达'},
                        {value:310, name:'邮件'},
                        {value:234, name:'联盟'},
                        {value:135, name:'视频'},
                        {value:1048, name:'百度'},
                        {value:251, name:'谷歌'},
                        {value:147, name:'必应'},
                        {value:102, name:'其他'}
                    ]
                }
            ]
        };
        myChart_main3.setOption(option_main3);

        /**
         *  支出方式曲线
         * @type {{title: {text: string}, tooltip: {trigger: string}, legend: {data: [*]}, grid: {left: string, right: string, bottom: string, containLabel: boolean}, toolbox: {feature: {saveAsImage: {}}}, xAxis: {type: string, boundaryGap: boolean, data: [*]}, yAxis: {type: string}, series: [*]}}
         */
        option_main4 = {
            title: {
                text: '支付方式曲线分析',
                // subtext: '虚构数据', //子标题
                // left: 'center'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                orient: 'horizontal',
                bottom:'20',
                data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '15%',
                containLabel: true
            },
            toolbox: {
                feature: {
                  //  saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['周一','周二','周三','周四','周五','周六','周日']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name:'邮件营销',
                    type:'line',
                    stack: '总量',
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'联盟广告',
                    type:'line',
                    stack: '总量',
                    data:[220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name:'视频广告',
                    type:'line',
                    stack: '总量',
                    data:[150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name:'直接访问',
                    type:'line',
                    stack: '总量',
                    data:[320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name:'搜索引擎',
                    type:'line',
                    stack: '总量',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };
        myChart_main4.setOption(option_main4);


        /**
         * 全院月收入组成
         */
        var myChart_main1_yue = echarts.init(document.getElementById('main1_yue'));
        var myChart_main2_yue = echarts.init(document.getElementById('main2_yue'));
        var myChart_main3_yue = echarts.init(document.getElementById('main3_yue'));

        /**
         * 饼图 全院月收入组成
         */
        // 指定图表的配置项和数据
        option_main1_yue = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            title: {
                text: '全院月收入组成',
                // subtext: '虚构数据', //子标题
                left: 'center'
            },
            legend: {
                orient: 'horizontal',
                bottom:'20',
                data:['直达','营销','搜索','邮件','联盟','视频','百度','谷歌','必应','其他']
            },
            series: [
                {
                    name:'来源',
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
                    data:[
                        {value:335, name:'直达', selected:true},
                        {value:679, name:'营销'},
                        {value:1548, name:'搜索'}
                    ]
                },
                {
                    name:'来源',
                    type:'pie',
                    radius: ['40%', '55%'],
                    label: {
                        normal: {
                            formatter:  '{b}:\n{c}\n({d}%)\n ',
                            backgroundColor: '#eee',
                            borderColor: '#aaa',
                            borderWidth: 1,
                            borderRadius: 4,
                            // shadowBlur:3,
                            // shadowOffsetX: 2,
                            // shadowOffsetY: 2,
                            // shadowColor: '#999',
                            // padding: [0, 7],
                            rich: {
                                a: {
                                    color: '#999',
                                    lineHeight: 22,
                                    align: 'center'
                                },
                                // abg: {
                                //     backgroundColor: '#333',
                                //     width: '100%',
                                //     align: 'right',
                                //     height: 22,
                                //     borderRadius: [4, 4, 0, 0]
                                // },
                                hr: {
                                    borderColor: '#aaa',
                                    width: '100%',
                                    borderWidth: 0.5,
                                    height: 0
                                },
                                b: {
                                    fontSize: 16,
                                    lineHeight: 33
                                },
                                per: {
                                    color: '#eee',
                                    backgroundColor: '#334455',
                                    padding: [2, 4],
                                    borderRadius: 2
                                }
                            }
                        }
                    },
                    data:[
                        {value:335, name:'直达'},
                        {value:310, name:'邮件'},
                        {value:234, name:'联盟'},
                        {value:135, name:'视频'},
                        {value:1048, name:'百度'},
                        {value:251, name:'谷歌'},
                        {value:147, name:'必应'},
                        {value:102, name:'其他'}
                    ]
                }
            ]
        };
        /*
        *    使用刚指定的配置项和数据显示图表。
        * */
        myChart_main1_yue.setOption(option_main1_yue);
        /**
         * 全院月收入-曲线分析
         */
        option_main2_yue = {
            title: {
                text: '全院月收入-曲线分析',
                // subtext: '虚构数据', //子标题
                // left: 'center'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                orient: 'horizontal',
                bottom:'20',
                data:['邮件','联盟','视频','直接','搜索']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '15%',
                containLabel: true
            },
            toolbox: {
                feature: {
                 //   saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['周一','周二','周三','周四','周五','周六','周日']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name:'邮件',
                    type:'line',
                    stack: '总量',
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'联盟',
                    type:'line',
                    stack: '总量',
                    data:[220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name:'视频',
                    type:'line',
                    stack: '总量',
                    data:[150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name:'直接',
                    type:'line',
                    stack: '总量',
                    data:[320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name:'搜索',
                    type:'line',
                    stack: '总量',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };
        myChart_main2_yue.setOption(option_main2_yue);
        /**
         * 13年和14年全院月收入同环比分析
         */
        option_main3_yue = {
            title: {
                text: '13年和14年全院月收入同环比分析',
                // subtext: '虚构数据', //子标题
                left: 'left'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    crossStyle: {
                        color: '#999'
                    }
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '15%',
                containLabel: true
            },
//            toolbox: {
//                feature: {
//                    dataView: {show: true, readOnly: false},
//                    magicType: {show: true, type: ['line', 'bar']},
//                    restore: {show: true},
//                    saveAsImage: {show: true}
//                }
//            },
            legend: {
                orient: 'horizontal',
                bottom:'20',
                data:['蒸发量','降水量','平均温度']
            },
            xAxis: [
                {
                    type: 'category',
                    data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
                    axisPointer: {
                        type: 'shadow'
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '水量',
                    min: 0,
                    max: 250,
                    interval: 50,
                    axisLabel: {
                        formatter: '{value} ml'
                    }
                },
                {
                    type: 'value',
                    name: '温度',
                    min: 0,
                    max: 25,
                    interval: 5,
                    axisLabel: {
                        formatter: '{value} °C'
                    }
                }
            ],
            series: [
                {
                    name:'蒸发量',
                    type:'bar',
                    data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
                },
                {
                    name:'降水量',
                    type:'bar',
                    data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
                },
                {
                    name:'平均温度',
                    type:'line',
                    yAxisIndex: 1,
                    data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
                }
            ]
        };
        myChart_main3_yue.setOption(option_main3_yue);


        /**
         * 医技月收入组成及分析
         */
        var myChart_main1_yue_yiji = echarts.init(document.getElementById('main1_yue_yiji'));
        var myChart_main2_yue_yiji = echarts.init(document.getElementById('main2_yue_yiji'));
        var myChart_main3_yue_yiji = echarts.init(document.getElementById('main3_yue_yiji'));

        option_main1_yue_yiji = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            title: {
                text: '医技月收入组成',
                // subtext: '虚构数据', //子标题
                left: 'center'
            },
            legend: {
                orient: 'horizontal',
                bottom:'20',
                data:['直达','营销','搜索','邮件','联盟','视频','百度','谷歌','必应','其他']
            },
            series: [
                {
                    name:'来源',
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
                    data:[
                        {value:335, name:'直达', selected:true},
                        {value:679, name:'营销'},
                        {value:1548, name:'搜索'}
                    ]
                },
                {
                    name:'来源',
                    type:'pie',
                    radius: ['40%', '55%'],
                    label: {
                        normal: {
                            formatter:  '{b}:\n{c}\n({d}%)\n ',
                            backgroundColor: '#eee',
                            borderColor: '#aaa',
                            borderWidth: 1,
                            borderRadius: 4,
                            // shadowBlur:3,
                            // shadowOffsetX: 2,
                            // shadowOffsetY: 2,
                            // shadowColor: '#999',
                            // padding: [0, 7],
                            rich: {
                                a: {
                                    color: '#999',
                                    lineHeight: 22,
                                    align: 'center'
                                },
                                // abg: {
                                //     backgroundColor: '#333',
                                //     width: '100%',
                                //     align: 'right',
                                //     height: 22,
                                //     borderRadius: [4, 4, 0, 0]
                                // },
                                hr: {
                                    borderColor: '#aaa',
                                    width: '100%',
                                    borderWidth: 0.5,
                                    height: 0
                                },
                                b: {
                                    fontSize: 16,
                                    lineHeight: 33
                                },
                                per: {
                                    color: '#eee',
                                    backgroundColor: '#334455',
                                    padding: [2, 4],
                                    borderRadius: 2
                                }
                            }
                        }
                    },
                    data:[
                        {value:335, name:'直达'},
                        {value:310, name:'邮件'},
                        {value:234, name:'联盟'},
                        {value:135, name:'视频'},
                        {value:1048, name:'百度'},
                        {value:251, name:'谷歌'},
                        {value:147, name:'必应'},
                        {value:102, name:'其他'}
                    ]
                }
            ]
        };
        myChart_main1_yue_yiji.setOption(option_main1_yue_yiji);
        option_main2_yue_yiji = {
            title: {
                text: '医技月收入-曲线分析',
                // subtext: '虚构数据', //子标题
                // left: 'center'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                orient: 'horizontal',
                bottom:'20',
                data:['邮件','联盟','视频','直接','搜索']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '15%',
                containLabel: true
            },
            toolbox: {
                feature: {
                  //  saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['周一','周二','周三','周四','周五','周六','周日']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name:'邮件',
                    type:'line',
                    stack: '总量',
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'联盟',
                    type:'line',
                    stack: '总量',
                    data:[220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name:'视频',
                    type:'line',
                    stack: '总量',
                    data:[150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name:'直接',
                    type:'line',
                    stack: '总量',
                    data:[320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name:'搜索',
                    type:'line',
                    stack: '总量',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };
        myChart_main2_yue_yiji.setOption(option_main2_yue_yiji);
        option_main3_yue_yiji = {
            title: {
                text: '13年和14年医技月收入同环比分析',
                // subtext: '虚构数据', //子标题
                left: 'left'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    crossStyle: {
                        color: '#999'
                    }
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '15%',
                containLabel: true
            },
//            toolbox: {
//                feature: {
//                    dataView: {show: true, readOnly: false},
//                    magicType: {show: true, type: ['line', 'bar']},
//                    restore: {show: true},
//                    saveAsImage: {show: true}
//                }
//            },
            legend: {
                orient: 'horizontal',
                bottom:'20',
                data:['蒸发量','降水量','平均温度']
            },
            xAxis: [
                {
                    type: 'category',
                    data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
                    axisPointer: {
                        type: 'shadow'
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '水量',
                    min: 0,
                    max: 250,
                    interval: 50,
                    axisLabel: {
                        formatter: '{value} ml'
                    }
                },
                {
                    type: 'value',
                    name: '温度',
                    min: 0,
                    max: 25,
                    interval: 5,
                    axisLabel: {
                        formatter: '{value} °C'
                    }
                }
            ],
            series: [
                {
                    name:'蒸发量',
                    type:'bar',
                    data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
                },
                {
                    name:'降水量',
                    type:'bar',
                    data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
                },
                {
                    name:'平均温度',
                    type:'line',
                    yAxisIndex: 1,
                    data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
                }
            ]
        };
        myChart_main3_yue_yiji.setOption(option_main3_yue_yiji);


        /**
         * 检验月收入组成及分析
         */
        var myChart_main1_jianyan = echarts.init(document.getElementById('main1_jianyan'));
        var myChart_main2_jianyan = echarts.init(document.getElementById('main2_jianyan'));
        var myChart_main3_jianyan = echarts.init(document.getElementById('main3_jianyan'));

        option_main1_jianyan = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            title: {
                text: '检验月收入组成',
                // subtext: '虚构数据', //子标题
                left: 'center'
            },
            legend: {
                orient: 'horizontal',
                bottom:'20',
                data:['直达','营销','搜索','邮件','联盟','视频','百度','谷歌','必应','其他']
            },
            series: [
                {
                    name:'来源',
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
                    data:[
                        {value:335, name:'直达', selected:true},
                        {value:679, name:'营销'},
                        {value:1548, name:'搜索'}
                    ]
                },
                {
                    name:'来源',
                    type:'pie',
                    radius: ['40%', '55%'],
                    label: {
                        normal: {
                            formatter:  '{b}:\n{c}\n({d}%)\n ',
                            backgroundColor: '#eee',
                            borderColor: '#aaa',
                            borderWidth: 1,
                            borderRadius: 4,
                            // shadowBlur:3,
                            // shadowOffsetX: 2,
                            // shadowOffsetY: 2,
                            // shadowColor: '#999',
                            // padding: [0, 7],
                            rich: {
                                a: {
                                    color: '#999',
                                    lineHeight: 22,
                                    align: 'center'
                                },
                                // abg: {
                                //     backgroundColor: '#333',
                                //     width: '100%',
                                //     align: 'right',
                                //     height: 22,
                                //     borderRadius: [4, 4, 0, 0]
                                // },
                                hr: {
                                    borderColor: '#aaa',
                                    width: '100%',
                                    borderWidth: 0.5,
                                    height: 0
                                },
                                b: {
                                    fontSize: 16,
                                    lineHeight: 33
                                },
                                per: {
                                    color: '#eee',
                                    backgroundColor: '#334455',
                                    padding: [2, 4],
                                    borderRadius: 2
                                }
                            }
                        }
                    },
                    data:[
                        {value:335, name:'直达'},
                        {value:310, name:'邮件'},
                        {value:234, name:'联盟'},
                        {value:135, name:'视频'},
                        {value:1048, name:'百度'},
                        {value:251, name:'谷歌'},
                        {value:147, name:'必应'},
                        {value:102, name:'其他'}
                    ]
                }
            ]
        };
        myChart_main1_jianyan.setOption(option_main1_jianyan);
        option_main2_jianyan = {
            title: {
                text: '检验月收入-曲线分析',
                // subtext: '虚构数据', //子标题
                // left: 'center'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                orient: 'horizontal',
                bottom:'20',
                data:['邮件','联盟','视频','直接','搜索']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '15%',
                containLabel: true
            },
            toolbox: {
                feature: {
                   // saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['周一','周二','周三','周四','周五','周六','周日']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name:'邮件',
                    type:'line',
                    stack: '总量',
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'联盟',
                    type:'line',
                    stack: '总量',
                    data:[220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name:'视频',
                    type:'line',
                    stack: '总量',
                    data:[150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name:'直接',
                    type:'line',
                    stack: '总量',
                    data:[320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name:'搜索',
                    type:'line',
                    stack: '总量',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };
        myChart_main2_jianyan.setOption(option_main2_jianyan);
        option_main3_jianyan = {
            title: {
                text: '13年和14年检验月收入同环比分析',
                // subtext: '虚构数据', //子标题
                left: 'left'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    crossStyle: {
                        color: '#999'
                    }
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '15%',
                containLabel: true
            },
//            toolbox: {
//                feature: {
//                    dataView: {show: true, readOnly: false},
//                    magicType: {show: true, type: ['line', 'bar']},
//                    restore: {show: true},
//                    saveAsImage: {show: true}
//                }
//            },
            legend: {
                orient: 'horizontal',
                bottom:'20',
                data:['蒸发量','降水量','平均温度']
            },
            xAxis: [
                {
                    type: 'category',
                    data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
                    axisPointer: {
                        type: 'shadow'
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '水量',
                    min: 0,
                    max: 250,
                    interval: 50,
                    axisLabel: {
                        formatter: '{value} ml'
                    }
                },
                {
                    type: 'value',
                    name: '温度',
                    min: 0,
                    max: 25,
                    interval: 5,
                    axisLabel: {
                        formatter: '{value} °C'
                    }
                }
            ],
            series: [
                {
                    name:'蒸发量',
                    type:'bar',
                    data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
                },
                {
                    name:'降水量',
                    type:'bar',
                    data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
                },
                {
                    name:'平均温度',
                    type:'line',
                    yAxisIndex: 1,
                    data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
                }
            ]
        };
        myChart_main3_jianyan.setOption(option_main3_jianyan);


        /**
         * 门诊挂号人数月分析
         */
        var myChart_main2_menzhen = echarts.init(document.getElementById('main2_menzhen'));
        option_main2_menzhen = {
            title: {
                text: '门诊挂号人数月分析',
                // subtext: '虚构数据', //子标题
                // left: 'center'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                orient: 'horizontal',
                bottom:'20',
                data:['邮件','联盟','视频','直接','搜索']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '15%',
                borderWidth:'0',
                containLabel: true
            },
            toolbox: {
                feature: {
                 //   saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['周一','周二','周三','周四','周五','周六','周日']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name:'邮件',
                    type:'line',
                    stack: '总量',
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'联盟',
                    type:'line',
                    stack: '总量',
                    data:[220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name:'视频',
                    type:'line',
                    stack: '总量',
                    data:[150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name:'直接',
                    type:'line',
                    stack: '总量',
                    data:[320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name:'搜索',
                    type:'line',
                    stack: '总量',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };
        myChart_main2_menzhen.setOption(option_main2_menzhen);

        /**
         * 入出院人数月分析
         */
        var myChart_main2_ruchu = echarts.init(document.getElementById('main2_ruchu'));
        option_ruchu = {
            title: {
                text: '入出院人数月分析',
                // subtext: '虚构数据', //子标题
                // left: 'center'
            },
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                orient: 'horizontal',
                right:'0',
                data:['利润', '支出', '收入']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            yAxis : [
                {
                    type : 'value'
                }
            ],
            xAxis : [
                {
                    type : 'category',
                    axisTick : {show: false},
                    data : ['周一','周二','周三','周四','周五','周六','周日']
                }
            ],
            series : [
                {
                    name:'利润',
                    type:'bar',
                    label: {
                        normal: {
                         //   show: true,
                        //    position: 'inside'
                        }
                    },
                    data:[200, 170, 240, 244, 200, 220, 210]
                },
                {
                    name:'收入',
                    type:'bar',
                    stack: '总量',
                    label: {
                        normal: {
                           // show: true
                        }
                    },
                    data:[320, 302, 341, 374, 390, 450, 420]
                },
                {
                    name:'支出',
                    type:'bar',
                    stack: '总量',
                    label: {
                        normal: {
                           // show: true,
                           // position: 'left'
                        }
                    },
                    data:[-120, -132, -101, -134, -190, -230, -210]
                }
            ]
        };
        myChart_main2_ruchu.setOption(option_ruchu);
    }



</script>

</body>
</html>
