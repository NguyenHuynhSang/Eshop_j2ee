(function (app) {
    app.controller('footer-edit-controller', footerEditController)
    footerEditController.$inject = ['api-service','$scope', 'notification-service','$state','$stateParams'];

    function footerEditController(apiService,$scope,notificationService,$state,$stateParams) {
        $scope.jsonEntity = {};
        $scope.EditFooter = EditFooter;


        function LoadFooterByID() {

            var config = {
                params: {
                    keyword: "",
                    ID:$stateParams.id,
                    action: "getByID",
                }
            }

            apiService.get('/eshopcore/API-Footer', config, function (result) {
                $scope.jsonEntity = result.data[0];
            }, function () {
                console.log('Load footer category api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }

        

        function EditFooter() {
            apiService.put('/eshopcore/API-Footer',  JSON.stringify($scope.jsonEntity)  , function (result) {
                notificationService.displaySuccess("Sửa bản ghi thành công");
                $state.go('footer-list');
            }, function () {
                console.log('Load footer category api failed.');
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
            });
        }
        LoadFooterByID();

    }
})(angular.module('eshop-slide'));