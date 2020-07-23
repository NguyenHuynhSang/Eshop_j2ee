/// <reference path="../assets/admin/libs/plugins/angular/angular.js" />

(function () {
    angular.module('eshop-content', ['eshop-common']).config(config);
    config.$inject = ['$stateProvider', '$urlRouterProvider'];
    function config($stateProvider, $urlRouterProvider) {
        $stateProvider.state('content-list', {
            parent: 'app',
            url: "/blog",
            templateUrl: "./Client_app/components/content/content-list-view.html",
            controller: "content-list-controller"
        }).state('content-single', {
            parent: 'app',
            url: "/content-single/:meta-:id",
            templateUrl: "./Client_app/components/content/content-single-view.html",
            controller: "content-single-controller"
        });

    }

})();

