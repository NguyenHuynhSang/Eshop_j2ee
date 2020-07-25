(function (app) {
    app.controller('product-single-controller', productSingleController)
    //inject các service cần dùng
    productSingleController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox','$rootScope'];

    //chú ý thứ tự
    function productSingleController($scope, apiService, notificationService, $ngBootbox,$rootScope) {
        $rootScope.bodyClass='single-product full-width';
    }
})(angular.module('eshop-product'));