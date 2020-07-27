(function (app) {
    app.controller('product-list-controller', productListController)
    //inject các service cần dùng
    productListController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox', '$rootScope', '$stateParams'];

    //chú ý thứ tự
    function productListController($scope, apiService, notificationService, $ngBootbox, $rootScope, $stateParams) {

        $rootScope.bodyClass = 'left-sidebar';
        $scope.products = [];
        $scope.productFilter =
            {
                startPrice: null,
                endPrice: null,
                CatalogID: null,
                orderBy: 1,
                Name: null,
            }
        $scope.getProducts = getProducts;
        $scope.catalogs = [];

        $scope.getListCatalog = getListCatalog;

        function getListCatalog() {
            var config = {
                params: {
                    action: "getAll", //VỚI GET CONFIG LUÔN TRUYỀN ACTION VÀO ĐỂ HÀM DOGET XỬ LÝ TỪNG CASE
                }
            }
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            apiService.get('/eshopcore_war/api/Catalog', config, function (result) {
                $scope.catalogs=result.data;

                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy slides nào");
                } else {
                    notificationService.displaySuccess("[DEV]Tìm đước slides");
                }
            }, function () {
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });

        }


        $scope.addToCart = addToCart;


        $scope.search = search;

        function search() {
            getProducts();
        }


        function addToCart(id) {
            var config = {
                params: {
                    quantity: 1, //VỚI GET CONFIG LUÔN TRUYỀN ACTION VÀO ĐỂ HÀM DOGET XỬ LÝ TỪNG CASE
                    productVerID: id,

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

        function getProducts() {
            $scope.productFilter.Name = $stateParams.key;
            var config = {
                params: {
                    filterJson: angular.toJson($scope.productFilter)
                }
            }


            apiService.get('/eshopcore_war/api/productList', config, function (result) {
                $scope.products = result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy slides nào");
                } else {
                    notificationService.displaySuccess("[DEV]Tìm đước slides");
                }
            }, function () {
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }

        $scope.getProducts();
        $scope.getListCatalog();

    }
})(angular.module('eshop-product'));