/// <reference path="../assets/admin/libs/plugins/angular/angular.js" />

(function () {
    angular.module('eshop-content', ['eshop-common']).config(config);
    config.$inject = ['$stateProvider', '$urlRouterProvider'];
    function config($stateProvider, $urlRouterProvider) {
        $stateProvider.state('content-list', {
            url: "/content-list",
            templateUrl: "./app/components/content/content-list-view.html",
            controller: "content-list-controller"
        }).state('content-create', {
            url: "/content-create",
            templateUrl: "./app/components/content/content-create-view.html",
            controller: "content-create-controller"
        }).state('content-edit', {
            url: "/content-edit/:id",
            templateUrl: "./app/components/content/content-edit-view.html",
            controller: "content-edit-controller"
        });
        
        

    }

    function clearDivFiter() {
jquery('#d').val()


    }


})();

