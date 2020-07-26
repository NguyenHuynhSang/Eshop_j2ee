(function (app) {
    app.controller('account-create-controller', accountCreateController)
    accountCreateController.$inject = ['api-service','$scope', 'notification-service','$state'];

    function accountCreateController(apiService,$scope,notificationService,$state) {
        $scope.accountEntity = {};
        $scope.CreateAccount = CreateAccount;
        $scope.keyWord = '';

        $scope.AccountGroup = [
            {
                "Name" : "Admin",
                "ID" : "1"
            },{
                "Name" : "Clientp",
                "ID" : "2"
            }
        ]


        function CreateAccount() {

            apiService.post('/eshopcore_war/API-Account', JSON.stringify($scope.accountEntity)  , function (result) {
                notificationService.displaySuccess("Thêm mới bản ghi thành công");
                $state.go('account-list');
            }, function () {
                console.log('Load account api failed.');
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
            });
        }
    }
})(angular.module('eshop-account'));