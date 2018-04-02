var myTableOption = {
		url: '',
        method: 'get',                      //请求方式（*）
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
       	pagination:true,
       	showFooter:false,
        checkboxHeader: true,
       	sidePagination:"server",
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [15, 25, 50, 100],        //可供选择的每页的行数（*）
}

var MyTable = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function (option) {
    	$('#'+option.tableId).bootstrapTable({
            url: option.url,
            method: option.method,              //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: option.striped,            //是否显示行间隔色
           	pagination:option.pagination,
           	showFooter:option.showFooter,
            checkboxHeader: option.checkboxHeader,
           	sidePagination:"server",
            queryParams: oTableInit.queryParams,//传递参数（*）
            pageNumber:option.pageNumber,       //初始化加载第一页，默认第一页
            pageSize: option.pageSize,          //每页的记录行数（*）
            pageList: option.pageList,        //可供选择的每页的行数（*）
            columns: option.columns
        });
    };
  
  oTableInit.params={};
    //得到查询的参数
  oTableInit.queryParams = function (params) {
	  	var p_pageIndex = params.offset==0?1:params.offset/params.limit+1
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        	pageSize: params.limit,   //页面大小
        	pageIndex: p_pageIndex,  //页码
        };
        return $.extend(temp,oTableInit.params);
  };
    return oTableInit;
};