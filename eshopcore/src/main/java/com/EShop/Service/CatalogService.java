package com.EShop.Service;

import com.EShop.IService.ICatalogService;
import com.EShop.Model.Attribute;
import com.EShop.Model.Catalog;
import com.EShop.Model.ViewModel.CatalogTreeModel;
import com.EShop.Model.ViewModel.CatalogViewModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            Catalog catalog = new Catalog(rs.getInt("ID"),
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
            Catalog parent = new Catalog(rs.getInt("ID"),
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

            Statement childStatement=conn.createStatement();
            String sqlQueryChild = "select *\n" +
                    "from Catalog\n" +
                    "where ParentID = "+parent.getID();
            ResultSet rsChild = childStatement.executeQuery(sqlQueryChild);

            catalogTree.Childs=new ArrayList<>();
            while (rsChild.next()) {

                Catalog child = new Catalog(rsChild.getInt("ID"),
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
    public void InsertCatalog(Catalog catalog) throws SQLException {

    }

    @Override
    public void UpdateCatalog(Catalog catalog) throws SQLException {

    }

    @Override
    public void DeleteCatalog(Catalog[] catalog) throws SQLException {

    }
}
