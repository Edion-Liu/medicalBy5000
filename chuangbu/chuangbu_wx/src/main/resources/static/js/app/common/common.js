//保留两位小数  
//功能：将浮点数四舍五入，取小数点后2位 
    function toDecimal(x) { 
      var f = parseFloat(x); 
      if (isNaN(f)) { 
        return; 
      } 
      f = Math.round(x*100)/100; 
      return f; 
    } 
  
  
    //制保留2位小数，如：2，会在2后面补上00.即2.00 
function toDecimal2(x) {
  var f = parseFloat(x); 
  if (isNaN(f)) { 
    return false; 
  } 
  var f = Math.round(x*100)/100; 
  var s = f.toString(); 
  var rs = s.indexOf('.'); 
  if (rs < 0) { 
    rs = s.length; 
    s += '.'; 
  } 
  while (s.length <= rs + 2) { 
    s += '0'; 
  } 
  return s; 
} 
  
function fomatFloat(src,pos){   
   return Math.round(src*Math.pow(10, pos))/Math.pow(10, pos);   
} 
    
function isStrNULL(val){
			if(val != null && typeof(val) != "undefined" && val.length > 0){
				return false;
			}else{
				return true;
			}
		}

function openUrl(serverName , url,type){
	if(type != null && type == '01'){
		var str = encode64(url);
		str = str.replace('/','======');
		location.href = serverName+'/view/common/'+str;
	}else if(type != null && type == '02'){
		location.href = serverName+url;
	}else if(type != null && type == '03'){
		var str = url.substring(url.indexOf("menuUrl")+8);
		str = encode64(str);
		str = str.replace('/','======');
		url = url.substring(0,url.indexOf("menuUrl")-1);
		location.href = serverName+url+"?menuUrl="+str;
	}else if(type != null && type == '04'){
		location.href = url;
	}else{
		location.href = serverName+'/view/common/'+encode64(url);
	}
}
// base64加密开始  
    var keyStr = "ABCDEFGHIJKLMNOP" + "QRSTUVWXYZabcdef" + "ghijklmnopqrstuv"  
            + "wxyz0123456789+/" + "=";  
      
    function encode64(input) {  
  
        var output = "";  
        var chr1, chr2, chr3 = "";  
        var enc1, enc2, enc3, enc4 = "";  
        var i = 0;  
        do {  
            chr1 = input.charCodeAt(i++);  
            chr2 = input.charCodeAt(i++);  
            chr3 = input.charCodeAt(i++);  
            enc1 = chr1 >> 2;  
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);  
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);  
            enc4 = chr3 & 63;  
            if (isNaN(chr2)) {  
                enc3 = enc4 = 64;  
            } else if (isNaN(chr3)) {  
                enc4 = 64;  
            }  
            output = output + keyStr.charAt(enc1) + keyStr.charAt(enc2)  
                    + keyStr.charAt(enc3) + keyStr.charAt(enc4);  
            chr1 = chr2 = chr3 = "";  
            enc1 = enc2 = enc3 = enc4 = "";  
        } while (i < input.length);  
  
        return output;  
    }  