function getTableData(url,_para,isInit,pageDiv,pageSize,pageIndex,initTBData){
	var para;
	if(_para == null || typeof(_para) == "undefined" ){
		para = new Object();
	}
	para.pageSize = pageSize;
	para.pageIndex = pageIndex;
	$.ajax({
      url: url,
      datatype: 'json',
      type: "Post",
      data: para,
      success: function (json) {
        if (json != null && json.status == "ok") {
        	var jsonDate = JSON.parse(json.data);
        	
        	initTBData(jsonDate);
        	
        	if(isInit){
        		var pageCount = json.pageCount; //取到pageCount的值(把返回数据转成object类型)
  	            var currentPage = json.pageIndex; //得到urrentPage
  	          
  	          var options = {
  	       			currentPage: currentPage,
  	       			totalPages: pageCount,
  	       			numberOfPages:5,
  	       			size:"normal",
  	       			alignment:"right",
  	       		    itemTexts: function (type, page, current) {
  	       				switch (type) {
  	       				case "first":
  	       					return "首页";
  	       				case "prev":
  	       					return "上一页";
  	       				case "next":
  	       					return "下一页";
  	       				case "last":
  	       					return "末页";
  	       				case "page":
  	       					return page;
  	       				}
  	       			},
  	       			onPageChanged: function(e,oldPage,newPage){
  	       				getTableData(url,_para,false,pageDiv,pageSize,newPage,initTBData);
  	       	        }
  	       		}

  	       		$('#'+pageDiv).bootstrapPaginator(options);
        	}       
          
        }
      }
    });
}

function createOperaDiv(isSee,isEdit,isDel){
	var opDiv = $("<div class=\"visible-md visible-lg hidden-sm hidden-xs action-buttons\"> </div>")
	
	if(isSee){
		opDiv.append("<a class=\"blue\" href=\"#\"> <i class=\"glyphicon glyphicon-eye-open bigger-130\"></i> </a>");
	}
	if(isEdit){
		opDiv.append("<a class=\"green\" href=\"#\"> <i class=\"glyphicon glyphicon-edit bigger-130\"></i> </a>");
	}
	if(isDel){
		opDiv.append("<a class=\"red\" href=\"#\"> <i class=\"glyphicon glyphicon-trash bigger-130\"></i> </a>");
	}
	return opDiv;
}