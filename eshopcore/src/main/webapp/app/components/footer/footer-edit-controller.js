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
                $scope.jsonEntity = result.data;
                if (result.data.length == 0) {
                    //notificationService.displayWarning("Không tìm thấy bản ghi nào");
                } else {

                    //notificationService.displaySuccess("Tìm thấy " + result.data.length + "bản ghi");
                }
            }, function () {
                console.log('Load footer api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }


        function EditFooter() {
            apiService.put('/eshopcore/API-Footer',  JSON.stringify($scope.jsonEntity)  , function (result) {
                notificationService.displaySuccess("Sửa bản ghi thành công");
                $state.go('footer-list');
            }, function () {
                console.log('Load footer api failed.');
                notificationService.displayError("Sửa bản ghi KHÔNG thành công");
            });
        }
        LoadFooterByID();
    }
})(angular.module('eshop-footer'));