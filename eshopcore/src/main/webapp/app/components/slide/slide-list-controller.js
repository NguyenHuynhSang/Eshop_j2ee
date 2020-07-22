(function (app) {
    app.controller('slide-list-controller', slideListController)
    //inject các service cần dùng
    slideListController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox'];

//chú ý thứ tự
    function slideListController($scope, apiService, notificationService, $ngBootbox) {
        $scope.slideList = [];
        $scope.getListslide = getListSlide;
        $scope.keyWord = '';

        $scope.search = search;
        $scope.delSlide = delSlide;
        $scope.SetActive = setActive;

        function search() {
            getListSlide();
        }

        function delSlide(id) {
            $ngBootbox.confirm('Bạn có chắc muốn xóa?').then(function () {
                var config = {
                    params: {
                        ID: id,
                    }
                }
                apiService.del('/eshopcore_war/API-Slide', config, function () {
                    notificationService.displaySuccess("Xóa thành công bản ghi");
                    getListSlide();
                }, function () {

                });
                notificationService.displaySuccess("Xóa  thành công bản ghi");
                getListSlide();
            });

        }

        function setActive(id)
        {
            $ngBootbox.confirm('Bạn có muốn hiển thị slide này?').then(function()
            {
                apiService.put('/eshopcore_war/SlideServlet',JSON.stringify(id),function()
                    {
                        notificationService.displaySuccess("Thành công");
                        getListSlide();
                    },function(){

                    });
                    notificationService.displaySuccess("Thành công");
                    getListSlide();
            });
        }

        function getListSlide() {
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            var config = {
                params: {
                    keyword: $scope.keyWord,
                    action: "getAll",
                }
            }

            apiService.get('/eshopcore_war/API-Slide', config, function (result) {
                $scope.slideList = result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy bản ghi nào");
                } else {

                    notificationService.displaySuccess("Tìm thấy " + result.data.length + " bản ghi");
                }


            }, function () {
                console.log('Load slide api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });

        }

        $scope.getListslide();
    }
})(angular.module('eshop-slide'));