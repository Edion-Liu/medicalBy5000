<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>领导团队</title>
</head>
<body ontouchstart>
	<div class="container" id="container">
		<div class="page flex js_show" id='leaderMenu'>
	
	            	        	    	         
		</div>
	</div>

<script type="text/javascript">

    window.onload=function(){
        
    	initLeader();
	}
	
    function initLeader(){
		$.ajax({
            type: "GET",
            url: "${basepath}/ajax/common/getDorterMenu",
            data: {docterLavel:'1'},
            dataType: "json",
            success: function(json){
            	if(json.status =='ok'){
            		var menu_data =  JSON.parse(json.data);

                    $("#leaderMenu").empty();
                    var menuDiv = '';
                    var i = 0;
                    var n = 3;
               		for(;i< menu_data.length ; i++){
               				if(i%n==0){
               					menuDiv += '</div><div class="weui-flex profile_flex" >';	
                   			}
               				menuDiv += '<div class="weui-flex__item"><div class="placeholder menu outpatientPay" onClick="openUrl(\'${basepath}\',\''+getDate(menu_data[i].pageUrl,'/doctorprofile/doctorInfo')+'?docterId='+menu_data[i].id+'\',\''+menu_data[i].pageUrlType+'\')"><img src="./../../myres/img'+menu_data[i].photoPath+'" alt="" ><h4 class="title">'+menu_data[i].name+'</h4></div></div>';
               		}
                    while (i%n!=0){
                    	menuDiv += '<div class="weui-flex__item" style="background-color: #fff;"></div>';
            			i++
            		}
                    menuDiv += '</div>';
            		$("#leaderMenu").html(menuDiv);
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
