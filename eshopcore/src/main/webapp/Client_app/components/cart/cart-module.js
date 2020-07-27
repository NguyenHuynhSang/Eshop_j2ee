/// <reference path="../assets/admin/libs/plugins/angular/angular.js" />

(function () {
    angular.module('eshop-cart', ['eshop-common']).config(config);
    config.$inject = ['$stateProvider', '$urlRouterProvider'];
    function config($stateProvider, $urlRouterProvider) {
        $stateProvider.state('view-cart', {
            parent: 'app',
            url: "/gio-hang",
            templateUrl: "./Client_app/components/cart/view-cart-view.html",
            controller: "view-cart-controller"
        }).state('check-out', {
            parent: 'app',
            url: "/thanh-toan",
            templateUrl: "./Client_app/components/cart/check-out-view.html",
            controller: "check-out-controller"
        }).state('complete', {
            parent: 'app',
            url: "/thanh-cong",
            templateUrl: "./Client_app/components/cart/complete-view.html",
            controller: "complete-controller"
        });

    }

})();