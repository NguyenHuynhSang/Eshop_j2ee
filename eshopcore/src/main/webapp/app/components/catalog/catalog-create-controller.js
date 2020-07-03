(function (app) {
    app.controller('catalog-create-controller', catalogCreateController)
    catalogCreateController.$inject = ['api-service', '$scope', 'notification-service', '$state'];
    function catalogCreateController(apiService, $scope, notificationService, $state) {
        $scope.catalogInput = {};
        $scope.parentCatalogs=[];


        $scope.submit = function () {
            CreateCatalog();
        }
        function getListParentCatalog() {
            var config = {
                params: {
                    action: "getParents",
                }
            }
            apiService.get('/eshopcore_war/api/Catalog', config, function (result) {
                $scope.parentCatalogs = result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy bản ghi nào");
                } else {

                    notificationService.displaySuccess("Tìm thấy " + result.data.length + " bản ghi");
                }
            }, function () {
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });
        }

        /// Chưa dùng đến
        function CreateCatalog() {
            apiService.post('/eshopcore_war/api/Catalog', $scope.catalogInput, function (result) {
                notificationService.displaySuccess("Thêm mới bản ghi thành công");
                $state.go('catalog-list');
            }, function () {
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
            });
        }
        getListParentCatalog();
        //  GetListAttributeValue();
    }








})(angular.module('eshop-catalog'));

