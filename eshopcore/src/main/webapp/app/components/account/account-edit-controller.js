(function (app) {
    app.controller('account-edit-controller', accountEditController)
    accountEditController.$inject = ['api-service','$scope', 'notification-service','$state','$stateParams'];

    function accountEditController(apiService,$scope,notificationService,$state,$stateParams) {
        $scope.jsonEntity = {};
        $scope.EditAccount = EditAccount;

        $scope.AccountGroup = [
            {
                "Name" : "Admin",
                "ID" : "1"
            },{
                "Name" : "Clientp",
                "ID" : "2"
            }
        ]

        function LoadAccountByID() {

            var config = {
                params: {
                    keyword: "",
                    ID:$stateParams.id,
                    action: "getByID",
                }
            }

            apiService.get('/eshopcore_war/API-Account', config, function (result) {
                $scope.jsonEntity = result.data[0];
            }, function () {
                console.log('Load account category api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }



        function EditAccount() {
            apiService.put('/eshopcore_war/API-Account',  JSON.stringify($scope.jsonEntity)  , function (result) {
                notificationService.displaySuccess("Sửa bản ghi thành công");
                $state.go('account-list');
            }, function () {
                console.log('Load account category api failed.');
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
            });
        }
        LoadAccountByID();

    }
})(angular.module('eshop-account'));