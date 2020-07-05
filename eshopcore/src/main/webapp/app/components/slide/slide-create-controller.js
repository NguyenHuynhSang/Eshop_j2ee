(function (app) {
    app.controller('slide-create-controller', slideCreateController)
    slideCreateController.$inject = ['api-service','$scope', 'notification-service','$state'];

    function slideCreateController(apiService,$scope,notificationService,$state) {
        $scope.slideEntity = {};
        $scope.CreateSlide = CreateSlide;
        $scope.keyWord = '';

        function CreateSlide() {
       
            apiService.post('/eshopcore_war/API-Slide', JSON.stringify($scope.slideEntity)  , function (result) {
                notificationService.displaySuccess("Thêm mới bản ghi thành công");
                $state.go('slide-list');
            }, function () {
                console.log('Load slide api failed.');
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
            });
        }
    }
})(angular.module('eshop-slide'));