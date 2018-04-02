<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>医生简介</title>
</head>
<body ontouchstart>
	
	<div class="container" id="container">
		<div class="page js_show" >
	
	        <div class="weui-flex doctor-flex" >
	            <div class="weui-flex__item"><div class="placeholder">
					<h4>姓名：<span id="docterName"></span></h4>
					<h4>科室：<span id="docterDeptName"></span></h4>
					<h4>职称：<span id="docterTitle"></span></h4>
					<h4>职务：<span id="docterPosition"></span></h4>
				</div></div>
	            <div class="weui-flex__item"><div class="placeholder">
					<img src="" alt="" id="docterPhotoPath">
				</div></div>
	        </div>
	        <div class="weui-flex doctor-flex" >
	            <div class="weui-flex__item"><div class="placeholder">
					<h4>擅长：<span id="docterSpecialty"></span></h4>
				</div></div>
	        </div>
	        
			<article class="weui-article">
	            <section>
	            	<h4 class="title">【个人简介】</h4>
                    <p id="docterSynopsis"></p>
	            	<h4 class="title">【出诊时间】</h4>
                    <p id="docterVisitInfo"></p>
	            	<h4 class="title">【科研成果】</h4>
                    <p id="docterAchievements"></p>
	            	<h4 class="title">【发表文章】</h4>
                    <p id="docterPublishAnArticle"></p>
	            </section>
	                
	        </article>
	        
		</div>
	</div>
    
<script type="text/javascript">
window.onload=function(){ 
	initDocterInfo();
}

function initDocterInfo(){
	$.ajax({
        type: "GET",
        url: "${basepath}/ajax/common/getDorterData",
        data: {docterId:'${docterId}'},
        dataType: "json",
        success: function(json){
        	if(json.status =='ok'){
        		var info_data =  JSON.parse(json.data);
        		
        		$(document).attr("title",'医生简介--'+getDate(info_data.name,''))
        		$("#head_title").text('医生简介--'+getDate(info_data.name,''));
        		
        		$("#docterName").html(getDate(info_data.name,''));
        		$("#docterDeptName").html(getDate(info_data.deptName,''));
        		$("#docterTitle").html(getDate(info_data.title,''));
        		$("#docterPosition").html(getDate(info_data.position,''));
        		$("#docterPhotoPath").attr('src','./../../myres/img/'+info_data.photoPath);
        		$("#docterSpecialty").html(getDate(info_data.specialty,'暂无'));
        		$("#docterSynopsis").html(getDate(info_data.synopsis,'暂无'));
        		$("#docterVisitInfo").html(getDate(info_data.visitInfo,'暂无'));
        		$("#docterAchievements").html(getDate(info_data.achievements,'暂无'));
        		$("#docterPublishAnArticle").html(getDate(info_data.publishAnArticle,'暂无'));
           		
        	}
        }
	})
}

function getDate(str,def){
	return isStrNULL(str) ? def:str;
}
</script>
</body>
</html>
