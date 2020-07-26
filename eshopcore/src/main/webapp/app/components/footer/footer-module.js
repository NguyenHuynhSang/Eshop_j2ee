/// <reference path="../assets/admin/libs/plugins/angular/angular.js" />

(function () {
    angular.module('eshop-footer', ['eshop-common']).config(config);
    config.$inject = ['$stateProvider', '$urlRouterProvider'];
    function config($stateProvider, $urlRouterProvider) {
        $stateProvider.state('footer-list', {
            parent:'app',
            url: "/footer-list",
            templateUrl: "./app/components/footer/footer-list-view.html",
            controller: "footer-list-controller"
        }).state('footer-create', {
            parent:'app',
            url: "/footer-create",
            templateUrl: "./app/components/footer/footer-create-view.html",
            controller: "footer-create-controller"
        }).state('footer-edit', {
            parent:'app',
            url: "/footer-edit/:id",
            templateUrl: "./app/components/footer/footer-edit-view.html",
            controller: "footer-edit-controller"
        });

    }

    function clearDivFiter() {
jquery('#d').val()


    }


})();

