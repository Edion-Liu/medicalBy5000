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
        <div id="userList_toolbar">
        	<label style="font-size: 20px;margin-right: 20px;">用户信息列表</label>
	        <a href="javascript:void(0);" class="btn btn-warning btn-add" ><i class="glyphicon glyphicon-plus-sign"></i>&nbsp;添&nbsp;加</a>
	        <a href="javascript:void(0);" class="btn btn-success btn-refresh" ><i class="glyphicon glyphicon-refresh"></i>&nbsp;刷&nbsp;新</a>
        </div>
		<table  id="userList" data-toolbar="toolbar">
		   
		</table>
	</div>

	
<script type="text/javascript">
var modalId = "myModal";
var userModal = new MyModal();
$(function () {
	//1.初始化modal
 	userModal.option.modalId=modalId;
	userModal.option.title="添加用户";
   	userModal.option.aotoBodyUrl="/html/sys/user/user.html";
   	userModal.Init();
	   
    //1.初始化Table
    var userOption = myTableOption;
    userOption.tableId = "userList";
    userOption.url = "/ajax/ssUser/getData";
    userOption.columns = [{
        field: 'index',
        title: '序号',
        formatter: function (value, row, index) {
            return index+1;
        }
    	},{field: 'id',title: 'id',visible:false}, 
        {field: 'loginName',title: '登录名称'},
    	{field: 'name',title: '名称'},
    	{field: 'email',title: '邮箱'},
    	{field: 'status',title: '状态'},
    	{field: 'locked',title: '是否锁定'},
    	{field: 'createtime',title: '创建时间'},
    	{field: 'opera',
          title: '操作',
          formatter: operateFormatter}
    	];
    
    var userTable = new MyTable();
    userTable.Init(userOption);
    
   $('#userList_toolbar').find('.btn-add').click(function() {
	   userModal.show('添加用户数据',true);
   });
   $('#userList_toolbar').find('.btn-refresh').click(function() {
   	 $('#userList').bootstrapTable('refresh');
   });
   
   
   $('#myModal').find('.btn-confirm').click(function () {
	   if(userModal.verify()){
		   var data = userModal.getData();
		   if(data.password != data.confirmPassword){
			   $("#"+userModal.option.modalId).find(".modal-body").find("#password").css("border", "1px solid #f00");
			   $("#"+userModal.option.modalId).find(".modal-body").find("#confirmPassword").css("border", "1px solid #f00");
			   userModal.alert("两次输入密码不一致，请修改！");
		   }else{
				var url = "/ajax/ssUser/save";
				var succ = function (json){
					if(json.status=='ok'){
						$('#userList').bootstrapTable('refresh');
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
		   }
	   }else{
		   
	   }
	
  })
   
   
    setTimeout('winResize()',100);
});

function winResize(){
	$('#userList').bootstrapTable('resetView', {
        height: getHeight()-140
    });
}

function operateFormatter(value, row, index) {
	var html = '<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">'
				+'<a class="blue" title="修改" href="javascript:void(0)" onClick="edituser(\''+row.id+'\')"> '
				+'<i class="glyphicon glyphicon-edit bigger-130 blue"></i> </a> '
				+'<a class="blue" title="删除" href="javascript:void(0)" onClick="removeuser(\''+row.id+'\')"> '
				+'<i class="glyphicon glyphicon-trash bigger-130 red"></i> </a> '
				+'</div>';
    return html;
}

function removeuser(id){
	var url = '<%=request.getContextPath() %>/ajax/ssUser/remove';
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
			$('#userList').bootstrapTable('refresh');
		}
	}
	goGET(url,data,succ);
}
function edituser(id){
	var url = "/ajax/ssUser/getData/"+id;
	var succ = function (json){
		if(json.status=='ok'){
			userModal.setData(json.data);
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
	userModal.show('修改用户数据',false);
}
</script>

</body>

</html>