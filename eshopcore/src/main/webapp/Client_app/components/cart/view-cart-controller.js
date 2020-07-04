(function (app) {
    app.controller('view-cart-controller', viewCartController)
    //inject các service cần dùng
    viewCartController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox'];

    //chú ý thứ tự
    function viewCartController($scope, apiService, notificationService, $ngBootbox) {

    }
})(angular.module('eshop-cart'));