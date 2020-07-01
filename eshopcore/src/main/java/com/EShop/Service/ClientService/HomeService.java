package com.EShop.Service.ClientService;

import com.EShop.IService.IClientService.ICHomePageService;
import com.EShop.Model.Content;
import com.EShop.Model.Product;
import com.EShop.Model.ProductCatalog;
import com.EShop.Model.Slide;
import com.EShop.Model.ViewModel.CatalogViewModel;
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
    public List<Product> GetNewProducts() throws SQLException {
        return null;
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
