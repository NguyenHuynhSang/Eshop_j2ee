(function (app) {
    app.controller('menu-list-controller', menuListController)
    //inject các service cần dùng
    menuListController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox'];

//chú ý thứ tự
    function menuListController($scope, apiService, notificationService, $ngBootbox) {
        $scope.menuList = [];
        $scope.getListmenu = getListMenu;
        $scope.keyWord = '';

        $scope.search = search;
        $scope.delMenu = delMenu;
        $scope.SetActive = setActive;

        function search() {
            getListMenu();
        }

        function delMenu(id) {
            $ngBootbox.confirm('Bạn có chắc muốn xóa?').then(function () {
                var config = {
                    params: {
                        ID: id,
                    }
                }
                apiService.del('/eshopcore_war/API-Menu', config, function () {
                    notificationService.displaySuccess("Xóa thành công bản ghi");
                    getListMenu();
                }, function () {

                });
                notificationService.displaySuccess("Xóa  thành công bản ghi");
                getListMenu();
            });

        }

        function setActive(id)
        {
            $ngBootbox.confirm('Bạn có muốn hiển thị menu này?').then(function()
            {
                apiService.put('/eshopcore_war/MenuServlet',JSON.stringify(id),function()
                {
                    notificationService.displaySuccess("Thành công");
                    getListMenu();
                },function(){

                });
                notificationService.displaySuccess("Thành công");
                getListMenu();
            });
        }

        function getListMenu() {
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            var config = {
                params: {
                    keyword: $scope.keyWord,
                    action: "getAll",
                }
            }

            apiService.get('/eshopcore_war/API-Menu', config, function (result) {
                $scope.menuList = result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy bản ghi nào");
                } else {

                    notificationService.displaySuccess("Tìm thấy " + result.data.length + " bản ghi");
                }


            }, function () {
                console.log('Load menu api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });

        }

        $scope.getListmenu();
    }
})(angular.module('eshop-menu'));