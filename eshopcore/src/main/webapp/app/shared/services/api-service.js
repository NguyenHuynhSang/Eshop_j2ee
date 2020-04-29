(function (app) {
    app.factory('api-service', apiService);

    apiService.$inject = ['$http','notification-service'];
    function apiService($http,notificationService)
    {
        return {
            get:get,
            post:post
        }

        function get(url, params, success, failed) {
            $http.get(url, params).then(function (result) {
                success(result);
            },(function (error) {
                failed(error);
            }));

        }

        function post(url, data, success, failed) {
            $http.post(url, data).then(function (result) {

                success(result);
            },(function (error) {
                if (error.status==='401'){

                    notificationService.displayError('Yêu cầu đăng nhập');
                }
                notificationService.displayError(error);
                failed(error);
            }));

        }

    }

})(angular.module('eshop-common'));