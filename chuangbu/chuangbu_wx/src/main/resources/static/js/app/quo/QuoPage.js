var url = {
    find: "/ajax/quo/find",
}

rootApp.factory('CamsQuoPageService', [
    function () {
        return {
        	find: function (tRcsCamsQuo) {
                return $.post(url.find, tRcsCamsQuo);
            }
        };
    }
]);


rootApp.controller('CamsQuoController', ['$scope', 'CamsQuoPageService',
    function ($scope, CamsQuoPageService) {
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
            CamsQuoPageService.find($scope.query).success(function (data, status) {
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
//        $scope.find();
        $('.date-input').daterangepicker(null, function (start, end, label) {
        });
    }
]);

