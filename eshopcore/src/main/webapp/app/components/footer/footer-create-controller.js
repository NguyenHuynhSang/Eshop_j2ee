(function (app) {
    app.controller('footer-create-controller', footerCreateController)
    footerCreateController.$inject = ['api-service','$scope', 'notification-service','$state'];

    function footerCreateController(apiService,$scope,notificationService,$state) {
        $scope.footerEntity = {};
        $scope.CreateFooter = CreateFooter;
        $scope.footercategoryList =[];
        $scope.keyWord = '';

        function CreateFooter() {
       
            apiService.post('/eshopcore_war/API-Footer', JSON.stringify($scope.footerEntity)  , function (result) {
                notificationService.displaySuccess("Thêm mới bản ghi thành công");
                $state.go('footer-list');
            }, function () {
                console.log('Load footer api failed.');
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
            });
        }
    }
})(angular.module('eshop-footer'));