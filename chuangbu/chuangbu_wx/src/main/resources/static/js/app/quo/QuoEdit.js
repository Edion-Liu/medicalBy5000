var url = {
    save: "/ajax/quo/save",
}

rootApp.factory('CamsQuoEditService', [
    function () {
        return {
            save: function (tRcsCamsQuo) {
                return $.post(url.save, tRcsCamsQuo);
            }
        };
    }
]);

rootApp.controller('CamsQuoEditController', ['$scope', 'CamsQuoEditService',
    function ($scope, CamsQuoEditService) {
        $scope.save = function(){
        	UI.loading();
        	var today = new Date();
        	$scope.tRcsCamsQuo = {
                optTyp:'1'
            }
        	$scope.tRcsCamsQuo.usrInNo = $('#usrInNo').val();
        	$scope.tRcsCamsQuo.optTm = $filter('date')(today, 'yyyyMMdd');
        	
        	$scope.tRcsCamsQuo.czSinQuo = $('#czSinQuo').val();
        	$scope.tRcsCamsQuo.czDayQuo = $('#czDayQuo').val();
        	$scope.tRcsCamsQuo.czDayCount = $('#czDayCount').val();
        	
        	$scope.tRcsCamsQuo.txSinQuo = $('#txSinQuo').val();
        	$scope.tRcsCamsQuo.txDayQuo = $('#txDayQuo').val();
        	$scope.tRcsCamsQuo.txDayCount = $('#txDayCount').val();
        	
        	$scope.tRcsCamsQuo.zzSinQuo = $('#zzSinQuo').val();
        	$scope.tRcsCamsQuo.zzDayQuo = $('#zzDayQuo').val();
        	$scope.tRcsCamsQuo.zzDayCount = $('#zzDayCount').val();
        	
        	$scope.tRcsCamsQuo.rmk = $('#rmk').val();
        	
        	CamsQuoEditService.save($scope.tRcsCamsQuo).success(function (data, status) {
        		JsonHandler.dealJson(data, function (data) {
                    UI.loading();
                    UI.successToast("操作成功");
                }, function (json) {
                    UI.loading();
                    UI.alert(json.result ? json.result : "未知原因失败");
                });
        	});
        };
    }
]);

