(function (app) {
    app.controller('order-list-controller', orderListListController)
    //inject các service cần dùng
    orderListListController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox'];

//chú ý thứ tự
    function orderListListController($scope, apiService, notificationService, $ngBootbox) {

        $scope.ordersList=[];
        $scope.search = search;
        $scope.reset = resetFunct;
        $scope.isReset=false;

        $scope.acviveInvoice=acviveInvoice;


        $scope.orderFilter={
            ID:null,
            fromDate:null,
            toDate:null,
            customerName:null,
            customerPhone:null,
            fromPrice:null,
            toPrice:null,
            fromQuantity:null,
            toQuantity:null,
            Status:null,
            email:null,
        };

        function resetFunct() {
            $scope.isReset=true;
            $scope.orderFilter = {};
            getListOrders();
        }


        function acviveInvoice(id,code) {
            var config = {
                params: {
                    ID: id,
                    Code:code,
                }
            }
            apiService.get('/eshopcore_war/api/invoiceActive', config, function (result) {
                notificationService.displaySuccess("Thành công");
                    getListOrders();
            }, function () {
                console.log('Load product api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });
        }



        function search() {
            $scope.isReset=true;
            getListOrders();
        }
        $scope.getListOrders=getListOrders;
        function getListOrders() {
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            var config = {
                params: {
                    filterJson: angular.toJson($scope.orderFilter)
                }
            }
            apiService.get('/eshopcore_war/api/invoice', config, function (result) {
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


})(angular.module('eshop-order'));