(function (app) {
    app.controller('content-edit-controller', contentEditController)
    contentEditController.$inject = ['api-service','$scope', 'notification-service','$state','$stateParams'];

    function contentEditController(apiService,$scope,notificationService,$state,$stateParams) {
        $scope.jsonEntity = {};
        $scope.EditContent = EditContent;
        $scope.contentcategoryList =[];
        $scope.getListcontentcategory = getListContentCategory;

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


        function getListContentCategory() {
            var config = {
                params: {
                    keyword: "",
                    action: "getAll",
                }
            }
            apiService.get('/eshopcore_war/API-ContentCategory', config, function (result) {
                $scope.contentcategoryList = result.data;
            }, function () {
                console.log('Load content category api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });

        }
        $scope.getListcontentcategory();

        function EditContent() {
            apiService.put('/eshopcore_war/API-Content',  JSON.stringify($scope.jsonEntity.content)  , function (result) {
                notificationService.displaySuccess("Sửa bản ghi thành công");
                $state.go('content-list');
            }, function () {
                console.log('Load content api failed.');
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
            });
        }
        LoadContentByID();
        $scope.ckFinderSelectImage=ckFinderSelectImage;
        function ckFinderSelectImage(){
            var count = 1;
            //e.preventDefault();
            var finder = new CKFinder();

            finder.selectActionFunction = function (url) {

                if (count > 1) {
                    return;
                }
                $('#txtImage').val(url).trigger('input');
                $('#kt_dropzone_2').empty();
                $('#kt_dropzone_2').append('<img width="150" height="150" class="abc" src="' + url + '" />');

                count++;
            };
            finder.popup();

        }
    }
})(angular.module('eshop-content'));