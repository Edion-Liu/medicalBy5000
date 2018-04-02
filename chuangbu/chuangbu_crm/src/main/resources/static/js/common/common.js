function isNull(exp) {
	if (exp != null && typeof (exp) != "undefined" && exp.length > 0) {
		return false;
	} else {
		return true;
	}
}

function Alaert(msg){
	$.alert({
	    title: '提示信息',
	    content: msg,
	    confirm: function(){
	    	return false;
	    }
	});
}
