<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>加解密</title>
</head>
<body ontouchstart>
	<div class="container" id="container">
		<div class="page  js_show" >
			<div class="page__bd">
		        <div class="weui-cells weui-cells_form">
		            <div class="weui-cell">
		                <div class="weui-cell__hd"><label class="weui-label">加解密内容</label></div>
		                <div class="weui-cell__bd">
		                    <textarea id="content" class="weui-textarea" placeholder="请输入文本" rows="3"></textarea>
		                </div>
		            </div>
		            <div class="weui-cell weui-cell_switch">
		                <div class="weui-cell__bd">是否加密</div>
		                <div class="weui-cell__ft">
		                    <label for="switchCP" class="weui-switch-cp">
		                        <input id="switchCP" class="weui-switch-cp__input" value="yes" type="checkbox" checked="checked" />
		                        <div class="weui-switch-cp__box"></div>
		                    </label>
		                </div>
		            </div>
		            <div class="weui-btn-area">
			            <a class="weui-btn weui-btn_primary" href="javascript:" id="confirmBut">确定</a>
			        </div>
			        <div class="weui-cell">
		                <div class="weui-cell__hd"><label class="weui-label">加解密结果</label></div>
		                <div class="weui-cell__bd">
		                    <textarea id="result" class="weui-textarea" placeholder="请输入文本" rows="3"></textarea>
		                </div>
		            </div>
		        </div>
   		 </div>
	    	
		</div>
	</div>
    <script src="<%=request.getContextPath() %>/framework/weui/js/zepto.min.js"></script>
    
<script type="text/javascript">
    $(function(){
    	$("#confirmBut").click(function(){
    		$.ajax({
    			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                type:"GET", //请求方式  
                url:"<%=request.getContextPath() %>/ajax/common/encryption", //请求路径  
                cache: false,     
                data:{isEncry:$("#switchCP").val(),content:$("#content").val()},  //传参  
                dataType: 'json',   //返回值类型  
               success:function(jsonData){
    				if(jsonData.status=='ok'){
    					$("#result").val(jsonData.data);
    				}else{
    					alert("请求失败");  
    				}
                }
                });
    	});
    	
    	$("#switchCP").click(function(){
    		if($("#switchCP").val()=="no"){
    			$("#switchCP").val("yes");
    		}else{
    			$("#switchCP").val("no");
    		}
    	});
    })
	
</script>

</body>
</html>
