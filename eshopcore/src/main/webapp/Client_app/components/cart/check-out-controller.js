(function (app) {
    app.controller('check-out-controller', checkOutController)
    //inject các service cần dùng
    checkOutController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox','$state'];

    //chú ý thứ tự
    function checkOutController($scope, apiService, notificationService, $ngBootbox,$state) {
        $scope.getCart=getCart;
        $scope.cart={};
        $scope.checkOut=checkOut;


        $scope.disableCheckOut=false;
        function checkOut() {
            $scope.disableCheckOut=true;
            apiService.post('/eshopcore_war/api/CheckOut', angular.toJson($scope.cart), function (result) {
                notificationService.displaySuccess("Thêm mới bản ghi thành công");
                $state.go('complete');
            }, function () {
                $state.go('complete');
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
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