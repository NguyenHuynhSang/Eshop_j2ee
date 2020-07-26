/// <reference path="../assets/admin/libs/plugins/angular/angular.js" />

(function () {
    angular.module('eshop-statistic', ['eshop-common']).config(config);
    config.$inject = ['$stateProvider', '$urlRouterProvider'];
    function config($stateProvider, $urlRouterProvider) {
        $stateProvider.state('statistic-list', {
            url: "/statistic-list",
            parent:'app',
            templateUrl: "./app/components/statistic/statistic-list-view.html",
            controller: "statistic-list-controller"
        });

    }

})();

