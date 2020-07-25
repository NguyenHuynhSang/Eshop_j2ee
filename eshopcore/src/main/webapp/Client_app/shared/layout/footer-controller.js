(function (app) {

    app.controller('footer-controller', footerController);
    footerController.$inject = ['$scope', 'api-service', 'notification-service','$sce'];
    function footerController($scope, apiService, notificationService,$sce) {
        $scope.footer={};
        $scope.getFooter=getFooter;


        function getFooter() {
            apiService.get('/eshopcore_war/api/FooterClient', null, function (result) {
                $scope.footer = result.data;
                $scope.footer.Content = $sce.trustAsHtml(html);
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy slides nào");
                } else {
                    notificationService.displaySuccess("[DEV]Tìm đước slides");
                }
            }, function () {
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }
        $scope.getFooter();



    }

})(angular.module('eshop'));