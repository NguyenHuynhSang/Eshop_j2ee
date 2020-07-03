(function (app) {

    app.controller('footer-controller', footerController);
    footerController.$inject = ['$scope', 'api-service', 'notification-service'];
    function footerController($scope, apiService, notificationService) {
    }

})(angular.module('eshop'));