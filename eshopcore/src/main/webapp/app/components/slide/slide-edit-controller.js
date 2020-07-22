(function (app) {
    app.controller('slide-edit-controller', slideEditController)
    slideEditController.$inject = ['api-service','$scope', 'notification-service','$state','$stateParams'];

    function slideEditController(apiService,$scope,notificationService,$state,$stateParams) {
        $scope.jsonEntity = {};
        $scope.EditSlide = EditSlide;


        function LoadSlideByID() {

            var config = {
                params: {
                    keyword: "",
                    ID:$stateParams.id,
                    action: "getByID",
                }
            }

            apiService.get('/eshopcore_war/API-Slide', config, function (result) {
                $scope.jsonEntity = result.data[0];
            }, function () {
                console.log('Load slide category api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }

        

        function EditSlide() {
            apiService.put('/eshopcore_war/API-Slide',  JSON.stringify($scope.jsonEntity)  , function (result) {
                notificationService.displaySuccess("Sửa bản ghi thành công");
                $state.go('slide-list');
            }, function () {
                console.log('Load slide category api failed.');
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
            });
        }
        LoadSlideByID();

    }
})(angular.module('eshop-slide'));