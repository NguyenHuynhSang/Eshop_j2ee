(function (app) {
    app.controller('contentcategory-edit-controller', contentcategoryEditController)
    contentcategoryEditController.$inject = ['api-service','$scope', 'notification-service','$state','$stateParams'];

    function contentcategoryEditController(apiService,$scope,notificationService,$state,$stateParams) {
        $scope.jsonEntity = {};
        $scope.EditContentCategory = EditContentCategory;
        $scope.contentcategoryList =[];
        $scope.getListcontentcategory = getListContentCategory;

        function LoadContentCategoryByID() {

            var config = {
                params: {
                    keyword: "",
                    ID:$stateParams.id,
                    action: "getByID",
                }
            }

            apiService.get('/eshopcore/API-ContentCategory', config, function (result) {
                $scope.jsonEntity = result.data[0];
            }, function () {
                console.log('Load content category api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }

        
        function getListContentCategory() {
            var config = {
                params: {
                    keyword: "",
                    action: "getAll",
                }
            }
            apiService.get('/eshopcore/API-ContentCategory', config, function (result) {
                $scope.contentcategoryList = result.data;   
            }, function () {
                console.log('Load content category api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });
    
        }
        $scope.getListcontentcategory();  

        function EditContentCategory() {
            apiService.put('/eshopcore/API-ContentCategory',  JSON.stringify($scope.jsonEntity)  , function (result) {
                notificationService.displaySuccess("Sửa bản ghi thành công");
                $state.go('contentcategory-list');
            }, function () {
                console.log('Load content category api failed.');
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
            });
        }
        LoadContentCategoryByID();

    }
})(angular.module('eshop-contentcategory'));