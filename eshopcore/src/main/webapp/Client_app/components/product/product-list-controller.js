(function (app) {
    app.controller('product-list-controller', productListController)
    //inject các service cần dùng
    productListController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox'];

    //chú ý thứ tự
    function productListController($scope, apiService, notificationService, $ngBootbox) {
       
    }
})(angular.module('eshop-product'));