(function (app) {
    app.controller('product-edit-controller', productEditController)
    productEditController.$inject = ['api-service','$scope', 'notification-service','$state','$stateParams'];

    function productEditController(apiService,$scope,notificationService,$state,$stateParams) {
        $scope.jsonEntity = {};
        $scope.productInput = {};
        $scope.loadProductByID=loadProductByID;

        //list catalog
        $scope.childCagalogList = [];
        $scope.getListChildCatalog = getListChildCatalog();

        function getSeoTitle(){
            $scope.productInput.SEOUrl=commonService.getSeoTitle($scope.productInput.Name);
        }

        function getProductVersionSeoTitle(index)
        {
            $scope.productInput.Versions[index].SEOUrl=$scope.productInput.SEOUrl+commonService.getSeoTitle(  $scope.productInput.Versions[index].SKU);

        }

        ///Thêm  phiên bản cho sản phẩm
        $scope.addNewVersion = function() {
            $scope.productInput.Versions.push({ Attributes: [] });
            $scope.attributeValueListPerVersion.push({ atributeValue: [] });
        }


        // Thêm  attributevalue dựa vào phiên bản
        $scope.addNewAttributeSet = function (verIndex) {
            $scope.productInput.Versions[verIndex].Attributes.push({});


        };

        // loại bỏ 1 attribute value
        $scope.removeAttributeValue = function (verIndex,element) {
            $scope.productInput.Versions[verIndex].Attributes.splice(element, 1);
            $scope.attributeValueListPerVersion[verIndex].atributeValue.splice(element,1);
        };

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

        // lấy lên các attributevalue dựa vào attribute name đã chọn
        $scope.selectAttributeName = function (versionIndex,atributeIndex,selectedAtribute) {

            var config = {
                params: {
                    atributeId: selectedAtribute,
                    action: "getByAtributeID",
                }
            }
            apiService.get('/eshopcore_war/api/AttributeValue', config, function (result) {
                $scope.attributeValueListPerVersion[versionIndex].AtributeValue[atributeIndex] = result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy bản ghi nào");
                } else {

                    notificationService.displaySuccess("Tìm thấy " + result.data.length + " bản ghi");
                }
            }, function () {
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }

        function GetListAttribute() {

            apiService.get('/eshopcore_war/api/Attribute', null, function (result) {
                $scope.listAttribute = result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy bản ghi nào");
                } else {

                    notificationService.displaySuccess("Tìm thấy " + result.data.length + " bản ghi");
                }
            }, function () {
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });

        }

        function getListChildCatalog() {
            var config = {
                params: {
                    action: "getChild",
                }
            }
            apiService.get('/eshopcore_war/api/Catalog', config, function (result) {
                $scope.childCagalogList = result.data;
                if (result.data.length == 0) {
                    notificationService.displayWarning("Không tìm thấy bản ghi nào");
                } else {

                    notificationService.displaySuccess("Tìm thấy " + result.data.length + " bản ghi");
                }
            }, function () {
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });
        }




        function loadProductByID() {

            var config = {
                params: {
                    ID:$stateParams.id,
                }
            }

            apiService.get('/eshopcore_war/api/productUpdate', config, function (result) {
                $scope.productInput = result.data;
                 notificationService.displaySuccess("Tìm thấy bản ghi");

            }, function () {
                console.log('Load product api failed.');
                notificationService.displayError("Không lấy được dữ liệu từ server");
            });


        }
        function EditProduct() {
            apiService.put('/eshopcore_war/api/productUpdate',JSON.stringify($scope.productInput), function (result) {
                notificationService.displaySuccess("Sửa bản ghi thành công");
                $state.go('product-list');
            }, function () {
                console.log('Load product api failed.');
                notificationService.displayError("Sửa bản ghi KHÔNG thành công");
            });
        }


        $scope.submit = function () {
            var temp = $scope.productInput;
            var selected = $scope.attributeValueListPerVersion;
            EditProduct();
        }
        $scope.EditProduct = EditProduct;



        GetListAttribute();

        $scope.loadProductByID();
    }
})(angular.module('eshop-product'));