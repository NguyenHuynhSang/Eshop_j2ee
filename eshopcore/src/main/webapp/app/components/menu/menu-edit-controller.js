(function (app) {
    app.controller('menu-edit-controller', menuEditController)
    menuEditController.$inject = ['api-service','$scope', 'notification-service','$state','$stateParams'];

    function menuEditController(apiService,$scope,notificationService,$state,$stateParams) {
        $scope.jsonEntity = {};
        $scope.EditMenu = EditMenu;

        $scope.MenuGroup = [
            {
                "Name" : "Admin",
                "ID" : "1"
            },{
                "Name" : "Clientp",
                "ID" : "2"
            }
        ]

        function LoadMenuByID() {

            var config = {
                params: {
                    keyword: "",
                    ID:$stateParams.id,
                    action: "getByID",
                }
            }

            apiService.get('/eshopcore_war/API-Menu', config, function (result) {
                $scope.jsonEntity = result.data[0];
            }, function () {
                console.log('Load menu category api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }



        function EditMenu() {
            apiService.put('/eshopcore_war/API-Menu',  JSON.stringify($scope.jsonEntity)  , function (result) {
                notificationService.displaySuccess("Sửa bản ghi thành công");
                $state.go('menu-list');
            }, function () {
                console.log('Load menu category api failed.');
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
            });
        }
        LoadMenuByID();

    }
})(angular.module('eshop-menu'));