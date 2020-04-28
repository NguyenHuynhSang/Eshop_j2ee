(function (app) {
    app.controller('product-list-controller', productListController)
    productListController.$inject = ['$scope', 'api-service','notification-service'];

    function productListController($scope, apiService,notificationService) {
        $scope.productList = [];
        $scope.getListProduct = getListProduct;

        function getListProduct() {
            apiService.get('/eshopcore_war/api/json', null, function (result) {
                $scope.productList = result.data;
                if (result.data.TotalCount==0){
                    notificationService.displayWarning("Không tìm thấy bản ghi nào");

                }


            }, function () {
                console.log('Load product api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });

        }

        $scope.getListProduct();
    }
})(angular.module('eshop-product'));