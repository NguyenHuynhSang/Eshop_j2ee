package com.EShop.Service;

import com.EShop.IService.ICatalogService;
import com.EShop.Model.ProductCatalog;
import com.EShop.Model.ViewModel.CatalogTreeModel;
import com.EShop.Model.ViewModel.CatalogViewModel;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CatalogService implements ICatalogService {
    Connection conn = DbConnection.getJDBCConnection();

    @Override
    public List<CatalogViewModel> GetCatalogs() throws SQLException {
        List<CatalogViewModel> catalogs = new ArrayList<>();
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
            CatalogViewModel catalogView = new CatalogViewModel();
            catalogView.ParentName = rs.getString("Parent");
            catalogView.Catalog = catalog;
            catalogs.add(catalogView);
        }
        rs.close();
        stmt.close();
        conn.close();
        return catalogs;
    }

    @Override
    public List<CatalogTreeModel> GetCatalogsTree() throws SQLException {
        List<CatalogTreeModel> catalogs = new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery = "select * \n" +
                "from Catalog \n" +
                "where ParentID IS NULL";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            CatalogTreeModel catalogTree = new CatalogTreeModel();
            ProductCatalog parent = new ProductCatalog(rs.getInt("ID"),
                    rs.getInt("ParentID"),
                    rs.getString("Name"),
                    rs.getDate("CreatedDate"),
                    rs.getString("CreatedBy"),
                    rs.getDate("ModifiedDate"),
                    rs.getString("ModifiedBy"),
                    rs.getString("SEOTitle"),
                    rs.getString("SEOUrl"),
                    rs.getString("SEODescription"));
            catalogTree.Parent = parent;

            Statement childStatement = conn.createStatement();
            String sqlQueryChild = "select *\n" +
                    "from Catalog\n" +
                    "where ParentID = " + parent.getID();
            ResultSet rsChild = childStatement.executeQuery(sqlQueryChild);

            catalogTree.Childs = new ArrayList<>();
            while (rsChild.next()) {

                ProductCatalog child = new ProductCatalog(rsChild.getInt("ID"),
                        rsChild.getInt("ParentID"),
                        rsChild.getString("Name"),
                        rsChild.getDate("CreatedDate"),
                        rsChild.getString("CreatedBy"),
                        rsChild.getDate("ModifiedDate"),
                        rsChild.getString("ModifiedBy"),
                        rsChild.getString("SEOTitle"),
                        rsChild.getString("SEOUrl"),
                        rsChild.getString("SEODescription"));

                catalogTree.Childs.add(child);


            }

            catalogs.add(catalogTree);
            childStatement.close();
            rsChild.close();
        }
        rs.close();
        stmt.close();
        conn.close();
        return catalogs;
    }

    @Override
    public List<ProductCatalog> GetChildCatalogs() throws SQLException {
        List<ProductCatalog> catalogs = new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery = "select *\n" +
                "from Catalog\n" +
                "where ParentID is not null";
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
            catalogs.add(catalog);
        }
        rs.close();
        stmt.close();
        conn.close();
        return catalogs;
    }

    @Override
    public List<ProductCatalog> GetParentCatalogs() throws SQLException {
        List<ProductCatalog> catalogs = new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery = "select *\n" +
                "from Catalog\n" +
                "where ParentID is null";
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
            catalogs.add(catalog);
        }
        rs.close();
        stmt.close();
        conn.close();
        return catalogs;
    }

    @Override
    public void InsertCatalog(ProductCatalog catalog) throws SQLException {
        Statement statement;
        String sqlQuery="SELECT * FROM Catalog WHERE ID="+catalog.getID(); // check trùng
        ResultSet rs;
        statement = conn.createStatement();


        String timeStamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(Calendar.getInstance().getTime());
        rs = statement.executeQuery(sqlQuery);
        if (rs.next() == false)
        {

            sqlQuery="Insert into Catalog (ParentID,Name,SEOTitle,SEOUrl,SEODescription,CreatedDate,CreatedBy) \n" +
                    "values (?, ?, ?, ?,?,?,?)";
            PreparedStatement pStatement=conn.prepareStatement(sqlQuery);
            //statement = conn.prepareStatement(sqlQuery);
            pStatement.setObject(1, catalog.getParentID());
            pStatement.setObject(2, catalog.getName());
            pStatement.setObject(3, catalog.getSEOTitle());
            pStatement.setObject(4, catalog.getSEOURL());
            pStatement.setObject(5, catalog.getSEODescription());
            pStatement.setObject(6, timeStamp);
            pStatement.setObject(7, catalog.getCreatedBy());
            int rowCount=pStatement.executeUpdate();
            pStatement.close();
        }
        else
        {
            System.out.println("id da ton tai");
        }
        rs.close();
        statement.close();
        conn.close();
    }

    @Override
    public void UpdateCatalog(ProductCatalog catalog) throws SQLException {

    }

    @Override
    public void DeleteCatalog(ProductCatalog[] catalog) throws SQLException {

    }
}
