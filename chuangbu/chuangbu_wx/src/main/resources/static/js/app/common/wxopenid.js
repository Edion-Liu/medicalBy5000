function getQueryString(name) {  
           var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");  
           var r = location.search.substr(1).match(reg);  
           if (r != null)  
               return unescape(decodeURI(r[2]));  
           return null;  
       } 

function getOpenId(appId,basepath) {
	var wxopenid = getCookie('wxopenid'+appId);
	var access_code = getQueryString('code');
	//alert("wxopenid"+wxopenid);
	//alert("access_code"+access_code);
	if (wxopenid == null || wxopenid == "") {
		if (access_code == null) {
			var fromurl = location.href;
			var url = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid='+appId+'&redirect_uri='
					+ encodeURIComponent(fromurl)
					+ '&response_type=code&scope=snsapi_base&state=STATE%23wechat_redirect&connect_redirect=1#wechat_redirect';
			location.href = url;
		} else {
			$.ajax({
				type : 'get',
				url : basepath+'/ajax/pay/tencent/getOpenId',
				async : false,
				cache : false,
				data : {
					code : access_code
				},
				dataType : 'json',
				success : function(result) {
//					alert(result.status);
//					alert(result.data);
					if (result != null && result.status == "ok") {
						setCookie('wxopenid'+appId, result.data, 'd30');
						return result.data;
					} else {
						alert('微信身份识别失败 \n ' + result.msg);
						location.href = fromurl;
					}
				}
			});
		}
	}else{
		return wxopenid;
	}
}