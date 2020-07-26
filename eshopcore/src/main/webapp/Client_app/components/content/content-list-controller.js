(function (app) {
    app.controller('content-list-controller', contentListController)
    //inject các service cần dùng
    contentListController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox'];

//chú ý thứ tự
    function contentListController($scope, apiService, notificationService, $ngBootbox) {
        $scope.contentList = [];
        $scope.getListcontent = getListContent;
        $scope.keyWord = '';

        $scope.contentcategoryList = [];
        $scope.getListcontentcategory = getListContentCategory;

        $scope.tagList = [];
        $scope.getListtag = getListTag;

        function getListContent() {
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            var config = {
                params: {
                    keyword: $scope.keyWord,
                    action: "getAll",
                }
            }

            apiService.get('/eshopcore_war/API-Content', config, function (result) {
                $scope.contentList = result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy bản ghi nào");
                } else {

                    notificationService.displaySuccess("Tìm thấy " + result.data.length + " bản ghi");
                }


            }, function () {
                console.log('Load content api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });

        }

        $scope.getListcontent();


        function getListContentCategory() {
            /*Cấu trúc config cho doget để get ra parameter chú ý các tên action*/
            var config = {
                params: {
                    keyword: $scope.keyWord,
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
                    keyword: $scope.keyWord,
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