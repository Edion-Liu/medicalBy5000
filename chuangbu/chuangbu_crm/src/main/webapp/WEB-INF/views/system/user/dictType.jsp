<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>系统字典</title>
	
	<link rel="stylesheet" href="<%=request.getContextPath() %>/framework/bootstrap-table/css/bootstrap-table.css">

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="<%=request.getContextPath() %>/framework/bootstrap-table/js/bootstrap-table.js"></script>
	<script src="<%=request.getContextPath() %>/framework/bootstrap-table/js/bootstrap-table-zh-CN.js"></script>
</head>
<body>
	
	<div class="search-div">
		<div class="form-group col-md-12">
			<div class="form-group">
<!-- 				<a type="button" class="btn btn-warning btn-add"  href="#" ><i class="glyphicon glyphicon-plus-sign"></i>&nbsp;添&nbsp;加</a> -->
<!-- 				<a type="button" class="btn btn-danger btn-remove"  href="#" ><i class="glyphicon glyphicon-trash"></i>&nbsp;删&nbsp;除</a> -->
<!-- 				<a type="button" class="btn btn-info btn-refresh"  href="#" ><i class="glyphicon glyphicon-refresh"></i>&nbsp;刷&nbsp;新</a> -->
				<a type="button" class="btn btn-success btn-search"  href="#" ><i class="glyphicon glyphicon-search"></i>&nbsp;查&nbsp;询</a>
			</div>
		</div>
	</div>
	
	<div class="table-responsive col-md-12">
		<table  id="dictTypeList" data-toolbar="toolbar">
		   
		</table>
		
	</div>
	
	<script type="text/javascript">
$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init(); 

    //2.初始化Button的点击事件
    /* var oButtonInit = new ButtonInit();
    oButtonInit.Init(); */

    $('.search-div').find('.btn-search').click(function() {
    	 $('#dictTypeList').bootstrapTable('refresh');
    });
    $('.search-div').find('.btn-refresh').click(function() {
    	 $('#dictTypeList').bootstrapTable('refresh');
    });
    
    $('.search-div').find('.btn-remove').click(function() {
    	 var ids =  $.map($('#dictTypeList').bootstrapTable('getSelections'), function (row) {
 	        return row.id
 	    });
    	 if(ids == null || ids.length==0){
    		 $.alert({
 			    title: '提示信息',
 			    content: '请选择需要删除的数据!',
 			    confirm: function(){
 			    	return false;
 			    }
 			});
    	 }else{
    		 removeDictType(ids);
    		 $('#dictTypeList').bootstrapTable('refresh');
    	 }
    });
    
    setTimeout('winResize()',300);
});

function winResize(){
	$('#dictTypeList').bootstrapTable('resetView', {
        height: getHeight()-80
    });
}

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
    	$('#dictTypeList').bootstrapTable({
            url: '<%=request.getContextPath() %>/ajax/sysDictType/getData',
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
           	pagination:true,
           	showFooter:false,
            checkboxHeader: true,
           	sidePagination:"server",
            queryParams: oTableInit.queryParams,//传递参数（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 15,                       //每页的记录行数（*）
            pageList: [15, 25, 50, 100],        //可供选择的每页的行数（*）
            columns: [{
            field: 'state',
            checkbox: true,
            align: 'center',
            valign: 'middle'
          },{field: 'id',title: 'id',visible:false}, 
            {field: 'typename',title: '字典类型名称'},
        	{field: 'typesign',title: '字典类型编码'}]
        });
    };

    //得到查询的参数
  oTableInit.queryParams = function (params) {
	  	var p_pageIndex = params.offset==0?1:params.offset/params.limit+1
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        	pageSize: params.limit,   //页面大小
        	pageIndex: p_pageIndex,  //页码
        };
        return temp;
  };
    return oTableInit;
}; 

function removeDictType(ids){
	var url = '<%=request.getContextPath() %>/ajax/sysDictType/remove';
	var data = {"ids":ids+''};
	var succ = function (json){
		if(json.status=='ok'){
			$.alert({
 			    title: '提示信息',
 			    content: '删除成功!',
 			    confirm: function(){
 			    	return false;
 			    }
 			});
		}
	}
	goGET(url,data,succ);
}
</script>

</body>

</html>