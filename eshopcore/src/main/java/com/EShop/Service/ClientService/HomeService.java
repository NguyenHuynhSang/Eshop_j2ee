package com.EShop.Service.ClientService;

import com.EShop.IService.IClientService.ICHomePageService;
import com.EShop.Model.Content;
import com.EShop.Model.Product;
import com.EShop.Model.ProductCatalog;
import com.EShop.Model.Slide;
import com.EShop.Model.ViewModel.CatalogViewModel;
import com.EShop.Model.ViewModel.ProductViewModel;
import com.EShop.Service.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HomeService implements ICHomePageService {
    Connection conn = DbConnection.getJDBCConnection();

    @Override
    public List<Product> GetHotProducts() throws SQLException {
        return null;
    }

    @Override
    public List<ProductViewModel> GetNewProducts() throws SQLException {
        List<ProductViewModel> productViewModels = new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery = "select p.Name,p.SEOUrl,p.OriginalPrice,p.Content,p.Description\n" +
                ",p.Deliver,p.ApplyPromotion,c.Name as CatalogName,c.ID as CatalogId\n" +
                ",ver.ID as VerID,ver.Quantum as VerQuanTum,ver.Price as VerPrice,ver.PromotionPrice as VerPromotionPrice\n" +
                "from ProductVersions ver\n" +
                "join Product p\n" +
                "on p.ID= ver.ProductID\n" +
                "join Catalog c\n" +
                "on c.ID=p.CatalogID\n" +
                "\n";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            ProductViewModel productViewModel  = new ProductViewModel();
            productViewModel.Catalog.setName(rs.getString("CatalogName"));
            productViewModel.Product.setSEOUrl(rs.getString("Name"));
            productViewModel.Product.setOriginalPrice(rs.getInt("Name"));
            productViewModel.Product.setContent(rs.getString("Name"));
            productViewModel.Product.setDescription(rs.getString("Name"));
            productViewModel.Product.setName(rs.getString("Name"));

            productViewModels.add(productViewModel);
        }
        rs.close();
        stmt.close();
        conn.close();
        return productViewModels;
    }

    @Override
    public List<Slide> GetSlide() throws SQLException {
        List<CatalogViewModel> catalogs = new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery = "select *\n" +
                "from Slide\n" +
                "where IsShow='true'";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        List<Slide> slides=new ArrayList<>();
        while (rs.next()) {
            Slide slide = new Slide(
                    rs.getInt("ID"),
                    rs.getString("Image"),
                    rs.getString("Url"),
                    rs.getBoolean("IsShow"),
                    rs.getString("CreatedBy"),
                    rs.getDate("CreatedDate"),
                    rs.getString("ModifiedBy"),
                    rs.getDate("ModifiedDate"),
                    rs.getString("Title"),
                    rs.getString("Content")
                    );
            slides.add(slide);
        }
        rs.close();
        stmt.close();
        conn.close();
        return slides;
    }

    @Override
    public List<Content> GetNewBlog() throws SQLException {
        return null;
    }
}
