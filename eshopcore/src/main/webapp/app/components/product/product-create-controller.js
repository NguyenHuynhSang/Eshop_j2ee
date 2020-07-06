(function (app) {
    app.controller('product-create-controller', productCreateController)
    productCreateController.$inject = ['api-service', '$scope', 'notification-service', '$state','common-service'];
    function productCreateController(apiService, $scope, notificationService, $state,commonService) {

        ///**********************
        /// 1 product có nhiều phiên bản
        // mỗi phiên bản có nhiều attributevalue khác nhau


        //ds attributevalue của từng attribute của từng version
        $scope.attributeValueListPerVersion = [{ AtributeValue: [] }]

        $scope.productInput = {
            Name: '', Description: '',ApplyPromotion:true,Deliver:true, Versions: [{ Attributes: []}]
        };


      $scope.getSeoTitle=getSeoTitle;

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



        //submit form để test
        $scope.submit = function () {
            var temp = $scope.productInput;
            var selected = $scope.attributeValueListPerVersion;
            CreateProduct();
        }


        $scope.CreateProduct = CreateProduct;
        // danh sách các tên attribute
        $scope.listAttribute = [];

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



        /// Chưa dùng đến
        function CreateProduct() {
            apiService.post('/eshopcore_war/api/Product',JSON.stringify($scope.productInput), function (result) {
                notificationService.displaySuccess("Thêm mới bản ghi thành công");
                $state.go('product-list');
            }, function () {
                console.log('Load product api failed.');
                notificationService.displayError("Thêm mới bản ghi KHÔNG thành công");
            });
        }
        GetListAttribute();
        //  GetListAttributeValue();
    }








})(angular.module('eshop-product'));

