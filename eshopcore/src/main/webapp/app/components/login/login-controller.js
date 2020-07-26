(function (app) {

    app.controller('login-controller', loginController)
    loginController.$inject = ['api-service', '$scope', 'notification-service', '$state']

    function loginController(apiService, $scope, notificationService, $state) {
        $scope.user = {};
        $scope.isExist = false;
        $scope.isWrongNameOrPass = false;
        $scope.isLocked=false;
        $scope.isClient=false;
        $scope.loginSummit = function () {
            apiService.post('/eshopcore_war/api/login', JSON.stringify($scope.user), function (result) {
                switch (result.data) {
                    case "ERROR": {
                        $scope.isWrongNameOrPass = true;
                        break;
                    }
                    case "EXIST": {
                        $scope.isExist=true;
                        break;
                    }
                    case "COMPLETE":
                    {
                        notificationService.displaySuccess("Đăng nhập thành công");
                        $state.go('home');
                        break;
                    }
                    case "CLIENT":
                    {
                        $scope.isClient=true;
                        break;
                    }
                    case "LOCKED":
                    {
                        $scope.isLocked=true;
                        break;
                    }
                }

            }, function () {
                console.log('Load menu category api failed.');
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
            });


        }

    }
})(angular.module('eshop'));
