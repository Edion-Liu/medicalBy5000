
function goPOST(url,data,succ,fail){
	goAjax("POST",url,data,succ,fail)
}
function goGET(url,data,succ,fail){
	goAjax("GET",url,data,succ,fail)
}

function goAjax(type,url,data,succ,fail){
	$.ajax({
		type: type,
		url: url,
		data: data,
		success: succ,
		error:fail,
		dataType: "json"
	});
}
