(function (app) {
    app.controller('content-create-controller', contentCreateController)
    contentCreateController.$inject = ['api-service','$scope', 'notification-service','$state'];

    function contentCreateController(apiService,$scope,notificationService,$state) {
        $scope.contentEntity = {};
        $scope.CreateContent = CreateContent;
        $scope.contentcategoryList =[];
        $scope.getListcontentcategory = getListContentCategory;
        $scope.keyWord = '';

        function CreateContent() {

            apiService.post('/eshopcore_war/API-Content', JSON.stringify($scope.contentEntity)  , function (result) {
                notificationService.displaySuccess("Thêm mới bản ghi thành công");
                $state.go('content-list');
            }, function () {
                console.log('Load content api failed.');
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
            });
        }

        $scope.imageInputChange=imageInputChange;
        function imageInputChange(){
            var value =  $('#txtImage').val();
        }


        function getListContentCategory() {
            var config = {
                params: {
                    keyword: $scope.keyWord,
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