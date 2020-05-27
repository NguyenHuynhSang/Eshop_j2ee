package com.EShop.IService;

import com.EShop.Model.Catalog;

import java.sql.SQLException;
import java.util.List;

public interface ICatalogService {
    public List<Catalog> GetCatalog() throws SQLException;
    public void InsertCatalog(Catalog catalog)throws SQLException;
    public void UpdateCatalog(Catalog catalog)throws SQLException;
    public void DeleteCatalog(Catalog[] catalog) throws SQLException;

}
