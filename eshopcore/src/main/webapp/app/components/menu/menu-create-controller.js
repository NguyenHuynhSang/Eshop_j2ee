(function (app) {
    app.controller('menu-create-controller', menuCreateController)
    menuCreateController.$inject = ['api-service','$scope', 'notification-service','$state'];

    function menuCreateController(apiService,$scope,notificationService,$state) {
        $scope.menuEntity = {};
        $scope.CreateMenu = CreateMenu;
        $scope.keyWord = '';

        $scope.MenuGroup = [
            {
                "Name" : "Admin",
                "ID" : "1"
            },{
                "Name" : "Clientp",
                "ID" : "2"
            }
        ]


        function CreateMenu() {

            apiService.post('/eshopcore_war/API-Menu', JSON.stringify($scope.menuEntity)  , function (result) {
                notificationService.displaySuccess("Thêm mới bản ghi thành công");
                $state.go('menu-list');
            }, function () {
                console.log('Load menu api failed.');
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
            });
        }
    }
})(angular.module('eshop-menu'));