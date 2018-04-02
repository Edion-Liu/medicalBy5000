<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ include file="./../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>诊疗目录</title>
</head>
<body ontouchstart>
	<div class="container" id="container" >
		<div class="page  js_show" >
			 <div class="weui-search-bar" id="searchBar">
	           <input type="search" style="width: 80%;" id="searchText" placeholder="搜索" required/>
	           &nbsp&nbsp<button type="button" class="btn btn-success" id="searchBut"> <span class="glyphicon glyphicon-search"></span>搜索</button>
	        </div>
	    	
	    	<table id="drugTable" class="table table-striped ">
				<thead>
					<tr >
						<th>
							编码
						</th>
						<th>
							通用名称
						</th>
						<th>
							单位
						</th>
						<th>
							单价
						</th>
						
					</tr>
				</thead>
				<tbody >
					<tr>
						<td colspan="4" style="text-align: center;">
							暂无数据
						</td>
					</tr>
				</tbody>
			</table>
	        
		</div>
		
	</div>
    
<script type="text/javascript">
$(function(){
    var $searchText = $('#searchText'),
        $searchBut = $('#searchBut'),
        $drugTable = $('#drugTable');
	
    $searchBut.on('click',function(){
    	$.ajax({
            type: "GET",
            url: "${basepath}/ajax/common/treatment/data",
            data: {pageIndex:0,pageSize:10, generalName:$searchText.val()},
            dataType: "json",
            success: function(json){
            	if(json.status =='ok')
                    var data =  JSON.parse(json.data);
            		$drugTable.find('tbody').empty();
            		if(data.length>0){
            			for(var i =0 ; i < data.length ; i++){
                			$drugTable.find('tbody').append('<tr><td>'+data[i].code+'</td><td>'+data[i].generalName+'</td><td>'+data[i].unit+'</td><td>'+data[i].price+'</td></tr>');
                		}
            		}else{
            			$drugTable.find('tbody').append('<tr><td colspan="4" style="text-align: center;">暂无数据</td></tr>');
            		}
                }
        });
    });
    
});
	
</script>

</body>
</html>
