(function (app) {
    app.controller('footer-list-controller', footerListController)
    //inject các service cần dùng
    footerListController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox'];

//chú ý thứ tự
    function footerListController($scope, apiService, notificationService, $ngBootbox) {
        $scope.footerList = [];
        $scope.getListfooter = getListFooter;
        $scope.keyWord = '';

        $scope.search = search;
        $scope.delFooter = delFooter;

        function search() {
            getListFooter();
        }

        function delFooter(id) {
            $ngBootbox.confirm('Bạn có chắc muốn xóa?').then(function () {
                var config = {
                    params: {
                        ID: id,
                    }
                }
                apiService.del('/eshopcore/API-Footer', config, function () {
                    notificationService.displaySuccess("Xóa thành công bản ghi");
                    getListFooter();
                }, function () {

                });
                notificationService.displaySuccess("Xóa  thành công bản ghi");
                getListFooter();
            });

        }

        function getListFooter() {
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            var config = {
                params: {
                    keyword: $scope.keyWord,
                    action: "getAll",
                }
            }

            apiService.get('/eshopcore/API-Footer', config, function (result) {
                $scope.footerList = result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy bản ghi nào");
                } else {

                    notificationService.displaySuccess("Tìm thấy " + result.data.length + " bản ghi");
                }


            }, function () {
                console.log('Load content category api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });

        }
        $scope.getListfooter();
    }
})(angular.module('eshop-footer'));