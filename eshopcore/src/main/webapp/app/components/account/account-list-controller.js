(function (app) {
    app.controller('account-list-controller', accountListController)
    //inject các service cần dùng
    accountListController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox'];

    //chú ý thứ tự
    function accountListController($scope, apiService, notificationService, $ngBootbox) {
        $scope.accountList = [];
        $scope.advanceSearch=false;
        $scope.isReset=false;
        $scope.accountFilter = {
                ID:null,
                Name:null,
                UserName:null,
                GroupUserID:null

        };
      
        $scope.search = search;
        $scope.getListAccount = getListAccount;
        $scope.checkAuthen=checkAuthen();
        function checkAuthen(){
            apiService.get('/eshopcore_war/api/auth', null, function (result) {
            }, function () {
            });
        }
        $scope.reset = function () {
            $scope.isReset=true;
            $scope.accountFilter = {};
            getListAccount();
        }

        $scope.delAccount = delAccount;
        function search() {
            $scope.isReset=true;
            getListAccount();
        }

        function delAccount(id) {
            $ngBootbox.confirm('Bạn có chắc muốn xóa?').then(function () {
                var config = {
                    params: {
                        ID: id,
                    }
                }
                apiService.del('/eshopcore_war/api/Account/GetAll', config, function () {
                    notificationService.displaySuccess("Xóa  thành công bản ghi");
                    getListAccount();
                }, function () {

                });
                notificationService.displaySuccess("Xóa  thành công bản ghi");
                getListAccount();
            });
            b
        }

        function getListAccount() {
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/

            var config = {
                params: {
                    filterJson: angular.toJson($scope.accountFilter)
                }
            }

            apiService.get('/eshopcore_war/api/user', config, function (result) {
                $scope.accountList = result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy bản ghi nào");
                } else {

                    notificationService.displaySuccess("Tìm thấy " + result.data.length + " bản ghi");
                }


            }, function () {
                console.log('Load account api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });

        }

        $scope.getListAccount();
    }
})(angular.module('eshop-account'));