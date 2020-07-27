(function (app) {
    app.controller('account-create-controller', accountCreateController)
    accountCreateController.$inject = ['api-service','$scope', 'notification-service','$state'];

    function accountCreateController(apiService,$scope,notificationService,$state) {
        $scope.accountEntity = {};
        $scope.CreateAccount = CreateAccount;
        $scope.keyWord = '';

        $scope.ExistAccount=[];
        $scope.CheckExistAccount = CheckExistAccount;

        $scope.confirmPassword = "";

        $scope.AccountGroup = [
            {
                "Name" : "Admin",
                "ID" : "1"
            },{
                "Name" : "Clientp",
                "ID" : "2"
            }
        ]

        function CheckExistAccount() {
            var config = {
                params: {
                    Username: $scope.accountEntity.Username,
                    action: "checkUsername",
                }
            }
            apiService.get('/eshopcore_war/API-CreateUser', config  , function (result)
            {
            if (result.data.length == 0) {
                if($scope.confirmPassword == $scope.accountEntity.Password)
                {
                    CreateAccount();
                }
                else
                {
                    notificationService.displayError("Mật khẩu xác nhận không đúng với mật khẩu");
                }
            } else {
                notificationService.displayError("Username đã tồn tại, vui lòng nhập lại username");
            }
            }, function () {
                console.log('Load content category api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });
        }

        function CreateAccount() {
            apiService.post('/eshopcore_war/API-CreateUser', JSON.stringify($scope.accountEntity)  , function (result) {
                notificationService.displaySuccess("Thêm mới bản ghi thành công");
                $state.go('account-list');
            }, function () {
                console.log('Load account api failed.');
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
            });
        }
    }
})(angular.module('eshop-account'));