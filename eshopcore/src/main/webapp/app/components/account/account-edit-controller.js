(function (app) {
    app.controller('account-edit-controller', accountEditController)
    accountEditController.$inject = ['api-service','$scope', 'notification-service','$state','$stateParams'];

    function accountEditController(apiService,$scope,notificationService,$state,$stateParams) {
        $scope.accountEntity = {};
        $scope.EditAccount = EditAccount;

        $scope.OldPassword ="";
        $scope.ConfirmPassword ="";

        $scope.CheckPassword = CheckPassword;

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

            apiService.get('/eshopcore_war/API-CreateUser', config, function (result) {
                $scope.accountEntity = result.data[0];
                $scope.accountEntity.Password = "";
            }, function () {
                console.log('Load account category api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }

        function CheckPassword() {
            var config = {
                params: {
                    Username: $scope.accountEntity.Username,
                    action: "checkUsername",
                }
            }
            apiService.get('/eshopcore_war/API-CreateUser', config  , function (result)
            {
                var password = result.data[0].Password;
                if (password== $scope.OldPassword) {
                    if($scope.ConfirmPassword == $scope.accountEntity.Password)
                    {
                        EditAccount();
                    }
                    else
                    {
                        notificationService.displayError("Mật khẩu xác nhận không đúng với mật khẩu");
                    }
                } else {
                    notificationService.displayError("Mật khẩu cũ không đúng");
                }
            }, function () {
                console.log('Load content category api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });
        }


        function EditAccount() {
            apiService.put('/eshopcore_war/API-CreateUser',  JSON.stringify($scope.accountEntity)  , function (result) {
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