(function (app) {
    app.controller('complete-controller', completeController)
    //inject các service cần dùng
    completeController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox','$state'];

    //chú ý thứ tự
    function completeController($scope, apiService, notificationService, $ngBootbox,$state) {
        $scope.getCart=getCart;
        $scope.cart={};
    


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