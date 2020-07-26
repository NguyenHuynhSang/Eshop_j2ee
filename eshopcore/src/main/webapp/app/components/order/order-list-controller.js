(function (app) {
    app.controller('order-list-controller', orderListListController)
    //inject các service cần dùng
    orderListListController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox'];

//chú ý thứ tự
    function orderListListController($scope, apiService, notificationService, $ngBootbox) {

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






        $scope.getListOrders();





    }


})(angular.module('eshop-product'));