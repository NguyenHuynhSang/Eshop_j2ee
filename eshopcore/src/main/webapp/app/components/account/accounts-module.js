/// <reference path="../assets/admin/libs/plugins/angular/angular.js" />

(function () {
    angular.module('eshop-account', ['eshop-common']).config(config);
    config.$inject = ['$stateProvider', '$urlRouterProvider'];
    function config($stateProvider, $urlRouterProvider) {
        $stateProvider.state('account-edit', {
            url: "/account-edit/:id",
            parent:'app',
            templateUrl: "./app/components/account/account-edit-view.html",
            controller: "account-edit-controller"
        }).state('account-list', {
            url: "/account-list",
            parent:'app',
            templateUrl: "./app/components/account/statistic-list-view.html",
            controller: "account-list-controller"
        }).state('account-create', {
            url: "/account-create",
            parent:'app',
            templateUrl: "./app/components/account/account-create-view.html",
            controller: "account-create-controller"
        });

    }

})();

