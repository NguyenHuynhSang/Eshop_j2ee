/// <reference path="../assets/admin/libs/plugins/angular/angular.js" />

(function () {
    angular.module('eshop-product', ['eshop-common']).config(config);
    config.$inject = ['$stateProvider', '$urlRouterProvider'];
    function config($stateProvider, $urlRouterProvider) {
        $stateProvider.state('product-edit', {
            url: "/product-edit/:id",
            templateUrl: "/Client_app/components/product/product-edit-view.html",
            controller: "product-edit-controller"
        }).state('product-list', {
            url: "/product-list",
            templateUrl: "/Client_app/components/product/product-list-view.html",
            controller: "product-list-controller"
        }).state('product-single', {
            url: "/product-single",
            templateUrl: "/Client_app/components/product/product-single-view.html",
            controller: "product-create-controller"
        });

    }

})();

