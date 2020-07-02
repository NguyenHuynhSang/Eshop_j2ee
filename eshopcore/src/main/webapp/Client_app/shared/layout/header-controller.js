(function (app) {

    app.controller('header-controller', headerController);
    headerController.$inject = ['$scope', 'api-service', 'notification-service'];
    function headerController($scope, apiService, notificationService) {
    }

})(angular.module('eshop'));