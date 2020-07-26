(function (app) {
    app.controller('content-single-controller', contentSingleController)
    contentSingleController.$inject = ['api-service','$scope', 'notification-service','$state','$stateParams','$rootScope'];

    function contentSingleController(apiService,$scope,notificationService,$state,$stateParams,$rootScope) {
            $rootScope.bodyClass='right-sidebar blog-grid';
            $scope.jsonEntity = {};

            $scope.contentcategoryList = [];
            $scope.getListcontentcategory = getListContentCategory;

            $scope.tagList = [];
            $scope.getListtag = getListTag;

        function LoadContentByID() {
            var config = {
                params: {
                    keyword: "",
                    ID:$stateParams.id,
                    action: "getByID",
                }
            }
            apiService.get('/eshopcore_war/API-Content', config, function (result) {
                $scope.jsonEntity = result.data[0];
            }, function () {
                console.log('Load content api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });
        }
        LoadContentByID();

        function getListContentCategory() {
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            var config = {
                params: {
                    keyword: "",
                    action: "getAll",
                }
            }

            apiService.get('/eshopcore_war/API-ContentCategory', config, function (result) {
                $scope.contentcategoryList = result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy bản ghi nào");
                } else {

                    notificationService.displaySuccess("Tìm thấy " + result.data.length + " bản ghi");
                }


            }, function () {
                console.log('Load content category api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });

        }

        $scope.getListcontentcategory();

        function getListTag() {
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            var config = {
                params: {
                    keyword: "",
                    action: "getAll",
                }
            }

            apiService.get('/eshopcore_war/API-Tag', config, function (result) {
                $scope.tagList = result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy bản ghi nào");
                } else {

                    notificationService.displaySuccess("Tìm thấy " + result.data.length + " bản ghi");
                }


            }, function () {
                console.log('Load content category api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });

        }

        $scope.getListtag();

    }
})(angular.module('eshop-content'));