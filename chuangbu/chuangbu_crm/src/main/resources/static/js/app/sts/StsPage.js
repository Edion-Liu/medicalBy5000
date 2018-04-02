var url = {
    find: "/ajax/sts/find",
    frzStsDeal:"/ajax/sts/frzStsDeal"
}

rootApp.factory('CamsStsPageService', [
    function () {
        return {
        	find: function (tRcsCamsSts) {
                return $.post(url.find, tRcsCamsSts);
            },
            frzStsDeal : function(tRcsCamsSts){
            	return $.post(url.frzStsDeal, tRcsCamsSts);
            }
        };
    }
]);


rootApp.controller('CamsStsController', ['$scope', 'CamsStsPageService',
    function ($scope, CamsStsPageService) {
		$(document).keyup(function (event) {
	        if (event.keyCode == 13) {
	            $scope.find();
	        }
	    });
	    $scope.$watch('page', function (newValue, oldValue, $scope) {
	        if (isPageChange(newValue,oldValue)) {
	            $scope.find();
	        }
	    }, true);
	    $scope.find = function () {
            UI.loading();
            if (!$scope.page) {
                $scope.query = {
                    needPagination: 1,
                    pageSize      : 20,
                    dealType      : -1
                }
            } else {
                $scope.query.needPagination = $scope.page.curPagination;
                $scope.query.pageSize = $scope.page.pageSize;
            }
            $scope.query.startDt = DateTimeUtil.extractCreateDateStart($('#timeIpt').val());
            $scope.query.endDt = DateTimeUtil.extractCreateDateEnd($('#timeIpt').val());
            $scope.query.usrInNo = $('#usrInNo').val();
            CamsStsPageService.find($scope.query).success(function (data, status) {
                JsonHandler.dealJson(data, function (data) {
                    $scope.page = data.result;
                    $scope.query.pageSize = $scope.page.pageSize;
                    $scope.$apply();
                    UI.loading();
                }, function (json) {
                    UI.loading();
                    UI.alert(json.result ? json.result : "未知原因失败");
                });
            });
        };
        $scope.frzStsDeal = function(usrNo,rmk,freezeSts){
        	UI.loading();
        	$scope.tRcsCamsSts = {
        			usrInNo: usrNo,
        			frzSts : freezeSts,
        			rmk:rmk
            }
        	CamsStsPageService.frzStsDeal($scope.tRcsCamsSts)(function (data, status) {
                JsonHandler.dealJson(data, function (data) {
                    UI.successToast(json.result);
                    UI.loading();
                }, function (json) {
                    UI.loading();
                    UI.alert(json.result ? json.result : "未知原因失败");
                });
            });
        };
        //解冻
        $('#unFrzSts').modal({
            backdrop: false,
            show: false
        });
        $scope.unFrzSts = function (usrInNo) {
            $('#unFrzSts').load("/view/sts/stsUnFrz/" + usrInNo, function () {
                $('#unFrzSts').modal('show');
            });
        };
        //冻结
        $('#frzSts').modal({
            backdrop: false,
            show: false
        });
        $scope.frzSts = function (usrInNo) {
            $('#frzSts').load("/view/sts/stsFrz/" + usrInNo, function () {
                $('#frzSts').modal('show');
            });
        };
        //添加
        $('#addFrzSts').modal({
            backdrop: false,
            show: false
        });
        $scope.addFrzSts = function () {
            $('#addFrzSts').load("/view/sts/stsAddFrz/" , function () {
                $('#addFrzSts').modal('show');
            });
        };
        $('.date-input').daterangepicker(null, function (start, end, label) {
        });
    }
]);

