(function (app) {
    app.controller('product-single-controller', productSingleController)
    //inject các service cần dùng
    productSingleController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox','$rootScope','$stateParams','$sce'];

    //chú ý thứ tự
    function productSingleController($scope, apiService, notificationService, $ngBootbox,$rootScope,$stateParams, $sce) {
        $rootScope.bodyClass='single-product full-width';


        $scope.product={};

        $scope.loadProductByID=loadProductByID;
        $scope.addToCart=addToCart;
        function addToCart(id)
        {
            var config = {
                params: {
                    quantity: 1, //VỚI GET CONFIG LUÔN TRUYỀN ACTION VÀO ĐỂ HÀM DOGET XỬ LÝ TỪNG CASE
                    productVerID:id,

                }
            }
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            apiService.get('/eshopcore_war/api/AddToCart', config, function (result) {
                $rootScope.shareGetCart();
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy slides nào");
                } else {
                    notificationService.displaySuccess("[DEV]Tìm đước slides");
                }
            }, function () {
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });
        }

        function loadProductByID() {

            var config = {
                params: {
                    ID:$stateParams.id,
                }
            }

            apiService.get('/eshopcore_war/api/productSingle', config, function (result) {
                $scope.product = result.data;
                $scope.product.Product.Description = $sce.trustAsHtml(html);
                $scope.product.Product.Content = $sce.trustAsHtml(html);
                if (result.data.length == 0) {
                    //notificationService.displayWarning("Không tìm thấy bản ghi nào");
                } else {

                    //    notificationService.displaySuccess("Tìm thấy " + result.data.length + "bản ghi");
                }


            }, function () {
                console.log('Load product api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }
        $scope.loadProductByID();


    }
})(angular.module('eshop-product'));