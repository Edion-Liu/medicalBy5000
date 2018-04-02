var MyModal = function (){
	var oModalInit = new Object();
	
	oModalInit.option = {
			modalId:"myModal",
			title: '模态框',
			footerClose: true,             //是否显示关闭按钮
			footerCloseVal: "关闭",         //关闭按钮名称
			footerConfirm: true,           //是否显示确认按钮
			footerConfirmVal: "确认",       //确认按钮名称
	        aotoBody: true,                //是否自动获取body内容
	        aotoBodyUrl: "/html/sys/dic/dictType.html",               //aotoBody=true，添加获取路径
	        bodyHtml: ""                //aotoBody=false,直接显示这个内荣
	}
	
	oModalInit.Init = function () {
		var html = '<div class="modal fade" id="'+oModalInit.option.modalId+'" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'
		+'    <div class="modal-dialog">'
		+'        <div class="modal-content">'
		+'            <div class="modal-header">'
		+'                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>'
		+'                <h4 class="modal-title" id="myModalLabel">'+oModalInit.option.title+'</h4>'
		+'            </div>'
		+'            <div class="modal-body">';
		if(!oModalInit.option.aotoBody){
			html += oModalInit.option.bodyHtml;
		}
		html += '</div>'
		+'            <div class="modal-footer">'
		+'					<div class="alert alert-danger alert-dismissable col-sm-8" style="margin-bottom: auto;display: none;">'
		+'						</div>';
		if(oModalInit.option.footerClose){
			html += '<button type="button" class="btn btn-default" data-dismiss="modal">'+oModalInit.option.footerCloseVal+'</button>'
		}
		if(oModalInit.option.footerConfirm){
			html += '<button type="button" class="btn btn-primary btn-confirm">'+oModalInit.option.footerConfirmVal+'</button>'
		}
		html += '    </div>'
		+'        </div>'
		+'    </div>'
		+'</div>';
		$("body").append(html);
		
		if(oModalInit.option.aotoBody){
			var succ = function (result){
				 $("#"+oModalInit.option.modalId).find(".modal-body").empty();
				 $("#"+oModalInit.option.modalId).find(".modal-body").append(result);
			}
			$.ajax({
				type: "GET",
				url: oModalInit.option.aotoBodyUrl,
				success: succ,
				dataType: "html"
			});
		}
		
	}
	
	oModalInit.show = function(text,isClean){
		$('#'+oModalInit.option.modalId).find("#myModalLabel").text(text);
		if(isClean){
			$('#'+oModalInit.option.modalId).find("#myForm").find("input").each(function(){
				$(this).val("");
			});
		}
	   $('#'+oModalInit.option.modalId).modal('show');
	}
	
	oModalInit.alert = function(msg){
		$('#'+oModalInit.option.modalId).find(".modal-footer").find(".alert").text(msg);
		$('#'+oModalInit.option.modalId).find(".modal-footer").find(".alert").show();
	}
	
	oModalInit.setData = function(data){
		$('#'+oModalInit.option.modalId).find("#myForm").find("input").each(function(){
			$(this).val(data[$(this).attr("id")]);
		});
	}
	
	oModalInit.getData = function(){
		var data = {};
		$('#'+oModalInit.option.modalId).find("#myForm").find("input").each(function(){
			data[$(this).attr("id")] = $(this).val();
		});
		return data;
	}
	
	oModalInit.verify = function(){
		var flag = true;
		$('#'+oModalInit.option.modalId).find("#myForm").find("input").each(function(){
			var required = $(this).parent().prev().find("span[name='required']");
			if (required != null && required.length > 0) {
				var val = $(this).val();
				if (isNull(val)) {
					$(this).css("border", "1px solid #f00");
					flag = false;
				} else {
					$(this).css("border", "1px solid #CCCCCC");
				}
			} else {
				$(this).css("border", "1px solid #CCCCCC");
			}
		});
		return flag;
	}
	
	return oModalInit;
}