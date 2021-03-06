package com.EShop.Service;

import com.EShop.Filter.ProductClientFilter;
import com.EShop.Filter.ProductFilter;
import com.EShop.Service.IService.IClientService.ICProductService;
import com.EShop.Service.IService.IProductService;
import com.EShop.Model.InputModel.ProductInput;
import com.EShop.Model.InputModel.ProductVersionInput;
import com.EShop.Model.Product;
import com.EShop.Model.ProductAttribute;
import com.EShop.Model.ProductCatalog;
import com.EShop.Model.ProductVersion;
import com.EShop.Model.ViewModel.ProductDetailViewModel;
import com.EShop.Model.ViewModel.ProductViewModel;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProductService implements IProductService, ICProductService {
    Connection conn = DbConnection.getJDBCConnection();

    @Override
    public List<Product> GetProducts() throws SQLException {
        return null;
    }

    @Override
    public List<ProductVersion> GetProductAllVersionList(ProductFilter filter) throws SQLException {
        Statement stmt;
        stmt = conn.createStatement();

        String qLilter = "";
        if (filter != null) {
            if (filter.ID != 0)
                qLilter = "where ver.ID=" + filter.ID;
            if (filter.Name != null) {
                qLilter = "where p.Name LIKE '%" + filter.Name + "%'";
            }
            if (filter.startOriginalPrice != 0 && filter.endOriginalPrice == 0) {
                qLilter = "where p.OriginalPrice>=" + filter.startOriginalPrice;
            }
            if (filter.startOriginalPrice == 0 && filter.endOriginalPrice != 0) {
                qLilter = "where p.OriginalPrice<=" + filter.endOriginalPrice;
            }
            if (filter.startOriginalPrice != 0 && filter.endOriginalPrice != 0) {
                qLilter = "where p.OriginalPrice>=" + filter.startOriginalPrice + "and p.OriginalPrice<=" + filter.endOriginalPrice;
            }
            if (filter.CatalogID != 0) {
                qLilter = "where c.ID=" + filter.CatalogID;
            }

            if (filter.startPrice != 0 && filter.endPrice == 0) {
                qLilter = "where ver.Price>=" + filter.startPrice;
            }
            if (filter.startPrice == 0 && filter.endPrice != 0) {
                qLilter = "where ver.Price<=" + filter.endPrice;
            }
            if (filter.startPrice != 0 && filter.startPrice != 0) {
                qLilter = "where ver.Price>=" + filter.startPrice + "and ver.Price<=" + filter.endPrice;
            }


        }


        List<ProductVersion> productVersionList = new ArrayList<>();
        String sqlQuery = "select ver.ID as verID,ver.Barcode as verBarcode,ver.Description as verDescription,\n" +
                "ver.Image as verImage,ver.Price as verPrice,ver.PromotionPrice as verPromotionPrice,\n" +
                "ver.Quantum as verQuantum,ver.RemainingAmount as verRemainingAmount,\n" +
                "p.ID as pID,p.ApplyPromotion as pAppyPromotion,p.Content as pContent,\n" +
                "p.CreatedBy as pCreatedBy,p.CreatedDate as pCreatedDate,p.Deliver as pDeliver,\n" +
                "p.Description as pDescription,p.ModifiedBy as pModifiedBy, p.ModifiedDate as pModifiedDate,\n" +
                "p.Name as pName,p.OriginalPrice as pOriginalPrice,p.SEODescription as pSEODescription,\n" +
                "p.SEOTitle as pSEOTitle,p.Url as pUrl, p.Weight as pWeight,p.SEOUrl as pSeoURL,\n" +
                "c.ID as cID, c.Name as cName,c.ParentID as cParentID\n" +
                "from ProductVersions ver\n" +
                "join Product p\n" +
                "on ver.ProductID=p.ID\n" +
                "left join Catalog c\n" +
                "on p.CatalogID =c.ID\n" +
                "" + qLilter +
                " order by p.CreatedDate asc\n";

        ResultSet rs = stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            ProductVersion productVersion = new ProductVersion();
            productVersion.setBarcode(rs.getString("verBarcode"));
            productVersion.setDescription(rs.getString("verDescription"));
            productVersion.setID(rs.getInt("verID"));
            productVersion.setImage(rs.getString("verImage"));
            productVersion.setPrice(rs.getBigDecimal("verPrice"));
            productVersion.setPromotionPrice(rs.getBigDecimal("verPromotionPrice"));
            productVersion.setQuantum(rs.getInt("verQuantum"));
            productVersion.setRemainingAmount(rs.getInt("verRemainingAmount"));

            Product product = new Product();
            product.setID(rs.getInt("pID"));
            product.setApplyPromotion(rs.getBoolean("pAppyPromotion"));
            product.setContent(rs.getString("pContent"));
            product.setCreatedBy(rs.getString("pCreatedBy"));
            product.setCreateDate(rs.getDate("pCreatedDate"));
            product.setDeliver(rs.getBoolean("pDeliver"));
            product.setDescription(rs.getString("pDescription"));
            product.setModifiedBy(rs.getString("pModifiedBy"));
            product.setModifiedDate(rs.getDate("pModifiedDate"));
            product.setName(rs.getString("pName"));
            product.setOriginalPrice(rs.getInt("pOriginalPrice"));
            product.setSEODescription(rs.getString("pSEODescription"));
            product.setSEOTitle(rs.getString("pSEOTitle"));
            product.setSEOUrl(rs.getString("pUrl"));
            product.setWeight(rs.getInt("pWeight"));

            ProductCatalog productCatalog = new ProductCatalog();

            productCatalog.setID(rs.getInt("cID"));
            productCatalog.setName(rs.getString("cName"));
            productCatalog.setParentID(rs.getInt("cParentID"));

            product.setProductCatalog(productCatalog);
            productVersion.setProduct(product);
            productVersionList.add(productVersion);
        }


        rs.close();
        stmt.close();
        conn.close();
        return productVersionList;
    }


    @Override
    public void UpdateProduct(ProductInput product) throws SQLException {


        String sqlQuery="Update Product\n" +
                "Set CatalogID=?,Url=?,Name=?,Description=?,Content=?,Weight=?,OriginalPrice=?,\n" +
                "Deliver=?,SEOTitle=?,SEOUrl=?,SEODescription=?,ApplyPromotion=?\n" +
                "Where ID=?";
        PreparedStatement pStatement = conn.prepareStatement(sqlQuery);
        //statement = conn.prepareStatement(sqlQuery);
        pStatement.setObject(1, product.CatalogID);
        pStatement.setObject(2, product.Url);
        pStatement.setObject(3, product.Name);
        pStatement.setObject(4, product.Description);
        pStatement.setObject(5, product.Content);
        pStatement.setObject(6, product.Weight);
        pStatement.setObject(7, product.OriginalPrice);
        pStatement.setObject(8, true);
        pStatement.setObject(9, product.SEOTitle);
        pStatement.setObject(10, product.SEOUrl);
        pStatement.setObject(11, product.SEODescription);
        pStatement.setObject(12, product.ApplyPromotion);
        pStatement.setObject(13, product.ID);
        int rowCount = pStatement.executeUpdate();
        for (ProductVersionInput ver :
                product.Versions) {
            sqlQuery="Update ProductVersions\n" +
                    "Set ProductID=?,WareHouseID=?,Description=?,Price=?,PromotionPrice=?,Quantum=?,RemainingAmount=?,\n" +
                    "SKU=?,Barcode=?,Image=?\n" +
                    "Where ID=?";
            PreparedStatement verStatement = conn.prepareStatement(sqlQuery);
            ver.ProductID = product.ID;
            verStatement.setObject(1, ver.ProductID);
            verStatement.setObject(2, 0);
            verStatement.setObject(3, ver.Description);
            verStatement.setObject(4, ver.Price);
            verStatement.setObject(5, ver.PromotionPrice);
            verStatement.setObject(6, ver.Quantum);
            verStatement.setObject(7, ver.RemainingAmount);
            verStatement.setObject(8, ver.SKU);
            verStatement.setObject(9, ver.Barcode);
            verStatement.setObject(10, ver.Image);
            verStatement.setObject(11, ver.ID);
            rowCount = verStatement.executeUpdate();
        }
    }

    @Override
    public void InsertProduct(ProductInput product) throws SQLException {
        Statement statement;
        String sqlQuery = "select * \n" +
                "from Product\n" +
                "where Name='" + product.Name + "'"; // check trùng
        ResultSet rs;
        conn.setAutoCommit(false);
        statement = conn.createStatement();


        String createdDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(Calendar.getInstance().getTime());
        rs = statement.executeQuery(sqlQuery);
        if (rs.next() == false) {

            sqlQuery = "Insert into Product (CatalogID,Url,Name,Description,Content,CreatedDate,CreatedBy,Weight,OriginalPrice,Deliver,SEOTitle,SEOUrl,SEODescription,ApplyPromotion) \n" +
                    "values (?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?)";
            String columnNames[] = new String[]{"ID"};

            PreparedStatement pStatement = conn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            //statement = conn.prepareStatement(sqlQuery);
            pStatement.setObject(1, product.CatalogID);
            pStatement.setObject(2, product.Url);
            pStatement.setObject(3, product.Name);
            pStatement.setObject(4, product.Description);
            pStatement.setObject(5, product.Content);
            pStatement.setObject(6, createdDate);
            pStatement.setObject(7, product.CreatedBy);
            pStatement.setObject(8, product.Weight);
            pStatement.setObject(9, product.OriginalPrice);
            pStatement.setObject(10, product.Deliver);
            pStatement.setObject(11, product.SEOTitle);
            pStatement.setObject(12, product.SEOUrl);
            pStatement.setObject(13, product.SEODescription);
            pStatement.setObject(14, product.ApplyPromotion);
            int rowCount = pStatement.executeUpdate();
            ResultSet rss = pStatement.getGeneratedKeys();
            int last_inserted_id = 0;
            if (rss.next()) {
                int productID = Integer.parseInt(rss.getObject(1).toString());


                if (product.Versions != null) {
                    for (ProductVersionInput ver :
                            product.Versions) {

                        sqlQuery = "Insert into ProductVersions(ProductID,WareHouseID,Description,Price,PromotionPrice,Quantum,RemainingAmount,SKU,Barcode,Image) \n" +
                                "values (?, ?, ?, ?,?,?,?,?,?,?)";
                        PreparedStatement verStatement = conn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
                        ver.ProductID = productID;
                        verStatement.setObject(1, ver.ProductID);
                        verStatement.setObject(2, 0);
                        verStatement.setObject(3, ver.Description);
                        verStatement.setObject(4, ver.Price);
                        verStatement.setObject(5, ver.PromotionPrice);
                        verStatement.setObject(6, ver.Quantum);
                        verStatement.setObject(7, ver.RemainingAmount);
                        verStatement.setObject(8, ver.SKU);
                        verStatement.setObject(9, ver.Barcode);
                        verStatement.setObject(10, ver.Image);
                        rowCount = verStatement.executeUpdate();
                        ResultSet rs_ver = verStatement.getGeneratedKeys();
                        if (rs_ver.next()) {
                            int verId = Integer.parseInt(rs_ver.getObject(1).toString());
                            for (ProductAttribute attribute :
                                    ver.Attributes) {

                                sqlQuery = "Insert into ProductAttribute(AttributeValueID,ProductVersionID) \n" +
                                        "values (?, ?)";
                                PreparedStatement attStament = conn.prepareStatement(sqlQuery);

                                int attID = attribute.getAttributeValueID();
                                attStament.setObject(1, attID);
                                attStament.setObject(2, verId);
                                int count = attStament.executeUpdate();
                                attStament.close();
                            }


                        }

                        verStatement.close();
                        rs_ver.close();
                    }


                }


            }
            pStatement.close();
            rss.close();
        } else {
            System.out.println("Đã tồn tại sản phẩm");
        }
        rs.close();
        statement.close();
        conn.commit();
        conn.close();
    }

    @Override
    public ProductInput GetProductInputForEdit(int id) throws SQLException {
        ProductInput input = new ProductInput();
        Statement stmt = conn.createStatement();
        String sqlQuery = "select * \n" +
                "from Product p\n" +
                "where p.ID="+id;
        ResultSet rs = stmt.executeQuery(sqlQuery);
        if (rs.next()) {
            input.Name=rs.getString("Name");
            input.CatalogID=rs.getInt("CatalogID");
            input.Description=rs.getString("Description");
            input.Content=rs.getString("Content");
            input.Weight=rs.getInt("Weight");
            input.OriginalPrice=rs.getInt("OriginalPrice");
            input.ApplyPromotion=rs.getBoolean("ApplyPromotion");
            input.SEOTitle=rs.getString("SEOTitle");
            input.SEOUrl=rs.getString("SEOUrl");
            input.SEODescription=rs.getString("SEODescription");
            input.Url=rs.getString("Url");
            input.ID=rs.getInt("ID");
            input.Versions=new ArrayList<>();
                sqlQuery="select *\n" +
                        "from ProductVersions v\n" +
                        "where v.ProductID="+input.ID;
            Statement vsmt = conn.createStatement();
            ResultSet vrs = vsmt.executeQuery(sqlQuery);

            while (vrs.next())
            {
                ProductVersionInput vInput=new ProductVersionInput();
                vInput.ProductID=input.ID;
                vInput.ID=vrs.getInt("ID");;
                vInput.Description=vrs.getString("Description");
                vInput.Price=vrs.getInt("Price");
                vInput.Quantum=vrs.getInt("Quantum");
                vInput.RemainingAmount=vrs.getInt("RemainingAmount");
                vInput.SKU=vrs.getString("SKU");
                vInput.Barcode=vrs.getString("Barcode");
                vInput.PromotionPrice=vrs.getInt("PromotionPrice");
                vInput.Image=vrs.getString("Image");
                vInput.Attributes=new ArrayList<>();
                sqlQuery="select * \n" +
                        "from ProductAttribute pa\n" +
                        "where pa.ProductVersionID="+vInput.ID;
                Statement asmt = conn.createStatement();
                ResultSet ars = asmt.executeQuery(sqlQuery);

                while (ars.next())
                {
                    ProductAttribute attribute=new ProductAttribute();
                    attribute.setID(ars.getInt("ID"));
                    attribute.setAttributeValueID(ars.getInt("AttributeValueID"));
                    attribute.setProductVersionID(ars.getInt("ProductVersionID"));
                    vInput.Attributes.add(attribute);
                }
                ars.close();
                asmt.close();

                input.Versions.add(vInput);
            }

            vrs.close();
            vsmt.close();




        }
        rs.close();
        stmt.close();
        return input;

    }


    @Override
    public void UpdateProduct(Product product) throws SQLException {

    }

    @Override
    public void DeleteProduct(Product[] product) throws SQLException {

    }

    @Override
    public ProductViewModel GetProductByID(int id) throws SQLException {
        ProductViewModel productViewModels = new ProductViewModel();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery = "SELECT c.ID,c.Name,c.ParentID,c.CreatedDate,c.CreatedBy,c.ModifiedDate,c.ModifiedBy,c.SEOTitle,c.SEOUrl,c.SEODescription,p.Name as Parent\n" +
                "FROM Catalog c\n" +
                "LEFT JOIN Catalog p ON c.ParentID = p.ID\n";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            ProductCatalog catalog = new ProductCatalog(rs.getInt("ID"),
                    rs.getInt("ParentID"),
                    rs.getString("Name"),
                    rs.getDate("CreatedDate"),
                    rs.getString("CreatedBy"),
                    rs.getDate("ModifiedDate"),
                    rs.getString("ModifiedBy"),
                    rs.getString("SEOTitle"),
                    rs.getString("SEOUrl"),
                    rs.getString("SEODescription"));
//            CatalogViewModel catalogView = new CatalogViewModel();
//            catalogView.ParentName = rs.getString("Parent");
//            catalogView.Catalog = catalog;
//            catalogs.add(catalogView);
        }
        rs.close();
        stmt.close();
        conn.close();
        return productViewModels;
    }

    @Override
    public ProductDetailViewModel GetProductVertionDetailByID(int Id) throws SQLException {
        ProductDetailViewModel productViewModel = new ProductDetailViewModel();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery = "select p.Name,p.SEOUrl,p.OriginalPrice,p.Content,p.Description\n" +
                "                ,p.Deliver,p.ApplyPromotion,c.Name as CatalogName,c.ID as CatalogId\n" +
                "                ,ver.ID as VerID,ver.Quantum as VerQuanTum,ver.Price as VerPrice\n" +
                "                ,ver.PromotionPrice as VerPromotionPrice\n" +
                "                ,ver.Image as VerImage\n" +
                "                from ProductVersions ver\n" +
                "                join Product p\n" +
                "on p.ID= ver.ProductID\n" +
                "join Catalog c\n" +
                "on c.ID=p.CatalogID\n" +
                "where ver.ID=" + Id;
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            productViewModel.Catalog = new ProductCatalog();
            productViewModel.Catalog.setName(rs.getString("CatalogName"));
            productViewModel.Product = new Product();
            productViewModel.Product.setSEOUrl(rs.getString("SEOUrl"));
            productViewModel.Product.setOriginalPrice(rs.getInt("OriginalPrice"));
            productViewModel.Product.setContent(rs.getString("Content"));
            productViewModel.Product.setDescription(rs.getString("Description"));
            productViewModel.Product.setName(rs.getString("Name"));
            productViewModel.ProductVersion = new ProductVersion();
            productViewModel.ProductVersion.setID(rs.getInt("VerID"));
            productViewModel.ProductVersion.setImage(rs.getString("VerImage"));
            productViewModel.ProductVersion.setQuantum(rs.getInt("VerQuanTum"));
            productViewModel.ProductVersion.setPrice(rs.getInt("VerPrice"));
            productViewModel.ProductVersion.setPromotionPrice(rs.getInt("VerPromotionPrice"));
        }
        rs.close();
        stmt.close();
        conn.close();
        return productViewModel;
    }

    @Override
    public List<ProductDetailViewModel> GetListProductsByFilter(ProductClientFilter filter) throws SQLException {
        List<ProductDetailViewModel> productViewModels = new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();


        String order = "order by p.CreatedDate desc";
        String qfilter = "";

        if (filter != null) {
            if (filter.Name != null && filter.Name.length() > 3) {
                qfilter = "where  p.Name LIKE '%" + filter.Name + "%'";

            }

            if (filter.startPrice != 0 && filter.endPrice == 0) {

                qfilter = "where  ver.PromotionPrice>=" + filter.startPrice;

            }

            if (filter.endPrice != 0 && filter.startPrice == 0) {

                qfilter = "where  ver.PromotionPrice<=" + filter.endPrice;

            }

            if (filter.endPrice != 0 && filter.startPrice != 0) {

                qfilter = "where  ver.PromotionPrice>=" + filter.startPrice + " and ver.PromotionPrice<=" + filter.endPrice;
            }


            if (filter.CatalogID != 0) {
                String query = "select *\n" +
                        "from Catalog\n" +
                        "where ID=" + filter.CatalogID;
                Statement cst = conn.createStatement();

                ResultSet child = cst.executeQuery(query);
                if (child.next()) {
                    int parentID = child.getInt("ParentID");
                    if (parentID == 0) {

                        if (qfilter != "") {
                            qfilter += " and  c.ParentID=" + filter.CatalogID;

                        } else {
                            qfilter = "where  c.ParentID=" + filter.CatalogID;
                        }


                    } else {

                        if (qfilter != "") {
                            qfilter += " and  c.ID=" + filter.CatalogID;

                        } else {
                            qfilter = "where  c.ID=" + filter.CatalogID;
                        }

                    }

                }

                cst.close();
                child.close();


            }


            if (filter.orderBy != 0) {
                if (filter.orderBy == 1) {
                    order = "order by p.CreatedDate desc";
                }
                if (filter.orderBy == 2) {
                    order = "order by CASE WHEN ver.PromotionPrice!=0 THEN ver.PromotionPrice ELSE ver.Price END  asc";
                }
                if (filter.orderBy == 3) {
                    order = "order by CASE WHEN ver.PromotionPrice!=0 THEN ver.PromotionPrice ELSE ver.Price END desc ";
                }


            }

        }


        String sqlQuery = "select p.Name,p.CreatedDate,p.SEOUrl,p.OriginalPrice,p.Content,p.Description\n" +
                "                                ,p.Deliver,p.ApplyPromotion,c.Name as CatalogName,c.ID as CatalogId\n" +
                "                                ,ver.ID as VerID,ver.Quantum as VerQuanTum,ver.Price as VerPrice\n" +
                "                                ,ver.PromotionPrice as VerPromotionPrice\n" +
                "                                ,ver.Image as VerImage,ver.RemainingAmount\n" +
                "                                from ProductVersions ver\n" +
                "                                join Product p\n" +
                "                                on p.ID= ver.ProductID\n" +
                "                                join Catalog c\n" +
                "                                on c.ID=p.CatalogID\n" + qfilter +
                "                               " + order;
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            ProductDetailViewModel productViewModel = new ProductDetailViewModel();
            productViewModel.Catalog = new ProductCatalog();
            productViewModel.Catalog.setName(rs.getString("CatalogName"));
            productViewModel.Product = new Product();
            productViewModel.Product.setSEOUrl(rs.getString("SEOUrl"));
            productViewModel.Product.setOriginalPrice(rs.getInt("OriginalPrice"));
            productViewModel.Product.setContent(rs.getString("Content"));
            productViewModel.Product.setDescription(rs.getString("Description"));
            productViewModel.Product.setName(rs.getString("Name"));

            productViewModel.ProductVersion = new ProductVersion();
            productViewModel.ProductVersion.setID(rs.getInt("VerID"));
            productViewModel.ProductVersion.setImage(rs.getString("VerImage"));
            productViewModel.ProductVersion.setQuantum(rs.getInt("VerQuanTum"));
            productViewModel.ProductVersion.setPrice(rs.getInt("VerPrice"));
            productViewModel.ProductVersion.setPromotionPrice(rs.getInt("VerPromotionPrice"));
            productViewModel.ProductVersion.setRemainingAmount(rs.getInt("RemainingAmount"));
            productViewModels.add(productViewModel);
        }
        rs.close();
        stmt.close();
        conn.close();
        return productViewModels;


    }


}
