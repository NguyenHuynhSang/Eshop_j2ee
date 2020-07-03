(function (app) {

    app.controller('header-controller', headerController);
    headerController.$inject = ['$scope', 'api-service', 'notification-service','$rootScope'];
    function headerController($scope, apiService, notificationService,$rootScope) {
        $rootScope.keyword='';
        $rootScope.shareOrder={};
        $rootScope.shareGetCart=getCart;

        $scope.liveSearchProduct=liveSearchProduct;
        function liveSearchProduct() {
        var a= $scope.keyword;

        }

        function getCart() {

            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            apiService.get('/eshopcore_war/api/CartApi', null, function (result) {
                $rootScope.shareOrder = result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy slides nào");
                } else {
                    notificationService.displaySuccess("[DEV]Tìm đước slides");
                }
            }, function () {
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }
        $rootScope.shareGetCart();
    }

})(angular.module('eshop'));