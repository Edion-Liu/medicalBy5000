var logEditUrl = {
    modify: "/ajax/log/modify",
    findByUuid: "/ajax/log/",
}

rootApp.factory('LogEditService', [
    function () {
        return {
            modify: function (record) {
                return $.post(logEditUrl.modify, record);
            },
            findByUuid : function (uuid) {
                return $.post(logEditUrl.findByUuid + uuid);
            },
        };
    }
]);


rootApp.controller('LogEditController', ['$scope', 'LogEditService',
    function ($scope, LogEditService) {
        UI.loading();
        $scope.modifySubmit = function () {
            LogEditService.modify($scope.record).success(function (data, status) {
                JsonHandler.dealJson(data, function (data) {
                    UI.successToast("修改成功");
                });
            });
        };
        $scope.closeWin = function () {
            window.parent.UI.removeWin();
        };
        $scope.findOneByUuid = function () {
            var uuid = $('#logEditDialog').attr('uuid');
            LogEditService.findByUuid(uuid).success(function (data, status) {
                JsonHandler.dealJson(data, function (data) {
                    $scope.record = data.result;
                    $scope.$apply();
                    UI.loading();
                }, function (json) {
                    UI.loading();
                    UI.alert(json.result ? json.result : "未知原因失败");
                });
            });
        };
        $scope.findOneByUuid();
    }
]);

