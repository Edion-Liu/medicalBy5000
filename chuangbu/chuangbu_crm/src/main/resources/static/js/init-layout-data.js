$(function() {
    var objs = $("body").find(".newview");
	if(typeof(objs) != "undefined" && objs.length >0){
		for(var n = 0 ; n <objs.length ;n++){
			$(objs[n]).empty();
			initData($(objs[n]),$(objs[n]).attr('id'));
		}
	}
	
})

function initData(eve,uuid){
	if($(eve).hasClass("newBars")){
		$(eve).css("height","300px");
		setTimeout("initBars('"+uuid+"')",1000);
	}
	if($(eve).hasClass("newPie")){
		$(eve).css("height","300px");
		setTimeout("initPie('"+uuid+"')",1000);
	}
	if($(eve).hasClass("newDBPie")){
		$(eve).css("height","300px");
		setTimeout("initDBPie('"+uuid+"')",1000);
	}
	if($(eve).hasClass("newLines")){
		$(eve).css("height","300px");
		setTimeout("initLines('"+uuid+"')",1000);
	}
	if($(eve).hasClass("table")){
		initTable(eve,uuid);
	}
}

function initPie(divid){
	
	var url ="/analysisData/getDateByTypeAndUIID";
	var r_data = {"type":"pie","uiId":divid};
	getDataPOST(url,r_data,function(json){
		if(json != null && json.status=="ok"){
			var obj = document.getElementById(divid);
			var jsonDate = JSON.parse(json.jsonData);
			var p_data = jsonDate[0].data;
			var config = JSON.parse(jsonDate[0].config);
			var p_title = config.title;
			var p_focusName = config.focusName;
			var option = MyECharts.ChartOptionTemplates.Pie(obj, p_data, p_title,p_focusName);
			opt = MyECharts.ChartConfig(obj, option);
			
			MyECharts.Charts.RenderChart(opt);
		}
		
	},function(){});
	
	
}
function initDBPie(divid){
	
	var url ="/analysisData/getDateByTypeAndUIID";
	var r_data = {"type":"DBPie","uiId":divid};
	getDataPOST(url,r_data,function(json){
		if(json != null && json.status=="ok"){
			var obj = document.getElementById(divid);
			var jsonDate = JSON.parse(json.jsonData);
			var p_data = jsonDate[0].data;
			var config = JSON.parse(jsonDate[0].config);
			var p_title = config.title;
			var p_focusName = config.focusName;
			var option = MyECharts.ChartOptionTemplates.DBPie(obj, p_data, p_title,p_focusName);
			opt = MyECharts.ChartConfig(obj, option);
			
			MyECharts.Charts.RenderChart(opt);
		}
		
	},function(){});
	
	
}

function initBars(divid){
	var url ="/analysisData/getDateByTypeAndUIID";
	var r_data = {"type":"bar","uiId":divid};
	getDataPOST(url,r_data,function(json){
		if(json != null && json.status=="ok"){
			var obj = document.getElementById(divid);
			var jsonDate = JSON.parse(json.jsonData);
			var p_data = jsonDate[0].data;
			var config = JSON.parse(jsonDate[0].config);
			var p_title = config.title;
			var p_subTitle = config.subTitle;
			var option = MyECharts.ChartOptionTemplates.Bars(p_data, null,p_title+";"+p_subTitle);
			opt = MyECharts.ChartConfig(obj, option);
			MyECharts.Charts.RenderChart(opt);
			
		}
		
	},function(){});
}

function initLines(divid){
	var url ="/analysisData/getDateByTypeAndUIID";
	var r_data = {"type":"bar","uiId":divid};
	getDataPOST(url,r_data,function(json){
		if(json != null && json.status=="ok"){
			var obj = document.getElementById(divid);
			var jsonDate = JSON.parse(json.jsonData);
			var p_data = jsonDate[0].data;
			var config = JSON.parse(jsonDate[0].config);
			var p_title = config.title;
			var p_subTitle = config.subTitle;
			var option = MyECharts.ChartOptionTemplates.Lines(p_data, null,p_title+";"+p_subTitle);
			opt = MyECharts.ChartConfig(obj, option);
			MyECharts.Charts.RenderChart(opt);
			
		}
		
	},function(){});
	
}

function initTable(eve,divid){
	var url ="/analysisData/getDateByTypeAndUIID";
	var r_data = {"type":"table","uiId":divid};
	getDataPOST(url,r_data,function(json){
		if(json != null && json.status=="ok"){
			var obj = document.getElementById(divid);
			var jsonDate = JSON.parse(json.jsonData);
			var p_data = jsonDate[0].data;
			if(typeof(jsonDate[0].config) == "undefined"){
				var config = JSON.parse(jsonDate[0].config);
				var p_title = config.title;
				var p_theadData = config.theadData;
			}

			creatTable(eve , p_theadData , p_data);
		}
		
	},function(){});
	
}

function creatTable(eve , theadData , data){

	var table =$(eve);
	
	var thead =$("<thead></thead>");
	var thead_tr = $("<tr></tr>");
	thead_tr.appendTo(thead);
	
	if(theadData!=null && theadData.length >0){
		for (var j = 0; j < theadData.length; j++) {
			var td = $("<td>" +  theadData[j].value + "</td>");
			td.appendTo(thead_tr);
		}
		thead_tr.appendTo(thead);
		thead.appendTo(table);
		
		if(data!=null && data.length>0){
			for (var i = 0; i < data.length; i++) {
		         var tr = $("<tr></tr>");
		         tr.appendTo(table);
		         for (var j = 0; j < theadData.length; j++) {
		             var td = $("<td>" + data[i][theadData[j].name] + "</td>");
		             td.appendTo(tr);
		         }
		     }
		}else{
			var tr = $("<tr></tr>");
	        tr.appendTo(table);
             var td = $("<td colspan=\""+theadData.length+"\">无数据</td>");
             td.appendTo(tr);
		}
		 
	     tr.appendTo(table);
	}else{
		
		if(data!=null && data.length>0){
			for(var k in data[0]) {
				var td = $("<td>" +  k + "</td>");
				td.appendTo(thead_tr);			 
			}
			
			thead_tr.appendTo(thead);
			thead.appendTo(table);
			
			for (var i = 0; i < data.length; i++) {
		         var tr = $("<tr></tr>");
		         tr.appendTo(table);
		         for(var k in data[i]) {
					var td = $("<td>" + data[i][k] + "</td>");
		            td.appendTo(tr);
				}
		     }
		}else{
			var td = $("<td>表头</td>");
			td.appendTo(thead_tr);
			thead_tr.appendTo(thead);
			thead.appendTo(table);
		
			var tr = $("<tr></tr>");
	         tr.appendTo(table);
             var td = $("<td >无数据</td>");
             td.appendTo(tr);
		}
		 
	     tr.appendTo(table);
	}
	
}

