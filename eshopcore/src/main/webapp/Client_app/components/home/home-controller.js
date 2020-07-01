(function (app) {

    app.controller('home-controller', homeController);
    homeController.$inject = ['$scope', 'api-service', 'notification-service'];

    function homeController($scope, apiService, notificationService) {
        $scope.slides = [];
        $scope.GetListSlides = GetListSlides;

        jQuery(document).ready(function () {

            jQuery("#owl-example").owlCarousel({
                items : 1,
                nav:false,
                slideSpeed:300,
                dots:true,
                rtl:false,
                paginationSpeed:400,
                navText:["",""],
                margin:0,
                touchDrag:true
            });
            jQuery("#owl-main-slider").owlCarousel({
                items : 3,
                itemsCustom : false,
                itemsDesktop : [1199,2],
                itemsDesktopSmall : [980,2],
                itemsTablet: [768,2],
                itemsTabletSmall: [767,1],
                itemsMobile : [479,1],
                singleItem : false,
                itemsScaleUp : false,
                navigation : true,
                navigationText : ["nav","nav"],
                pagination : false
            });
        });

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
