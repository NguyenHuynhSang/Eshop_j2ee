(function (app) {
    app.controller('check-out-controller', checkOutController)
    //inject các service cần dùng
    checkOutController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox'];

    //chú ý thứ tự
    function checkOutController($scope, apiService, notificationService, $ngBootbox) {

    }
})(angular.module('eshop-cart'));