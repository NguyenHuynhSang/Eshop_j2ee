package com.EShop.Service;

import com.EShop.IService.ICatalogService;
import com.EShop.Model.Catalog;

import java.sql.SQLException;
import java.util.List;

public class CatalogService implements ICatalogService {
    @Override
    public List<Catalog> GetCatalog() throws SQLException {
        return null;
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
