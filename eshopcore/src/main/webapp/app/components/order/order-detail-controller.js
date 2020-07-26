(function (app) {
    app.controller('order-detail-controller', orderDetailController)
    //inject các service cần dùng
    orderDetailController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox'];

//chú ý thứ tự
    function orderDetailController($scope, apiService, notificationService, $ngBootbox) {

        $scope.ordersList=[];
        $scope.productFilter={};

        $scope.getListOrders=getListOrders;
        function getListOrders() {
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            var config = {
                params: {
                    filterJson: angular.toJson($scope.productFilter)
                }
            }
            apiService.get('/eshopcore_war/api/invoice', null, function (result) {
                $scope.ordersList = result.data;
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







    }


})(angular.module('eshop-order'));