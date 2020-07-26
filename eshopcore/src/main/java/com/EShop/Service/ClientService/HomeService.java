package com.EShop.Service.ClientService;

import com.EShop.IService.IClientService.ICHomePageService;
import com.EShop.Model.*;
import com.EShop.Model.ViewModel.CatalogViewModel;
import com.EShop.Model.ViewModel.ProductDetailViewModel;
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
    public List<ProductDetailViewModel> GetNewProducts() throws SQLException {
        List<ProductDetailViewModel> productViewModels = new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery = "select p.Name,p.CreatedDate,p.SEOUrl,p.OriginalPrice,p.Content,p.Description\n" +
                "                ,p.Deliver,p.ApplyPromotion,c.Name as CatalogName,c.ID as CatalogId\n" +
                "                ,ver.ID as VerID,ver.Quantum as VerQuanTum,ver.Price as VerPrice\n" +
                "                ,ver.PromotionPrice as VerPromotionPrice\n" +
                "                ,ver.Image as VerImage\n" +
                "                from ProductVersions ver\n" +
                "                join Product p\n" +
                "                on p.ID= ver.ProductID\n" +
                "                join Catalog c\n" +
                "                on c.ID=p.CatalogID\n" +
                "                order by p.CreatedDate desc";
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


            productViewModels.add(productViewModel);
        }
        rs.close();
        stmt.close();
        conn.close();
        return productViewModels;
    }

    @Override
    public List<ProductDetailViewModel> GetBestSaleProducts() throws SQLException {
        List<ProductDetailViewModel> productViewModels = new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery = "select p.Name,p.CreatedDate,p.SEOUrl,p.OriginalPrice,p.Content,p.Description\n" +
                ",p.Deliver,p.ApplyPromotion,c.Name as CatalogName,c.ID as CatalogId\n" +
                ",ver.ID as VerID,ver.Quantum as VerQuanTum,ver.Price as VerPrice\n" +
                ",ver.PromotionPrice as VerPromotionPrice\n" +
                ",ver.Image as VerImage\n" +
                "from ProductVersions ver\n" +
                "join Product p\n" +
                "on p.ID= ver.ProductID\n" +
                "join Catalog c\n" +
                "on c.ID=p.CatalogID\n" +
                "join (select ver.ID,SUM(Quantity) as numBuy from ProductVersions ver\n" +
                "join OrderDetail o\n" +
                "on ver.ID =o.ProductVersionID\n" +
                "group by ver.ID) as child\n" +
                "on ver.ID=child.ID\n" +
                "order by child.numBuy desc";
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
        List<Slide> slides = new ArrayList<>();
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
