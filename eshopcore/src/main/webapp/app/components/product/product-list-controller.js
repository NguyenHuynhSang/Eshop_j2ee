﻿(function (app) {
    app.controller('product-list-controller', productListController)
    //inject các service cần dùng
    productListController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox'];

    //chú ý thứ tự
    function productListController($scope, apiService, notificationService, $ngBootbox) {
        $scope.productList = [];
        $scope.advanceSearch = false;
        $scope.miniminePrice = true;
        $scope.showAuditlog = false;
        $scope.getListProduct = getListProduct;
        $scope.isReset=false;
        $scope.productFilter = {
            startPrice: null,
            endPrice: null,
            startOriginalPrice: null,
            endOriginalPrice: null,
            ID: null,
            CatalogID: null,
            Name: null,
            startQuantity: null,
            endQuantiy: null,

        };

        $scope.keyWord = '';
        $scope.search = search;
        $scope.reset = resetFunct;


        function resetFunct() {
            $scope.isReset=true;
            $scope.productFilter = {};
            getListProduct();
        }

        $scope.delProduct = delProduct;


        function search() {

            getListProduct();
        }

        function delProduct(id) {
            $ngBootbox.confirm('Bạn có chắc muốn xóa?').then(function () {
                var config = {
                    params: {
                        ID: id,
                    }
                }
                apiService.del('/eshopcore_war/api/Product/GetAll', config, function () {
                    notificationService.displaySuccess("Xóa  thành công bản ghi");
                    getListProduct();
                }, function () {

                });
                notificationService.displaySuccess("Xóa  thành công bản ghi");
                getListProduct();
            });
            b
        }

        function getListProduct() {
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/

            var config = {
                params: {
                    filterJson: angular.toJson($scope.productFilter)
                }
            }

            apiService.get('/eshopcore_war/api/Product', config, function (result) {
                $scope.productList = result.data;
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

        $scope.getListProduct();
    }
})(angular.module('eshop-product'));