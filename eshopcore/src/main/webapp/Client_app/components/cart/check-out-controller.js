(function (app) {
    app.controller('check-out-controller', checkOutController)
    //inject các service cần dùng
    checkOutController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox','$state'];

    //chú ý thứ tự
    function checkOutController($scope, apiService, notificationService, $ngBootbox,$state) {
        $scope.getCart=getCart;
        $scope.cart={};
        $scope.checkOut=checkOut;
        
        function checkOut() {
            apiService.post('/eshopcore_war/api/CheckOut', $scope.cart, function (result) {
                notificationService.displaySuccess("Thêm mới bản ghi thành công");

                $state.go('catalog-list');
            }, function () {
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
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