﻿/// <reference path="../assets/admin/libs/plugins/angular/angular.js" />Ư

(function () {
    angular.module('eshop', ['eshop-product', 'eshop-order', 'eshop-catalog','eshop-cart', 'eshop-common','eshop-content']).config(config);

    config.$inject = ['$stateProvider', '$urlRouterProvider'];

    function config($stateProvider, $urlRouterProvider) {

        $stateProvider.state('app',
            {
                views: {
                    'content': {
                        template: "<div ui-view></div>",
                    },
                    'header': {
                        templateUrl: "./Client_app/shared/layout/header-view.html",
                        controller:'header-controller'
                    },
                    'footer': {
                        templateUrl: "./Client_app/shared/layout/footer-view.html",
                        controller:'footer-controller'
                    },
                }

            }).state('home', {
            parent: 'app',
            url: "/home",
            //missing a fucking dot
            templateUrl: "./Client_app/components/home/home-view.html",
            controller: "home-controller"
        });


        //bắt lỗi 404 điều hướng tại đây
        $urlRouterProvider.otherwise('/home');
    }


})();