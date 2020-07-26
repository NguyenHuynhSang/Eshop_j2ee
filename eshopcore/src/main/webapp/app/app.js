/// <reference path="../assets/admin/libs/plugins/angular/angular.js" />

(function () {
    angular.module('eshop', ['eshop-product', 'eshop-order', 'eshop-catalog', 'eshop-common', 'eshop-contentcategory', 'eshop-content', 'eshop-footer', 'eshop-slide', 'eshop-menu']).config(config);

    config.$inject = ['$stateProvider', '$urlRouterProvider', '$locationProvider'];

    function config($stateProvider, $urlRouterProvider, $locationProvider) {
        $stateProvider.state('app', {
            views: {
                'base': {
                    templateUrl: "./app/shared/layout/base-view.html",
                },
            }
        }).state('other', {
            views: {
                'other': {
                    template: "<div ui-view></div>",
                }
            }
        }).state('login', {
            parent:'other',
            url: "/login",
            templateUrl: "./app/components/login/login-view.html",
            controller: "login-controller"
        }).state('home', {
            parent:'app',
            url: "/home",
            templateUrl: "./app/components/home/home-view.html",
            controller: "home-controller"
        });

        //remove #! from url
        // $locationProvider.html5Mode({
        //     enabled: true,
        //     requireBase: false
        // });

        //bắt lỗi 404 điều hướng tại đây
         $urlRouterProvider.otherwise('/home');
    }

})();