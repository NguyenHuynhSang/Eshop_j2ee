(function (app) {

    app.controller('home-controller', homeController);
    homeController.$inject = ['$scope', 'api-service', 'notification-service'];

    function homeController($scope, apiService, notificationService) {
        $scope.slides = [];
        $scope.GetListSlides = GetListSlides;


        angular.element(document).ready(function () {

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

        });

            // jQuery("#product-add-carousel").owlCarousel({
            //     items : 1,
            //     nav:false,
            //     slideSpeed:300,
            //     dots:true,
            //     rtl:false,
            //     paginationSpeed:400,
            //     navText:["",""],
            //     margin:0,
            //     touchDrag:true
            // });





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



    app.directive("owlCarousel", function() {
        return {
            restrict: 'E',
            transclude: false,
            link: function (scope) {
                scope.initCarousel = function(element) {
                    // provide any default options you want
                    var defaultOptions = {
                    };
                    var customOptions = scope.$eval(jQuery(element).attr('data-options'));
                    // combine the two options objects
                    for(var key in customOptions) {
                        defaultOptions[key] = customOptions[key];
                    }
                    // init carousel
                    jQuery(element).owlCarousel(defaultOptions);
                };
            }
        };
    })
    app.directive('owlCarouselItem', [function() {
            return {
                restrict: 'A',
                transclude: false,
                link: function(scope, element) {
                    // wait for the last item in the ng-repeat then call init
                    if(scope.$last) {
                        scope.initCarousel(element.parent());
                    }
                }
            };
        }]);


})(angular.module('eshop'));

