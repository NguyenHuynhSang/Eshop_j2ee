(function (app) {
    app.controller('product-list-controller', productListController)
    //inject các service cần dùng
    productListController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox','$rootScope'];

    //chú ý thứ tự
    function productListController($scope, apiService, notificationService, $ngBootbox,$rootScope) {

        $rootScope.bodyClass='left-sidebar';

       
    }
})(angular.module('eshop-product'));