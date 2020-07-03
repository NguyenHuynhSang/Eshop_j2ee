(function (app) {

    app.controller('header-controller', headerController);
    headerController.$inject = ['$scope', 'api-service', 'notification-service'];
    function headerController($scope, apiService, notificationService) {
        $scope.keyword='';
        $scope.liveSearchProduct=liveSearchProduct;
        function liveSearchProduct() {
        var a= $scope.keyword;


        }
        
    }

})(angular.module('eshop'));