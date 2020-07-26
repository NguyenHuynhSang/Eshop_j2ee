/// <reference path="../assets/admin/libs/plugins/angular/angular.js" />

(function () {
    angular.module('eshop-contentcategory', ['eshop-common']).config(config);
    config.$inject = ['$stateProvider', '$urlRouterProvider'];
    function config($stateProvider, $urlRouterProvider) {
        $stateProvider.state('contentcategory-list', {
            parent:'app',
            url: "/contentcategory-list",
            templateUrl: "./app/components/contentcategory/contentcategory-list-view.html",
            controller: "contentcategory-list-controller"
        }).state('contentcategory-create', {
            parent:'app',
            url: "/contentcategory-create",
            templateUrl: "./app/components/contentcategory/contentcategory-create-view.html",
            controller: "contentcategory-create-controller"
        }).state('contentcategory-edit', {
            parent:'app',
            url: "/contentcategory-edit/:id",
            templateUrl: "./app/components/contentcategory/contentcategory-edit-view.html",
            controller: "contentcategory-edit-controller"
        });

    }

    function clearDivFiter() {
jquery('#d').val()


    }


})();

