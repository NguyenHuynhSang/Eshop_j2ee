/// <reference path="../assets/admin/libs/plugins/angular/angular.js" />

(function () {
    angular.module('eshop-product', ['eshop-common']).config(config);
    config.$inject = ['$stateProvider', '$urlRouterProvider'];
    function config($stateProvider, $urlRouterProvider) {
        $stateProvider.state('product-list', {
            url: "/san-pham",
            templateUrl: "./Client_app/components/product/product-list-view.html",
            controller: "product-list-controller"
        }).state('product-single', {
            parent: 'app',
            url: "/product-single/:meta-:id",
            templateUrl: "./Client_app/components/product/product-single-view.html",
            controller: "product-single-controller"
        });

    }

})();

