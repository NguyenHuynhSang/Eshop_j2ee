/// <reference path="../assets/admin/libs/plugins/angular/angular.js" />

(function () {
    angular.module('eshop-slide', ['eshop-common']).config(config);
    config.$inject = ['$stateProvider', '$urlRouterProvider'];
    function config($stateProvider, $urlRouterProvider) {
        $stateProvider.state('slide-list', {
            url: "/slide-list",
            parent:'app',
            templateUrl: "./app/components/slide/slide-list-view.html",
            controller: "slide-list-controller"
        }).state('slide-create', {
            url: "/slide-create",
            parent:'app',
            templateUrl: "./app/components/slide/slide-create-view.html",
            controller: "slide-create-controller"
        }).state('slide-edit', {
            url: "/slide-edit/:id",
            parent:'app',
            templateUrl: "./app/components/slide/slide-edit-view.html",
            controller: "slide-edit-controller"
        });
        

    }

    function clearDivFiter() {
jquery('#d').val()


    }


})();

