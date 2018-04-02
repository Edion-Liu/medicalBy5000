<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>医生简介</title>
    <link rel="stylesheet" href="./../framework/weui/style/weui.css"/>
    <link rel="stylesheet" href="./../css/theme_default.css"/>
</head>
<body ontouchstart>
	<div class="head_back">
	 	<span class="back" onclick="history.go(-1)">返回</span>
	 	医生简介
	 	<span class="refresh" onclick="location.reload()">刷新</span>
	 </div>
	<div class="container" id="container">
		<div class="page  js_show" >
			 <div class="weui-panel weui-panel_access">
	            <div class="weui-panel__bd">
	                <a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg">
	                    <div class="weui-media-box__hd">
	                        <img class="weui-media-box__thumb" src="./../myres/img/doctor/20141104170348_13061.jpg" alt="">
	                    </div>
	                    <div class="weui-media-box__bd">
	                        <h4 class="weui-media-box__title">陈 光 内科主任医师</h4>
	                        <p class="weui-media-box__desc">党总支书记、副院长，大学学历，毕业于吉林医学院，曾于北京大学附属第一医院进修神经内科。擅长高血压脑出血、脑梗塞及脑梗塞超早期溶栓治疗、格林巴利综合症、多发性神经根炎、癫痫、危重病人的抢救等神经内科疾病;心律失常、急性心梗的溶栓治疗、急性大面积心肌梗塞的抢救等心血管疾病的治疗。
<br><br>出诊时间:周一、二、四、五、周六上午 联系电话：0475-5212297、5212298</p>
	                    </div>
	                </a>
	              </div>
	            <div class="weui-panel__bd">
	                <a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg">
	                    <div class="weui-media-box__hd">
	                        <img class="weui-media-box__thumb" src="./../myres/img/doctor/20141104170451_17622.jpg" alt="">
	                    </div>
	                    <div class="weui-media-box__bd">
	                        <h4 class="weui-media-box__title">冯 涛 内科副主任医师</h4>
	                        <p class="weui-media-box__desc">副院长，大学本科学历，毕业于包头医学院。曾于北大一院心内科进修学习，擅长冠心病心绞痛、心肌梗塞的诊断及治疗，支架术后用药指导，高血压、各种心律失常、急慢性心力衰竭、脑血管疾病、高脂血症、代谢综合征等疾病的诊断和治疗。
<br><br>联系电话：0475-5215008、5212297 </p>
	                    </div>
	                </a>
	              </div>
	           </div>
	    	
            <%@include file="./../inc/tabbar.jsp"%>
		</div>
	</div>
    <script src="./framework/weui/js/weui.min.js"></script>
    
<script type="text/javascript">
    window.onload=function(){
      
	}
	
</script>

</body>
</html>
