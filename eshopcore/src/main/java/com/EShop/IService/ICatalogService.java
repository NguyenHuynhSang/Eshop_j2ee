package com.EShop.IService;

import com.EShop.Model.Catalog;
import com.EShop.Model.ViewModel.CatalogTreeModel;
import com.EShop.Model.ViewModel.CatalogViewModel;

import java.sql.SQLException;
import java.util.List;

public interface ICatalogService {
    public List<CatalogViewModel> GetCatalogs() throws SQLException;
    public List<CatalogTreeModel> GetCatalogsTree() throws SQLException;
    public List<Catalog> GetChildCatalogs() throws SQLException;
    public List<Catalog> GetParentCatalogs() throws SQLException;
    public void InsertCatalog(Catalog catalog)throws SQLException;
    public void UpdateCatalog(Catalog catalog)throws SQLException;
    public void DeleteCatalog(Catalog[] catalog) throws SQLException;

}
