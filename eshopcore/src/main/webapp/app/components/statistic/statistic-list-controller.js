(function (app) {
    app.controller('statistic-list-controller', statisticListController)
    //inject các service cần dùng
    statisticListController.$inject = ['$scope', 'api-service', 'notification-service', '$ngBootbox', '$filter'];

    //chú ý thứ tự
    function statisticListController($scope, apiService, notificationService, $ngBootbox, $filter) {
        $scope.tabledata = [];
        $scope.labels = [];

        $scope.lineChart = false;


        $scope.statisticFilter =
            {
                fromDate: null,
                toDate: null,
            }


        $scope.series = ['Doanh số', 'Lợi nhuận'];
        $scope.data = [];
        $scope.onClick = function (points, evt) {
            console.log(points, evt);
        };

        $scope.getStastistic = getStastistic;
        $scope.datasetOverride = [{yAxisID: 'y-axis-1'}, {yAxisID: 'y-axis-2'}];
        $scope.options = {
            scales: {
                yAxes: [
                    {
                        id: 'y-axis-1',
                        type: 'linear',
                        display: true,
                        position: 'left'
                    },
                    {
                        id: 'y-axis-2',
                        type: 'linear',
                        display: true,
                        position: 'right'
                    }
                ]
            }
        };

        $scope.search = search;

        function search() {
            getStastistic();
        }

        $scope.reset = functReset;

        function functReset() {
            $scope.statisticFilter = {};
        }


        function getStastistic() {


            var config = {
                params: {
                    filterJson: angular.toJson($scope.statisticFilter)
                }
            }

            apiService.get('/eshopcore_war/api/statistic', config, function (result) {
                $scope.tabledata = result.data;
                var labels = [];
                var charData = [];
                var revenues = [];
                var benefits = [];
                $.each(result.data, function (i, item) {
                    labels.push($filter('date')(item.Date, 'dd/MMM/yyyy'));
                    revenues.push(item.Revenunes);
                    benefits.push(item.Benefis);
                })
                charData.push(revenues, benefits);
                $scope.data = charData;
                $scope.labels = labels;

                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy bản ghi nào");
                } else {

                    notificationService.displaySuccess("Tìm thấy " + result.data.length + " bản ghi");
                }


            }, function () {
                console.log('Load account api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });
        }

        $scope.getStastistic();
    }
})(angular.module('eshop-statistic'));