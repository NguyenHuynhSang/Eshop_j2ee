<%--
    Document   : index
    Created on : Apr 22, 2020, 1:18:39 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 4/22/2020
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>

<html>

<!-- begin::Head -->
<head>

    <meta charset="utf-8"/>
    <title>EShop</title>
    <meta name="description" content="Page with empty content">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!--begin::Fonts -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700|Roboto:300,400,500,600,700">
    <link href="${pageContext.request.contextPath }/Assets/admin/libs/Plugins/toastr/toastr.scss" rel="stylesheet"
          type="text/css"/>

    <!--end::Fonts -->
    <!--begin::Page Vendors Styles(used by this page) -->
    <link href="${pageContext.request.contextPath }/Assets/admin/plugins/custom/fullcalendar/fullcalendar.bundle.css"
          rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath }/Assets/admin/css/pages/invoices/invoice-1.css" rel="stylesheet" type="text/css" />

    <!--end::Page Vendors Styles -->
    <!--begin::Global Theme Styles(used by all pages) -->
    <link href="${pageContext.request.contextPath }/Assets/admin/plugins/global/plugins.bundle.css" rel="stylesheet"
          type="text/css"/>
    <link href="${pageContext.request.contextPath }/Assets/admin/css/style.bundle.css" rel="stylesheet"
          type="text/css"/>
    <link href="${pageContext.request.contextPath }/Assets/admin/css/pages/login/login-1.css" rel="stylesheet" type="text/css" />
    <!--end::Global Theme Styles -->
    <!--begin::Layout Skins(used by all pages) -->
    <link href="${pageContext.request.contextPath }/Assets/admin/css/skins/header/base/light.css" rel="stylesheet"
          type="text/css"/>
    <link href="${pageContext.request.contextPath }/Assets/admin/css/skins/header/menu/light.css" rel="stylesheet"
          type="text/css"/>
    <link href="${pageContext.request.contextPath }/Assets/admin/css/skins/brand/dark.css" rel="stylesheet"
          type="text/css"/>
    <link href="${pageContext.request.contextPath }/Assets/admin/css/skins/aside/dark.css" rel="stylesheet"
          type="text/css"/>
    <link href="${pageContext.request.contextPath }/Assets/admin/libs/Plugins/angular-ui-tree/dist/angular-ui-tree.css" rel="stylesheet" />

    <link href="${pageContext.request.contextPath }/Assets/admin/libs/Plugins/angular-ui-tree/examples/css/app.css" rel="stylesheet" />
    <!--end::Layout Skins -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/Assets/admin/media/logos/favicon.ico"/>
</head>

<!-- end::Head -->
<!-- begin::Body -->
<body ng-app="eshop"
      class="kt-quick-panel--right kt-demo-panel--right kt-offcanvas-panel--right kt-header--fixed kt-header-mobile--fixed kt-subheader--enabled kt-subheader--fixed kt-subheader--solid kt-aside--enabled kt-aside--fixed kt-page--loading">

<div ui-view="base"></div>
<div ui-view="other"></div>
<!--ENd:: Chat-->
<!-- begin::Global Config(global config for global JS sciprts) -->
<script>
    var KTAppOptions = {
        "colors": {
            "state": {
                "brand": "#5d78ff",
                "dark": "#282a3c",
                "light": "#ffffff",
                "primary": "#5867dd",
                "success": "#34bfa3",
                "info": "#36a3f7",
                "warning": "#ffb822",
                "danger": "#fd3995"
            },
            "base": {
                "label": [
                    "#c5cbe3",
                    "#a1a8c3",
                    "#3d4465",
                    "#3e4466"
                ],
                "shape": [
                    "#f0f3ff",
                    "#d9dffa",
                    "#afb4d4",
                    "#646c9a"
                ]
            }
        }
    };
</script>

<!-- end::Global Config -->
<!--begin::Global Theme Bundle(used by all pages) -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-sanitize.js"></script>
<script src="${pageContext.request.contextPath }/Assets/admin/plugins/global/plugins.bundle.js"
        type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/Assets/admin/js/scripts.bundle.js" type="text/javascript"></script>


<!--end::Global Theme Bundle -->
<!--begin::Page Vendors(used by this page) -->
<script src="${pageContext.request.contextPath }/Assets/admin/plugins/custom/fullcalendar/fullcalendar.bundle.js"
        type="text/javascript"></script>

<script src="//maps.google.com/maps/api/js?key=AIzaSyBTGnKT7dt597vo9QgeQ7BFhvSRP4eiMSM" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/Assets/admin/plugins/custom/gmaps/gmaps.js"
        type="text/javascript"></script>

<!--end::Page Vendors -->
<!--begin::Page Scripts(used by this page) -->

<script src="${pageContext.request.contextPath }/Assets/admin/js/pages/dashboard.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath }/Assets/admin/libs/Spa/activeMenuItem.js"></script>
<!--Begin::embed angularJs and module-->
<script src="${pageContext.request.contextPath }/Assets/admin/libs/Plugins/angular/angular.js"></script>
<script src="${pageContext.request.contextPath }/Assets/admin/libs/Plugins/angular-ui-router/release/angular-ui-router.js"></script>
<script src="${pageContext.request.contextPath }/Assets/admin/libs/Plugins/toastr/toastr.js"></script>
<script src="${pageContext.request.contextPath }/Assets/admin/libs/Plugins/bootbox/bootbox.js"></script>
<script src="${pageContext.request.contextPath }/Assets/admin/libs/Plugins/uibootstrap/ui-bootstrap-tpls-2.5.0.js"></script>
<script src="${pageContext.request.contextPath }/Assets/admin/libs/Plugins/ngbootbox/dist/ngBootbox.js"></script>
<script src="${pageContext.request.contextPath }/Assets/admin/libs/Plugins/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath }/Assets/admin/libs/Plugins/ng-ckeditor/dist/ng-ckeditor.js"></script>
<script src="${pageContext.request.contextPath }/Assets/admin/libs/Plugins/angular-ui-tree/dist/angular-ui-tree.js"></script>

<script src="${pageContext.request.contextPath }/Assets/admin/libs/Plugins/ckfinder/ckfinder/ckfinder.js"></script>
<script src="${pageContext.request.contextPath }/Assets/admin/libs/Plugins/chart.js/dist/Chart.js"></script>
<script src="${pageContext.request.contextPath }/Assets/admin/libs/Plugins/angular-chart.js/dist/angular-chart.js"></script>

<!--end::embed angularJs  and module-->




<!--Begin::embed app module-->
<script src="${pageContext.request.contextPath }/app/shared/modules/eshop-common.js"></script>
<script src="${pageContext.request.contextPath }/app/components/product/products-module.js"></script>
<script src="${pageContext.request.contextPath }/app/components/order/orders-module.js"></script>
<script src="${pageContext.request.contextPath }/app/components/catalog/catalogs-module.js"></script>
<script src="${pageContext.request.contextPath }/app/components/account/accounts-module.js"></script>
<script src="${pageContext.request.contextPath }/app/components/statistic/statistic-module.js"></script>
<!--end::embed app module-->
<script src="${pageContext.request.contextPath }/app/components/contentcategory/contentcategory-module.js"></script>
<script src="${pageContext.request.contextPath }/app/components/content/content-module.js"></script>
<script src="${pageContext.request.contextPath }/app/components/footer/footer-module.js"></script>
<script src="${pageContext.request.contextPath }/app/components/slide/slide-module.js"></script>
<script src="${pageContext.request.contextPath }/app/components/menu/menu-module.js"></script>

<!--Begin::embed app service-->
<script src="${pageContext.request.contextPath }/app/app.js"></script>
<script src="${pageContext.request.contextPath}/app/shared/services/api-service.js"></script>
<script src="${pageContext.request.contextPath }/app/shared/services/notification-service.js"></script>
<script src="${pageContext.request.contextPath }/app/shared/services/common-service.js"></script>
<!--end::embed app service-->


<!--Begin::embed app controller-->
<script src="${pageContext.request.contextPath }/app/components/login/login-controller.js"></script>

<script src="${pageContext.request.contextPath }/app/components/home/home-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/product/product-list-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/product/product-edit-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/product/product-create-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/order/order-list-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/order/order-detail-controller.js"></script>

<script src="${pageContext.request.contextPath }/app/components/account/account-list-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/account/account-edit-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/account/account-create-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/statistic/statistic-list-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/catalog/catalog-list-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/catalog/catalog-create-controller.js"></script>
<!--end::embed app controller-->


<%--
contentcategory controller container
--%>
<script src="${pageContext.request.contextPath }/app/components/contentcategory/contentcategory-list-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/contentcategory/contentcategory-create-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/contentcategory/contentcategory-edit-controller.js"></script>

<%--
content controller container
--%>
<script src="${pageContext.request.contextPath }/app/components/content/content-list-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/content/content-create-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/content/content-edit-controller.js"></script>
<%--
footer controller container
--%>
<script src="${pageContext.request.contextPath }/app/components/footer/footer-list-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/footer/footer-create-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/footer/footer-edit-controller.js"></script>

<%--
slide controller container
--%>
<script src="${pageContext.request.contextPath }/app/components/slide/slide-list-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/slide/slide-create-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/slide/slide-edit-controller.js"></script>

<%--
menu controller container
--%>
<script src="${pageContext.request.contextPath }/app/components/menu/menu-list-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/menu/menu-create-controller.js"></script>
<script src="${pageContext.request.contextPath }/app/components/menu/menu-edit-controller.js"></script>

<!--end::embed angularJs-->
<!--end::Page Scripts -->


</body>

<!-- end::Body -->
</html>

