(function (app) {

    app.controller('login-controller',loginController)
    loginController.$inject=['$scope','$state']
    function loginController($scope,$state) {
        $scope.loginSummit=function () {
            $state.go('home');
        }

    }
})(angular.module('eshop'));
