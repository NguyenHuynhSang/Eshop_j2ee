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

        $scope.ChooseImage = function()
        {
            var finder = new CKFinder();
            finder.selectActionFunction = function(fileUrl)
            {
                $scope.contentEntity.Image = fileUrl;
            }
            finder.popup();
        }
    }
})(angular.module('eshop-content'));