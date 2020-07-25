(function (app) {

    app.controller('home-controller', homeController);
    homeController.$inject = ['$scope', 'api-service', 'notification-service','$rootScope'];

    function homeController($scope, apiService, notificationService,$rootScope) {
        $scope.slides = [];
        $scope.GetListSlides = GetListSlides;

        $scope.newProducts=[];
        $scope.GetListNewProducts = GetListNewProducts;

        $rootScope.bodyClass='single-product full-width';
        $scope.addToCart=addToCart;



        function addToCart(id)
        {
            var config = {
                params: {
                    quantity: 1, //VỚI GET CONFIG LUÔN TRUYỀN ACTION VÀO ĐỂ HÀM DOGET XỬ LÝ TỪNG CASE
                    productVerID:id,

                }
            }
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            apiService.get('/eshopcore_war/api/AddToCart', config, function (result) {
                $rootScope.shareGetCart();

                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy slides nào");
                } else {
                    notificationService.displaySuccess("[DEV]Tìm đước slides");
                }
            }, function () {
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });
        }

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

        function GetListNewProducts() {
            var config = {
                params: {
                    action: "getNewProduct", //VỚI GET CONFIG LUÔN TRUYỀN ACTION VÀO ĐỂ HÀM DOGET XỬ LÝ TỪNG CASE
                }
            }
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            apiService.get('/eshopcore_war/api/homePage', config, function (result) {
                $scope.newProducts = result.data;

                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy slides nào");
                } else {
                    notificationService.displaySuccess("[DEV]Tìm đước slides");
                }
            }, function () {
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }
        $scope.GetListNewProducts();
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


    app.directive('addToCartButton', function() {
        function link(scope, element, attributes) {
            element.on('click', function(event){
                var cartElem = angular.element(document.getElementsByClassName("navbar-mini-cart"));
                console.log(cartElem);
                var offsetTopCart = cartElem.prop('offsetTop');
                var offsetLeftCart = cartElem.prop('offsetLeft');
                var widthCart = cartElem.prop('offsetWidth');
                var heightCart = cartElem.prop('offsetHeight');
                var imgElem = angular.element(event.target.parentNode.parentNode.childNodes[3].childNodes[3].childNodes[1]);
                var parentElem = angular.element(event.target.parentNode.parentNode);
                var offsetLeft = imgElem.prop("offsetLeft");
                var offsetTop = imgElem.prop("offsetTop");
                var width=imgElem.prop("width");
                var height=imgElem.prop("height")
                var imgSrc = imgElem.prop("currentSrc");
                console.log(offsetLeft + ' ' + offsetTop + ' ' + imgSrc);
                var imgClone = angular.element('<img src="' + imgSrc + '"/>');
                imgClone.css({
                    'height': height,
                    'position': 'absolute',
                    'top': offsetTop + 'px',
                    'left': offsetLeft + 'px',
                    'opacity': 0.5
                });
                imgClone.addClass('itemaddedanimate');
                parentElem.append(imgClone);
                setTimeout(function () {
                    imgClone.css({
                        'height': '75px',
                        'top': (offsetTopCart+heightCart/2)+'px',
                        'left': (offsetLeftCart+widthCart/2)+'px',
                        'opacity': 0.5
                    });
                }, 500);
                setTimeout(function () {
                    imgClone.css({
                        'height': 0,
                        'opacity': 0.5

                    });
                    cartElem.addClass('shakeit');
                }, 1000);
                setTimeout(function () {
                    cartElem.removeClass('shakeit');
                    imgClone.remove();
                }, 1500);
            });
        };


        return {
            restrict: 'E',
            link: link,
            transclude: true,
            replace: true,
            scope: {},
            template: '<button class="add-to-cart btn btn-primary" type="button" ng-transclude></button>'
        };
    });

})(angular.module('eshop'));

