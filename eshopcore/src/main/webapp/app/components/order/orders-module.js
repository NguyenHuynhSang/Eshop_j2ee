/// <reference path="../assets/admin/libs/plugins/angular/angular.js" />

(function () {
    angular.module('eshop-order', ['eshop-common']).config(config);
    config.$inject = ['$stateProvider', '$urlRouterProvider'];
    function config($stateProvider, $urlRouterProvider) {
        $stateProvider.state('order-list', {
            parent:'app',
            url: "/order-list",
            templateUrl: "./app/components/order/order-list-view.html",
            controller: "order-list-controller"
        }).state('order-detail', {
            parent:'app',
            url: "/order-detail/:id",
            templateUrl: "./app/components/order/order-detail-view.html",
            controller: "order-detail-controller"
        });

    }

    function clearDivFiter() {
jquery('#d').val()


    }


})();

