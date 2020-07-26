/// <reference path="../assets/admin/libs/plugins/angular/angular.js" />

(function () {
    angular.module('eshop-menu', ['eshop-common']).config(config);
    config.$inject = ['$stateProvider', '$urlRouterProvider'];
    function config($stateProvider, $urlRouterProvider) {
        $stateProvider.state('menu-list', {
            parent:'app',
            url: "/menu-list",
            templateUrl: "./app/components/menu/menu-list-view.html",
            controller: "menu-list-controller"
        }).state('menu-create', {
            parent:'app',
            url: "/menu-create",
            templateUrl: "./app/components/menu/menu-create-view.html",
            controller: "menu-create-controller"
        }).state('menu-edit', {
            parent:'app',
            url: "/menu-edit/:id",
            templateUrl: "./app/components/menu/menu-edit-view.html",
            controller: "menu-edit-controller"
        });


    }

    function clearDivFiter() {
        jquery('#d').val()


    }


})();

