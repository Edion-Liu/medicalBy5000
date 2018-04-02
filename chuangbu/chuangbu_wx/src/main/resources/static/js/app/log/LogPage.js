var logPageUrl = {
    find: "/ajax/log/find",
    remove: "/ajax/log/remove/",
    edit: "/view/log/logEdit/",
}

rootApp.factory('LogPageService', [
    function () {
        return {
            pageLogList: function (reqPars) {
                return $.post(logPageUrl.find, reqPars);
            },
            remove: function (uuid) {
                return $.post(logPageUrl.remove + uuid);
            },
        };
    }
]);


rootApp.controller('LogPageController', ['$scope', 'LogPageService',
    function ($scope, LogPageService) {
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
            if (!$scope.query) {
                $scope.query = {
                    needPagination: 1,
                    pageSize      : 20,
                    dealType      : -1
                }
            } else {
                $scope.query.needPagination = $scope.page.curPagination;
                $scope.query.pageSize = $scope.page.pageSize;
            }
            $scope.query.timeStart = DateTimeUtil.extractCreateDateStart($('#timeIpt').val());
            $scope.query.timeEnd = DateTimeUtil.extractCreateDateEnd($('#timeIpt').val());
            LogPageService.pageLogList($scope.query).success(function (data, status) {
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
        $scope.removeOne = function (uuid) {
            UI.confirm("确认删除？", function () {
                UI.loading();
                LogPageService.remove(uuid).success(function (data, status) {
                    JsonHandler.dealJson(data, function (data) {
                        UI.loading();
                        UI.successToast("删除成功");
                    }, function (json) {
                        UI.loading();
                        UI.alert(json.result ? json.result : "未知原因失败");
                    });
                });
            });
        };
        // $scope.export = function() {
        //     EXPORT_UTIL.ajaxDownload(logPageUrl.exportExcel, $scope.query);
        // }
        // $scope.find();
        $scope.openEditWin = function (uuid) {
            UI.popWin(logPageUrl.edit + uuid);
        };
        $('.date-input').daterangepicker(null, function (start, end, label) {
        });
    }
]);

