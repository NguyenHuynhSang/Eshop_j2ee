(function (app) {

    app.controller('home-controller', homeController);
    homeController.$inject = ['$scope', 'api-service', 'notification-service'];

    function homeController($scope, apiService, notificationService) {
        $scope.slides = [];
        $scope.GetListSlides = GetListSlides;

        function GetListSlides() {
            var config = {
                params: {
                    action: "getSlide", //VỚI GET CONFIG LUÔN TRUYỀN ACTION VÀO ĐỂ HÀM DOGET XỬ LÝ TỪNG CASE
                }
            }
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            apiService.get('/eshopcore_war/api/homePage', config, function (result) {
                $scope.slides = result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy slides nào");
                } else {
                    notificationService.displaySuccess("[DEV]Tìm đước slides");
                }
            }, function () {
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }

        $scope.GetListSlides();
    }
})(angular.module('eshop'));
