(function (app) {
    app.controller('order-edit-controller', orderEditController)
    //inject các service cần dùng
    orderEditController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox', '$stateParams'];

//chú ý thứ tự
    function orderEditController($scope, apiService, notificationService, $ngBootbox, $stateParams) {

        $scope.order = {};

        $scope.getOrderByID = getOrderByID;

        $scope.getTotalMoneyInCart = getTotalMoneyInCart;


        $scope.updateOrder = updateOrder;

        function updateOrder() {
            apiService.put('/eshopcore_war/api/invoiceEdit', JSON.stringify($scope.order), function (result) {
                notificationService.displaySuccess("Sửa bản ghi thành công");
                $state.go('order-list');
            }, function () {
                console.log('Load product api failed.');
                notificationService.displayError("Sửa bản ghi KHÔNG thành công");
            });
        }

        $scope.submit = submit;


        function submit() {
            updateOrder();
        }


        function getTotalMoneyInCart() {
            if ($scope.order != null) {
                var totalMoney = 0;
                for (i = 0; i < $scope.order.orderEdits.length; i++) {
                    totalMoney += $scope.order.orderEdits[i].Price * $scope.order.orderEdits[i].Quantity;
                }
                return totalMoney;
            }
            return 0;
        }

        function getOrderByID() {
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            var config = {
                params: {
                    ID: $stateParams.id
                }
            }
            apiService.get('/eshopcore_war/api/invoiceEdit', config, function (result) {
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