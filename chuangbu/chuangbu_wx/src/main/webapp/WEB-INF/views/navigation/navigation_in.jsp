<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	
	<title>院内导航</title>
</head>
<body ontouchstart>
	<div class="container" id="container">
		<div class="page js_show" >
			<div class="eChartsDiv">
				<div id="main" style="width:100%;height:550px;"></div>
			</div>
		</div>
	</div>

<script src="${basepath}/framework/echarts/jquery-1.7.2.min.js"></script>
<script src="${basepath}/framework/echarts/js/esl.js"></script>
<script type="text/javascript">

//路径配置
require.config({
    paths: {
        'echarts': '${basepath}/framework/echarts/js/echarts',
        'echarts/chart/map': '${basepath}/framework/echarts/js/echarts-map'
    }
});

// 使用
require(
    [
        'echarts',
        'echarts/chart/map' // 使用柱状图就加载bar模块，按需加载
    ],

    function (ec) {
        require('echarts/util/mapData/params').params.ship = {
            getGeoJson: function (callback) {
                $.ajax({
                    url: "<%=request.getContextPath() %>/framework/echarts/js/football.svg",
                    dataType: 'xml',
                    success: function (xml) {
                        callback(xml)
                    }
                });
            }
        }
        // 基于准备好的dom，初始化echarts图表
        var myChart = ec.init(document.getElementById('main'));

        var option = {
            /* backgroundColor: '#eee',*/
            title: {
                text: '院内就诊导航一层',
                x: 'center',
                textStyle: {
                    color: '#000'
                }
            },
            tooltip: {
                trigger: 'item',
                formatter: function (v) {
                    return v[1];
                }
            },
            color: ['rgba(117, 255, 117, 1)','rgba(218, 70, 214, 1)', 'rgba(100, 149, 237, 1)'],
            legend: {
                orient: 'vertical',
                x: 'right',
                y: '40px',
                data: ['正门','西侧门', '急诊入口']

            },
            toolbox: {
                show: true,
                feature: {
                    dataView: { show: true, readOnly: false },
                    restore: { show: true },
                    saveAsImage: { show: true }
                }
            },
            series: [
				{
                    name: '正门',
                    type: 'map',
                    mapType: 'ship',
                    roam: true,
                    itemStyle: {
                        normal: { label: { show: true } },
                        emphasis: { label: { show: true } }
                    },
                    data: [],
                    geoCoord: {
                        '急诊中心': [540, 92],
                        '影像中心': [170, 75],
                        '中西药房': [450, 145],
                        '收款处': [390, 180]
                    },
                    markPoint: {
                        symbolSize: 3,
                        data: [
                            { name: '急诊中心' },
                            { name: '影像中心' },
                            { name: '中西药房' },
                            { name: '收款处' }
                        ]
                    },
                    markLine: {
                        smooth: true,
                        effect: {
                            show: true,
                            scaleSize: 1,
                            period: 20,
                            color: '#fff',
                            shadowBlur: 5
                        },
                        symbol: ['none'],
                        itemStyle: {
                            normal: {
                                borderWidth: 1,
                                lineStyle: {
                                    type: 'solid'
                                }
                            }
                        },
                        data: [
                            [
                                { name: '正门' },
                                { name: '急诊中心' }
                            ],
                            [
                                { name: '正门' },
                                { name: '影像中心' }
                            ],
                            [
                                { name: '正门' },
                                { name: '中西药房' }
                            ],
                            [
                                { name: '正门' },
                                { name: '收款处' }
                            ]
                        ]
                    }
                
				},
				{
                    name: '西侧门',
                    type: 'map',
                    mapType: 'ship',
                    roam: true,
                    itemStyle: {
                        normal: { label: { show: true } },
                        emphasis: { label: { show: true } }
                    },
                    data: [],
                    geoCoord: {
                        '急诊中心': [540, 92],
                        '影像中心': [170, 75],
                        '中西药房': [450, 145],
                        '收款处': [390, 180]
                    },
                    markPoint: {
                        symbolSize: 3,
                        data: [
                            { name: '急诊中心' },
                            { name: '影像中心' },
                            { name: '中西药房' },
                            { name: '收款处' }
                        ]
                    },
                    markLine: {
                        smooth: true,
                        effect: {
                            show: true,
                            scaleSize: 1,
                            period: 20,
                            color: '#fff',
                            shadowBlur: 5
                        },
                        symbol: ['none'],
                        itemStyle: {
                            normal: {
                                borderWidth: 1,
                                lineStyle: {
                                    type: 'solid'
                                }
                            }
                        },
                        data: [
                            [
                                { name: '西侧门' },
                                { name: '急诊中心' }
                            ],
                            [
                                { name: '西侧门' },
                                { name: '影像中心' }
                            ],
                            [
                                { name: '西侧门' },
                                { name: '中西药房' }
                            ],
                            [
                                { name: '西侧门' },
                                { name: '收款处' }
                            ]
                        ]
                    }
                
				},
				{
                    name: '急诊入口',
                    type: 'map',
                    mapType: 'ship',
                    roam: true,
                    itemStyle: {
                        normal: { label: { show: true } },
                        emphasis: { label: { show: true } }
                    },
                    data: [],
                    geoCoord: {
                        '急诊中心': [540, 92],
                        '影像中心': [170, 75],
                        '中西药房': [450, 145],
                        '收款处': [390, 180]
                    },
                    markPoint: {
                        symbolSize: 3,
                        data: [
                            { name: '急诊中心' },
                            { name: '影像中心' },
                            { name: '中西药房' },
                            { name: '收款处' }
                        ]
                    },
                    markLine: {
                        smooth: true,
                        effect: {
                            show: true,
                            scaleSize: 1,
                            period: 20,
                            color: '#fff',
                            shadowBlur: 5
                        },
                        symbol: ['none'],
                        itemStyle: {
                            normal: {
                                borderWidth: 1,
                                lineStyle: {
                                    type: 'solid'
                                }
                            }
                        },
                        data: [
                            [
                                { name: '急诊入口' },
                                { name: '急诊中心' }
                            ],
                            [
                                { name: '急诊入口' },
                                { name: '影像中心' }
                            ],
                            [
                                { name: '急诊入口' },
                                { name: '中西药房' }
                            ],
                            [
                                { name: '急诊入口' },
                                { name: '收款处' }
                            ]
                        ]
                    }
                
				},
				{
                    type: 'map',
                    mapType: 'ship',
                    data: [],
                    geoCoord: {
                        '咨询服务台': [307, 133]
                    },
                    markPoint: {
                        symbol: 'emptyCircle',
                        symbolSize: 15,
                        effect: {
                            show: true,
                            color: 'rgba(117, 255, 117, 1)'
                        },
                        data: [
                            { name: '咨询服务台' }
                        ]
                    }
                },
				{
                    type: 'map',
                    mapType: 'ship',
                    data: [],
                    geoCoord: {
                        '正门': [307, 228]
                    },
                    markPoint: {
                        symbol: 'emptyCircle',
                        symbolSize: 10,
                        effect: {
                            show: true,
                            color: 'rgba(117, 255, 117, 1)'
                        },
                        data: [
                            { name: '正门' }
                        ]
                    }
                },
				{
                    type: 'map',
                    mapType: 'ship',
                    data: [],
                    geoCoord: {
                        '西侧门': [25, 115]
                    },
                    markPoint: {
                        symbol: 'emptyCircle',
                        symbolSize: 10,
                        effect: {
                            show: true,
                            color: 'rgba(218, 70, 214, 1)'
                        },
                        data: [
                            { name: '西侧门' }
                        ]
                    }
                },
				{
                    type: 'map',
                    mapType: 'ship',
                    data: [],
                    geoCoord: {
                        '急诊入口': [590, 105]
                    },
                    markPoint: {
                        symbol: 'emptyCircle',
                        symbolSize: 10,
                        effect: {
                            show: true,
                            color: 'rgba(100, 149, 237, 1)'
                        },
                        data: [
                            { name: '急诊入口' }
                        ]
                    }
                }
            ]
        };

        // 为echarts对象加载数据 
        myChart.setOption(option);
    }
);
                    
</script>

</body>
</html>