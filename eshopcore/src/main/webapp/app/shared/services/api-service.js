
/*
* Các api service chương trình cung cấp
* */
(function (app) {
    app.factory('api-service', apiService);

    apiService.$inject = ['$http','notification-service','$state'];
    function apiService($http,notificationService,$state)
    {
        return {
            get:get,
            post:post,
            put:put,
            del:del

        }

        function get(url, params, success, failed) {
            $http.get(url, params).then(function (result) {
                success(result);
            },(function (error) {
                if (error.status===401){
                    console.log("Chưa đăng nhập");
                    notificationService.displayError('Bạn chưa đăng nhập hoặc không có quyền!');
                    $state.go("login")
                }
                failed(error);
            }));

        }

        function post(url, data, success, failed) {
            $http.post(url, data).then(function (result) {

                success(result);
            },(function (error) {
                if (error.status===401){
                    console.log("Chưa đăng nhập");
                    $state.go("login")
                    notificationService.displayError('Bạn chưa đăng nhập hoặc không có quyền!');
                }
                notificationService.displayError(error);
                failed(error);
            }));

        }

        function del(url, data, success, failed) {
            $http.delete(url, data).then(function (result) {
                success(result);
            },(function (error) {
                if (error.status===401){

                    notificationService.displayError('Bạn chưa đăng nhập hoặc không có quyền!');
                    $state.go("login")
                }
                /// Server java không hỗ trợ delete???
             //   notificationService.displayError(error);
         //       failed(error);
            }));

        }

        function put(url, data, success, failed) {
            $http.put(url, data).then(function (result) {

                success(result);
            },(function (error) {
                if (error.status===401){

                    notificationService.displayError('Yêu cầu đăng nhập');
                }
                notificationService.displayError(error);
                failed(error);
            }));

        }

        f
    }

})(angular.module('eshop-common'));