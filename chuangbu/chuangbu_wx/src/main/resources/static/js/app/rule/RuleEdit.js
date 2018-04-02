var url = {
    save: "/ajax/rule/save"
}

rootApp.factory('CamsRuleEditService', [
    function () {
        return {
            save: function (tRcsCamsRule) {
                return $.post(url.save, tRcsCamsRule);
            }
        };
    }
]);


rootApp.controller('CamsRuleEditController', ['$scope', 'CamsRuleEditService',
    function ($scope, CamsRuleEditService) {
        $scope.save = function(){
        	UI.loading();
        	var today = new Date();
        	$scope.tRcsCamsRule = {
        		optTm:today
            }
        	
        	$scope.tRcsCamsRule.czSinQuo = $('#czSinQuo').val();
        	$scope.tRcsCamsRule.czDayQuo = $('#czDayQuo').val();
        	$scope.tRcsCamsRule.czDayCount = $('#czDayCount').val();
        	
        	$scope.tRcsCamsRule.txSinQuo = $('#txSinQuo').val();
        	$scope.tRcsCamsRule.txDayQuo = $('#txDayQuo').val();
        	$scope.tRcsCamsRule.txDayCount = $('#txDayCount').val();
        	
        	$scope.tRcsCamsRule.zzSinQuo = $('#zzSinQuo').val();
        	$scope.tRcsCamsRule.zzDayQuo = $('#zzDayQuo').val();
        	$scope.tRcsCamsRule.zzDayCount = $('#zzDayCount').val();
        	$scope.tRcsCamsRule.uuid = $('#uuid').val();
        	$scope.tRcsCamsRule.rmk = $('#rmk').val();
        	
        	CamsRuleEditService.save($scope.tRcsCamsRule).success(function (data, status) {
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

