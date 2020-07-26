(function (app) {
    app.controller('view-cart-controller', viewCartController)
    //inject các service cần dùng
    viewCartController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox','$rootScope'];

    //chú ý thứ tự
    function viewCartController($scope, apiService, notificationService, $ngBootbox,$rootScope) {


        $scope.removeProduct=removeProduct;


        $scope.cart={};

        $scope.getCart=getCart;

        function removeProduct(id) {
            var config = {
                params: {
                    productVerID:id,

                }
            }
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            apiService.get('/eshopcore_war/api/RemoveProductInCart', config, function (result) {
                $rootScope.shareGetCart();
                $scope.cart=result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy slides nào");
                } else {
                    notificationService.displaySuccess("[DEV]Tìm đước slides");
                }
            }, function () {
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }


        function getCart() {

            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            apiService.get('/eshopcore_war/api/CartApi', null, function (result) {
                $scope.cart = result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy slides nào");
                } else {
                    notificationService.displaySuccess("[DEV]Tìm đước slides");
                }
            }, function () {
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }

        $scope.getCart();


    }
})(angular.module('eshop-cart'));