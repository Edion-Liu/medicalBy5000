/**
 * 自定义工具类
 *
 * */
UI = {
    /**
     * 警告框
     */
    alert: function (msg, cbFn) {
        var old = $('#alert');
        if (!!old) {
            old.remove();
        }
        if (ValueUtil.isBlank(msg)) {
            msg = "失败";
        }
        //1、最外层div，占据整个屏幕
        var alert = $('<div  id="alert" class="modal fade label-default"></div>');
        $('body').append(alert);
        //2、内层对话框
        var dialog = $('<div class="modal-dialog"></div>');
        alert.append(dialog);
        //3、内容部分
        var content = $('<div class="modal-content"></div>');
        dialog.append(content);
        //4、标题部分
        var header = $('<div class="modal-header alert alert-danger"></div>');
        content.append(header);
        var h4 = $('<h4 class="modal-title"></h4>');
        var alertTitle = "警告";
        h4.text(alertTitle);
        header.append(h4);
        //5、内容
        var body = $('<div class="modal-body" ></div>');
        content.append(body);
        var p = $('<p></p>');
        body.append(p);
        p.html(msg);
        //6、按钮
        var footer = $('<div class="modal-footer"></div>');
        content.append(footer);
        var btn = $('<button id="alertCancelBtn" type="button" class="btn btn-danger btn-lg" data-dismiss="modal">关闭</button>');
        footer.append(btn);
        $('#alert').modal({
            backdrop: false,
            keyboard: false,
            show: false
        });
        $('#alertCancelBtn').click(function () {
            if (!ValueUtil.isBlank(cbFn)) {
                cbFn();
            }
            alert.remove();
        });
        $('#alert').modal('show');
    },

    /**
     * 确认框
     */
    confirm: function (msg, cbFun) {
        var old = $('#confirm');
        if (!!old) {
            old.remove();
        }
        //1、最外层div，占据整个屏幕
        var confirm = $('<div  id="confirm" class="modal fade label-default"></div>');
        $('body').append(confirm);
        //2、内层对话框
        var dialog = $('<div class="modal-dialog"></div>');
        confirm.append(dialog);
        //3、内容部分
        var content = $('<div class="modal-content"></div>');
        dialog.append(content);
        //4、标题部分
        var header = $('<div class="modal-header alert alert-warning"></div>');
        content.append(header);
        var h4 = $('<h4 class="modal-title"></h4>');
        var alertTitle = "确认";
        h4.text(alertTitle);
        header.append(h4);
        //5、内容
        var body = $('<div class="modal-body" ></div>');
        content.append(body);
        var p = $('<p></p>');
        body.append(p);
        p.html(msg);
        //6、按钮
        var footer = $('<div class="modal-footer"></div>');
        content.append(footer);
//        var center = $('<div class="center-block" style="width: 150px;"></div>');
//        footer.append(center);
        var sure = $('<button type="button" class="btn btn-primary btn-lg" >确认</button>');
        footer.append(sure);
        sure.click(function () {
            cbFun();
            $('#confirm').modal('hide');
        });
        var cancel = $('<button id="confirmCancelBtn" type="button" class="btn btn-default btn-lg" data-dismiss="modal">取消</button>');
        footer.append(cancel);
        $('#confirm').modal({
            backdrop: false,
            keyboard: false,
            show: false
        });
        $('#confirmCancelBtn').click(function () {
            confirm.remove();
        });
        $('#confirm').modal('show');

    },
    /**
     * 操作提示
     * */
    successTips: function (content) {
        var old = $('#tip');
        if (!!old) {
            old.remove();
        }
        if (!content) {
            content = "操作成功！"
        }
        var tip = $('<div id="tip" class="alert alert-success alert-dismissable fade in" role="alert"></div>');
        var span = $('<span class="glyphicon glyphicon-ok-sign"></span>');
        tip.append(span);
        tip.append('&nbsp;&nbsp;&nbsp' + content);
//        $(".nest-section").append(tip);
        $("#main").append(tip);
        setTimeout(function () {
            $("#tip").alert('close')
        }, 1000);
    },
    successToast: function (content, cbFun) {
        var old = $('#successToast');
        if (!!old) {
            old.remove();
        }
        if (!content) {
            content = "操作成功！"
        }
        //1、最外层div，占据整个屏幕
        var successToast = $('<div  id="successToast" class="modal fade label-default"></div>');
        $('body').append(successToast);
        //2、内层对话框
        var dialog = $('<div class="modal-dialog"></div>');
        successToast.append(dialog);
        //3、内容部分
        var contentDiv = $('<div class="modal-content"></div>');
        dialog.append(contentDiv);
        //4、标题部分
        var header = $('<div class="modal-header alert alert-success"></div>');
        contentDiv.append(header);
        var h4 = $('<h4 class="modal-title"></h4>');
        var alertTitle = "提示";
        h4.text(alertTitle);
        header.append(h4);
        //5、内容
        var body = $('<div class="modal-body" ></div>');
        contentDiv.append(body);
        body.html(content);
        //6、按钮
        var footer = $('<div class="modal-footer"></div>');
        contentDiv.append(footer);
        var btn = $('<button id="successToastCancelBtn" type="button" class="btn btn-danger btn-lg" data-dismiss="modal">关闭</button>');
        footer.append(btn);
        $('#successToastCancelBtn').click(function () {
            successToast.remove();
        });
        $('#successToast').modal({
            backdrop: false,
            keyboard: false,
            show: false
        });
        $('#successToast').modal('show');
        $('#successToast').delay(1000).fadeOut("slow", function () {
            $('#successToast').remove();
            if (cbFun) {
                cbFun();
            }
        });
    },

    loading: function (msg) {
        var old = $('#loading');
        if (!(null == old || undefined == old || 0 == old.length)) {
            old.remove();
            return;
        }
        if (!msg) {
            msg = "正在准备数据";
        }
        //1、最外层div，占据整个屏幕
        var loading = $('<div  id="loading" class="modal fade"></div>');
        $('body').append(loading);
        //2、内层对话框
        var dialog = $('<div class="modal-dialog"></div>');
        loading.append(dialog);
        //3、内容部分
        var content = $('<div class="modal-content"></div>');
        dialog.append(content);
        //5、内容
        var body = $('<div class="modal-body" ></div>');
//        var body = $('<span class="glyphicon glyphicon-refresh">正在加载数据</span>');
        content.append(body);
        var loadingImg = $('<img src="' + '/framework/img/loading.gif" />');
        var p = $('<p></p>');
        p.append(loadingImg);
        var span = $('<span>' + msg + '</span>')
        p.append(span);
        body.append(p);
        $('#loading').modal({
            backdrop: false,
            keyboard: false,
            show: false
        });
        $('#loading').modal('show');
        $('body').css('padding', '0');
    },

    popWin: function (url) {
        $('body').append($('<div id="popWin" class="modal fade label-default"></div>'));
        $("#popWin").append($('<iframe width="100%" height="100%"></iframe>'));
        $("#popWin iframe").attr("src", url);
        $('#popWin').modal({
            backdrop: false,
            keyboard: false,
            show    : true
        });
    },

    removeWin: function () {
        $('#popWin').modal('hide');
        var old = $('#popWin');
        if (!!old) {
            old.remove();
        }
    },

    /**
     * 页面加载顶部动画 0.3秒加载20%，0.8秒加载60%
     * */
    startLoadingPage: function () {
        //初始化进度条
        $("#progress-bar-loadingPage").show();
        $("#progress-bar-loadingPage-width").width('0%');
        setTimeout(function () {
            $("#progress-bar-loadingPage-width").width('20%')
        }, 300);
        loadingPageVariable = setTimeout(function () {
            $("#progress-bar-loadingPage-width").width('60%')
        }, 800);
    },
    /**
     * 页面加载完成,0.3秒后隐藏
     * */
    finishLoadingPage: function () {
        //清除队列
        clearTimeout(loadingPageVariable);
        $("#progress-bar-loadingPage-width").width('100%');
        setTimeout(function () {
            $("#progress-bar-loadingPage").hide()
        }, 500);
    }

}


JsonHandler = {
    dealJson: function (json, successFn, failFn) {
        if (ValueUtil.isBlank(json)) {
            console.error("jsonBack json parameter error. json: " + json);
            return;
        }
        if (json.type == "SUCCESS") {
            if (!successFn) {
                UI.successTips("成功");
            } else {
                successFn(json);
            }
        // } else if (json.type == "-7") {
        //     UI.alert(json.result, function () {
        //         window.location = "/login/";
        //     });
        // } else if (json.type == "-71") {
        //     UI.alert("请重新登录", function () {
        //         window.location = "/login/?reUrl=" + json.msg;
        //     });
        } else {
            if (!failFn) {
                UI.alert(json.result ? json.result : "未知原因失败");
            } else {
                failFn(json);
            }
        }
    },
}

var ValueUtil = {
    isBlank: function (val) {
        return val == null || val == undefined || $.trim(val) == "";
    },
    isArrayEmpty: function (array) {
        return array == null || array == undefined || array.length == 0;
    },
    dealValue: function (ori, length) {
        if (ValueUtil.isBlank(ori)) {
            return "";
        }
        if (!length) {
            return ori;
        }
        return ori.length > length ? ori.substring(0, length) : ori;
    },
    dealParameter: function (val) {
        if (ValueUtil.isBlank(val)) {
            return undefined;
        }
        return $.trim(val);
    },
    dealUpdateParameter: function (val) {
        if (ValueUtil.isBlank(val)) {
            return "";
        }
        return $.trim(val);
    },
    occupySpaceLeft: function (ori, len) {
        ori += "";
        if (ori.length < len) {
            return ValueUtil._buildSpace(ori.length, len) + ori;
        }
        return ori;
    },
    _buildSpace: function (oriLen, needLen) {
        var size = needLen - oriLen;
        var space = "";
        for (var i = 0; i < size * 2; i++) {
            space += "&nbsp;"
        }
        return space;
    },
    dealMetaId: function (id) {
        return ValueUtil.isBlank(id) ? -1 : id;
    }
}

DateTimeUtil = {

    formatDateTime: function (date) {
        if (null == date || undefined == date || 0 == date) {
            return "";
        }
        date = new Date(date * 1000);
        var year = date.getFullYear();
        var month = date.getMonth() + 1; // js从0开始取
        var day = date.getDate();
        var hour = date.getHours();
        if (hour.toString().length == 1) {
            hour = "0" + hour;
        }
        var minutes = date.getMinutes();
        if (minutes.toString().length == 1) {
            minutes = "0" + minutes;
        }
        var seconds = date.getSeconds()
        if (seconds.toString().length == 1) {
            seconds = "0" + seconds;
        }
        var newDate = year + "-" + month + "-" + day + " " + hour + ":"
            + minutes + ":" + seconds;
        return newDate;
    },

    formatDateTimeSecond: function (date) {
        if (null == date || undefined == date || 0 == date) {
            return "不详";
        }
        date = new Date(date * 1000);
        var year = date.getFullYear();
        var month = date.getMonth() + 1; // js从0开始取
        var day = date.getDate();
        var hour = date.getHours();
        if (hour.toString().length == 1) {
            hour = "0" + hour;
        }
        var minutes = date.getMinutes();
        if (minutes.toString().length == 1) {
            minutes = "0" + minutes;
        }
        var seconds = date.getSeconds();
        if (seconds.toString().length == 1) {
            seconds = "0" + seconds;
        }
        var newDate = year + "-" + month + "-" + day + " " + hour + ":"
            + minutes + ":" + seconds + "";
        return newDate;
    },
    formatDate: function (date) {
        if (null == date || undefined == date || 0 == date) {
            return "";
        }
        date = new Date(date * 1000);
        var year = date.getFullYear();
        var month = date.getMonth() + 1; // js从0开始取
        var day = date.getDate();
        if (day < 10) {
            day = "0" + day;
        }
        var hour = date.getHours();
        if (month.toString().length == 1) {
            month = "0" + month;
        }
        var newDate = year + "/" + month + "/" + day;
        return newDate;
    },
    formatDateOther: function (date) {
        if (null == date || undefined == date || 0 == date) {
            return "";
        }
        date = new Date(date * 1000);
        var year = date.getFullYear();
        var month = date.getMonth() + 1; // js从0开始取
        var day = date.getDate();
        if (day < 10) {
            day = "0" + day;
        }
        var hour = date.getHours();
        if (month.toString().length == 1) {
            month = "0" + month;
        }
        var newDate = year + "-" + month + "-" + day;
        return newDate;
    },
    extractCreateDateStart: function (dateVal) {
        if (ValueUtil.isBlank(dateVal)) {
            return undefined;
        }
        return dateVal.split(' -- ')[0];
    },
    extractCreateDateEnd: function (dateVal) {
        if (ValueUtil.isBlank(dateVal)) {
            return undefined;
        }
        return dateVal.split(' -- ')[1];
    }
};


EXPORT_UTIL = {
    ajaxDownload: function (url, data) {
        var $iframe,
            iframe_doc,
            iframe_html;

        if (($iframe = $('#download_iframe')).length === 0) {
            $iframe = $("<iframe id='download_iframe'" +
                    " style='display: none' src='about:blank'></iframe>"
            ).appendTo("body");
        }

        iframe_doc = $iframe[0].contentWindow || $iframe[0].contentDocument;
        if (iframe_doc.document) {
            iframe_doc = iframe_doc.document;
        }

        iframe_html = "<html><head></head><body><form method='POST' action='" +
            url + "'>"

        Object.keys(data).forEach(function (key) {
            if (data[key] != undefined) {
                iframe_html += "<input type='hidden' name='" + key + "' value='" + data[key] + "'>";
            }
        });

        iframe_html += "</form></body></html>";

        iframe_doc.open();
        iframe_doc.write(iframe_html);
        $(iframe_doc).find('form').submit();
    }
}
