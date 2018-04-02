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
	<script src="<%=request.getContextPath() %>/js/table/MyTable.js"></script>
</head>
<body>
	
	<div class="table-responsive col-md-12">
        <div id="dictTypeList_toolbar">
        	<label style="font-size: 20px;margin-right: 20px;">系统字典类型列表</label>
	        <a href="javascript:void(0);" class="btn btn-warning btn-add" ><i class="glyphicon glyphicon-plus-sign"></i>&nbsp;添&nbsp;加</a>
	        <a href="javascript:void(0);" class="btn btn-primary btn-edit" ><i class="glyphicon glyphicon-edit"></i>&nbsp;编&nbsp;辑</a>
	        <a href="javascript:void(0);" class="btn btn-danger btn-remove" ><i class="glyphicon glyphicon-trash"></i>&nbsp;删&nbsp;除</a>
	        <a href="javascript:void(0);" class="btn btn-success btn-refresh" ><i class="glyphicon glyphicon-refresh"></i>&nbsp;刷&nbsp;新</a>
        </div>
		<table  id="dictTypeList" data-toolbar="toolbar">
		   
		</table>
	</div>
	<div class="table-responsive col-md-12">
        <div id="dictItemList_toolbar">
        	<label style="font-size: 20px;margin-right: 20px;">系统字典列表</label>
	        <a href="javascript:void(0);" class="btn btn-warning btn-add" ><i class="glyphicon glyphicon-plus-sign"></i>&nbsp;添&nbsp;加</a>
	        <a href="javascript:void(0);" class="btn btn-primary btn-edit" ><i class="glyphicon glyphicon-edit"></i>&nbsp;编&nbsp;辑</a>
	        <a href="javascript:void(0);" class="btn btn-danger btn-remove" ><i class="glyphicon glyphicon-trash"></i>&nbsp;删&nbsp;除</a>
	        <a href="javascript:void(0);" class="btn btn-success btn-refresh" ><i class="glyphicon glyphicon-refresh"></i>&nbsp;刷&nbsp;新</a>
        </div>
		<table  id="dictItemList" data-toolbar="toolbar">
		   
		</table>
	</div>
	

	
<script type="text/javascript">
$(function () {
    //1.初始化Table
    var dictTypeOption = myTableOption;
    dictTypeOption.tableId = "dictTypeList";
    dictTypeOption.url = "/ajax/sysDictType/getData";
    dictTypeOption.columns = [{
        field: 'state',
        checkbox: true,
        align: 'center',
        valign: 'middle'
      },{field: 'id',title: 'id',visible:false}, 
        {field: 'typename',title: '字典类型名称'},
    	{field: 'typesign',title: '字典类型编码'},
    	{field: 'opera',
          title: '操作',
          formatter: operateFormatter}
    	];
    var dictTypeTable = new MyTable();
    dictTypeTable.Init(dictTypeOption);
    
   $('#dictTypeList_toolbar').find('.btn-add').click(function() {
// 	   $('#myModal').find("#myModalLabel").text('添加字典数据');
	   $('#myModal').find("#myForm").find("input").each(function(){
			$(this).val("");
		});
	   $('#myModal').modal('show');
   });
   $('#dictTypeList_toolbar').find('.btn-edit').click(function() {
	   var ids =  $.map($('#dictTypeList').bootstrapTable('getSelections'), function (row) {
	        return row.id
	 	});
	  	 if(ids == null || ids.length==0 || ids.length > 1){
	  		 $.alert({
				    title: '提示信息',
				    content: '请选择需要修改的数据!',
				    confirm: function(){
				    	return false;
				    }
				});
	  	 }else{
	  	   $('#myModal').find("#myModalLabel").text('修改字典数据');
	  	  	editDictType(ids);
	  	 }
   });
   
   $('#myModal').find('.btn-confirm').click(function () {
	var data = {};
	$('#myModal').find("#myForm").find("input").each(function(){
		data[$(this).attr("id")] = $(this).val();
	});
	var url = "/ajax/sysDictType/save";
	var succ = function (json){
		if(json.status=='ok'){
			$('#dictTypeList').bootstrapTable('refresh');
		    $('#myModal').modal('hide');
		}else{
			$.alert({
 			    title: '提示信息',
 			    content: json.msg,
 			    confirm: function(){
 			    	return false;
 			    }
 			});
		}
	}
	goGET(url,data,succ);
  })
   
   $('#dictTypeList_toolbar').find('.btn-refresh').click(function() {
   	 $('#dictTypeList').bootstrapTable('refresh');
   });
   
   $('#dictTypeList_toolbar').find('.btn-remove').click(function() {
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
   	 }
   });
    
 //1.初始化Table
   var dictItemOption = myTableOption;
   dictItemOption.tableId = "dictItemList";
   dictTypeOption.url = "/ajax/sysDictItem/getData";
   dictItemOption.columns = [{
       field: 'state',
       checkbox: true,
       align: 'center',
       valign: 'middle'
     },{field: 'id',title: 'id',visible:false}, 
       {field: 'itemname',title: '字典类型名称'},
   	{field: 'ename',title: '字典类型编码'},
   	{field: 'opera',
         title: '操作',
         formatter: operateFormatter}
   	];
   var dictItemTable = new MyTable();
   dictItemTable.Init(dictItemOption);
   
   $('#dictItemList_toolbar').find('.btn-refresh').click(function() {
   	 $('#dictItemList').bootstrapTable('refresh');
   });
   
   
 //1.初始化modal
   var dictTypeModal = new MyModal();
   dictTypeModal.option.modalId="myModal";
   dictTypeModal.option.title="添加字典数据";
   dictTypeModal.option.aotoBodyUrl="/html/sys/dic/dictType.html";
   dictTypeModal.Init();
   
    setTimeout('winResize()',100);
});

function winResize(){
	$('#dictTypeList').bootstrapTable('resetView', {
        height: getHeight()*0.4
    });
}

function operateFormatter(value, row, index) {
	var html = '<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">'
				+'<a class="blue" title="修改" href="javascript:void(0)" onClick="editDictType(\''+row.id+'\')"> '
				+'<i class="glyphicon glyphicon-edit bigger-130 blue"></i> </a> '
				+'<a class="blue" title="删除" href="javascript:void(0)" onClick="removeDictType(\''+row.id+'\')"> '
				+'<i class="glyphicon glyphicon-trash bigger-130 red"></i> </a> '
				+'</div>';
    return html;
}

function removeDictType(id){
	var url = '<%=request.getContextPath() %>/ajax/sysDictType/remove';
	var data = {"ids":id+''};
	var succ = function (json){
		if(json.status=='ok'){
			$.alert({
 			    title: '提示信息',
 			    content: '删除成功!',
 			    confirm: function(){
 			    	return false;
 			    }
 			});
			$('#dictTypeList').bootstrapTable('refresh');
		}
	}
	goGET(url,data,succ);
}
function editDictType(id){
	var url = "/ajax/sysDictType/getData/"+id;
	var succ = function (json){
		if(json.status=='ok'){
			var data = json.data;
			$('#myModal').find("#myForm").find("#id").val(data.id);
			$('#myModal').find("#myForm").find("#typename").val(data.typename);
			$('#myModal').find("#myForm").find("#typesign").val(data.typesign);
		}else{
			$.alert({
 			    title: '提示信息',
 			    content: json.msg,
 			    confirm: function(){
 			    	return false;
 			    }
 			});
		}
	}
	goGET(url,null,succ);
	$('#myModal').modal('show');
}
</script>

</body>

</html>