<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>随访系统</title>
    <link rel="stylesheet" href="${basepath}/framework/bootstrap/css/bootstrap.css"/>
</head>

<body ontouchstart>
	<div class="container" id="container">
		<div class="page js_show" >
	        
	        <div class="page__bd" style="height: 100%;">
		        <div class="weui-tab">
		            <div class="weui-navbar">
		                <div class="weui-navbar__item weui-bar__item_on record">
		             		随访记录
		                </div>
		                <div class="weui-navbar__item query">
		                	随访查询
		                </div>
		            </div>
		            <div class="weui-tab__panel">
		            	<div id="record" >
		            		<div class="weui-cells__title">请完善红框信息</div>
					        <div class="weui-cells weui-cells_form">
					            <div class="weui-cell">
					                <div class="weui-cell__hd"><label class="weui-label mylabel">住院号</label></div>
					                <div class="weui-cell__bd">
					                    <input class="weui-input" type="text" pattern="[0-9]*" placeholder="请输入住院号"/>
					                </div>
					                <div class="weui-cell__ft">
					                    <a class="weui-btn weui-btn_plain-primary" href="javascript:" id="showTooltips">查询</a>
					                </div>
					            </div>
					        </div>
							<div class="weui-cells__title">患者信息</div>
					        <div class="weui-cells weui-cells_form">
					            <div class="weui-cell weui-cell_warn">
					                <div class="weui-cell__hd">
					                    <label class="weui-label">姓名</label>
					                </div>
					                <div class="weui-cell__bd">
					                    <input class="weui-input" type="tel" placeholder="请输入姓名">
					                </div>
					                <div class="weui-cell__ft">
					                    
					                </div>
					            </div>
					            <div class="weui-cell weui-cell_select weui-cell_select-after weui-cell_warn">
					                <div class="weui-cell__hd">
					                    <label class="weui-label">性别</label>
					                </div>
					                <div class="weui-cell__bd">
					                    <select class="weui-select" name="select2">
					                        <option value="0">男</option>
					                        <option value="1">女</option>
					                    </select>
					                </div>
					            </div>
					            <div class="weui-cell weui-cell_warn">
					                <div class="weui-cell__hd">
					                    <label class="weui-label">年龄</label>
					                </div>
					                <div class="weui-cell__bd">
					                    <input class="weui-input" type="text" pattern="[0-9]{0,3}" placeholder="请输入年龄"/>
					                </div>
					            </div>
					            <div class="weui-cell weui-cell_warn">
					                <div class="weui-cell__hd"><label for="" class="weui-label">出生日期</label></div>
					                <div class="weui-cell__bd">
					                    <input class="weui-input" type="date" value=""/>
					                </div>
					            </div>
					            <div class="weui-cell">
					                <div class="weui-cell__hd"><label class="weui-label mylabel">身份证</label></div>
					                <div class="weui-cell__bd">
					                    <input class="weui-input" type="text" pattern="[0-9]*" placeholder="请输入身份证号"/>
					                </div>
					            </div>
					            <div class="weui-cell">
					                <div class="weui-cell__hd"><label class="weui-label mylabel">录音文件</label></div>
						                <form method="POST" enctype="multipart/form-data" action="${basepath}/ajax/office/followUp/record/upload"> 
							                <div class="weui-cell__bd">
							                    <input type="file" name="file" />
							                </div>
						                	<input class="weui-btn weui-btn_plain-primary" type="submit" value="上传" />
								       </form>
					            </div>
					        </div>
					        
				        </div>
		            	<div id="query" style="display: none;">
		            		<table class="table table-hover table-bordered">
								<thead>
									<tr>
										<th>
											编号
										</th>
										<th>
											名称
										</th>
										<th>
											操作
										</th>
									</tr>
								</thead>
								<tbody id="queryBody"></tbody>
							</table>
						</div>
		            </div>
		        </div>
		    </div>
		    
			
		</div>
	</div>
    
<script type="text/javascript">
	
	
	$(function(){
	    $('.weui-navbar__item').on('click', function () {
	        $(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
	        if($(this).hasClass("query")){
	        	$("#record").hide();
	        	$("#query").show();
	        }else if($(this).hasClass("record")){
	        	$("#query").hide();
	        	$("#record").show();
	        }
	        var query = $("#queryBody").html(); 
	    	if(query == null || query.length == 0) {
	        	setQueryData();
	    	}
	    });
	    
	});
		
	function setQueryData(){
		$.ajax({
            type: "GET",
            url: "${basepath}/ajax/office/followUp/record/list",
            data: {pageSize:10,pageIndex:1,patientId:"123"},
            dataType: "json",
            success: function(json){
            	if(json.status =='ok'){
            		var query = $("#queryBody"); 
            		$(query).empty();
                    var data =  JSON.parse(json.data);
                    var tbody ="";
            		for(var i = 0 ; i < data.length ; i++){
            			if(i%2==0){
	            			tbody += "<tr >"
            			}else{
	            			tbody += "<tr class=\"success\" >"
            			}
	            		tbody += "<td>" +  (i+1) + "</td><td>" +  data[i].name + "</td><td> <span class=\"glyphicon glyphicon-headphones\"></span></td></tr>"
            		}
            		$(query).html(tbody);
                }
            }
        });
	}
</script>

</body>
</html>
