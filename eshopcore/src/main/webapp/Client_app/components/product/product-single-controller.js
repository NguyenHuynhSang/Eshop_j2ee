(function (app) {
    app.controller('product-single-controller', productSingleController)
    //inject các service cần dùng
    productSingleController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox'];

    //chú ý thứ tự
    function productSingleController($scope, apiService, notificationService, $ngBootbox) {

    }
})(angular.module('eshop-product'));