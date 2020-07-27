(function (app) {
    app.controller('order-detail-controller', orderDetailController)
    //inject các service cần dùng
    orderDetailController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox','$stateParams'];

//chú ý thứ tự
    function orderDetailController($scope, apiService, notificationService, $ngBootbox,$stateParams) {

        $scope.order={};

        $scope.getOrderByID=getOrderByID;

        $scope.getTotalMoneyInCart = getTotalMoneyInCart;

        function getTotalMoneyInCart() {
            if ($scope.order != null) {
                var totalMoney = 0;
                for (i = 0; i < $scope.order.OrderDetails.length; i++) {
                    totalMoney += $scope.order.OrderDetails[i].Price * $scope.order.OrderDetails[i].Quantity;
                }
                return totalMoney;
            }
            return 0;
        }

        function getOrderByID() {
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            var config = {
                params: {
                   ID:$stateParams.id
                }
            }
            apiService.get('/eshopcore_war/api/invoiceSingle', config, function (result) {
                $scope.order = result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy bản ghi nào");
                } else {

                    notificationService.displaySuccess("Tìm thấy " + result.data.length + " bản ghi");
                }


            }, function () {
                console.log('Load product api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });

        }

        $scope.getOrderByID();





    }


})(angular.module('eshop-order'));