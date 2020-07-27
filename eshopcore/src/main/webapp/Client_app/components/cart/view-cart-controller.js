(function (app) {
    app.controller('view-cart-controller', viewCartController)
    //inject các service cần dùng
    viewCartController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox','$rootScope'];

    //chú ý thứ tự
    function viewCartController($scope, apiService, notificationService, $ngBootbox,$rootScope) {

        $rootScope.bodyClass='single-product full-width';
        $scope.removeProduct=removeProduct;


        $scope.cart={};

        $scope.getCart=getCart;


        $scope.addToCart=addToCart;

        function addToCart(id,quantity)
        {
            var config = {
                params: {
                    quantity: quantity, //VỚI GET CONFIG LUÔN TRUYỀN ACTION VÀO ĐỂ HÀM DOGET XỬ LÝ TỪNG CASE
                    productVerID:id,

                }
            }
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            apiService.get('/eshopcore_war/api/AddToCart', config, function (result) {
                $rootScope.shareGetCart();
                $scope.getCart();
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy slides nào");
                } else {
                    notificationService.displaySuccess("[DEV]Tìm đước slides");
                }
            }, function () {
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });
        }

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

        $scope.getTotalMoneyInCart = getTotalMoneyInCart;

        function getTotalMoneyInCart() {
            if ($scope.cart != null) {
                var totalMoney = 0;

                for (i = 0; i < $scope.cart.OrderDetails.length; i++) {
                    totalMoney += $scope.cart.OrderDetails[i].Price * $scope.cart.OrderDetails[i].Quantity;
                }
                return totalMoney;
            }
            return 0;
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