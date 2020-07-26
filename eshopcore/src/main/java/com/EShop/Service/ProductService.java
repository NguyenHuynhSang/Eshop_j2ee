package com.EShop.Service;

import com.EShop.IService.IClientService.ICProductService;
import com.EShop.IService.IProductService;
import com.EShop.Model.InputModel.ProductInput;
import com.EShop.Model.InputModel.ProductVersionInput;
import com.EShop.Model.Product;
import com.EShop.Model.ProductAttribute;
import com.EShop.Model.ProductCatalog;
import com.EShop.Model.ProductVersion;
import com.EShop.Model.ViewModel.CatalogViewModel;
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
    public List<Product> GetProductAllVersionPaging() throws SQLException {
        return null;
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


                if (product.Versions!=null)
                {
                    for (ProductVersionInput ver:
                            product.Versions) {

                        sqlQuery = "Insert into ProductVersions(ProductID,WareHouseID,Description,Price,PromotionPrice,Quantum,RemainingAmount,SKU,Barcode,Image) \n" +
                                "values (?, ?, ?, ?,?,?,?,?,?,?)";
                        PreparedStatement verStatement = conn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
                        ver.ProductID=productID;
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
                        ResultSet rs_ver = verStatement .getGeneratedKeys();
                       if (rs_ver.next())
                       {
                           int verId = Integer.parseInt(rs_ver.getObject(1).toString());
                           for (ProductAttribute attribute:
                                   ver.Attributes)
                           {

                               sqlQuery = "Insert into ProductAttribute(AttributeValueID,ProductVersionID) \n" +
                                       "values (?, ?)";
                               PreparedStatement attStament = conn.prepareStatement(sqlQuery);

                               int attID=attribute.getAttributeValueID();
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
        ProductDetailViewModel productViewModel= new ProductDetailViewModel();
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
                "where ver.ID="+Id;
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            productViewModel.Catalog=new ProductCatalog();
            productViewModel.Catalog.setName(rs.getString("CatalogName"));
            productViewModel.Product=new Product();
            productViewModel.Product.setSEOUrl(rs.getString("SEOUrl"));
            productViewModel.Product.setOriginalPrice(rs.getInt("OriginalPrice"));
            productViewModel.Product.setContent(rs.getString("Content"));
            productViewModel.Product.setDescription(rs.getString("Description"));
            productViewModel.Product.setName(rs.getString("Name"));

            productViewModel.ProductVersion=new ProductVersion();
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
}
