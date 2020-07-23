package com.EShop.Service.IService;

import com.EShop.Model.ProductCatalog;
import com.EShop.Model.ViewModel.CatalogTreeModel;
import com.EShop.Model.ViewModel.CatalogViewModel;

import java.sql.SQLException;
import java.util.List;

public interface ICatalogService {
    public List<CatalogViewModel> GetCatalogs() throws SQLException;
    public List<CatalogTreeModel> GetCatalogsTree() throws SQLException;
    public List<ProductCatalog> GetChildCatalogs() throws SQLException;
    public List<ProductCatalog> GetParentCatalogs() throws SQLException;
    public void InsertCatalog(ProductCatalog catalog)throws SQLException;
    public void UpdateCatalog(ProductCatalog catalog)throws SQLException;
    public void DeleteCatalog(ProductCatalog[] catalog) throws SQLException;

}
