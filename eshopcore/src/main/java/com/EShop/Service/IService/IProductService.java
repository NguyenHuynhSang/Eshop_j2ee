package com.EShop.Service.IService;

import com.EShop.Filter.ProductFilter;
import com.EShop.Model.InputModel.ProductInput;
import com.EShop.Model.Product;
import com.EShop.Model.ProductVersion;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    public List<Product> GetProducts() throws SQLException;
    public List<ProductVersion> GetProductAllVersionList(ProductFilter filter) throws SQLException;
    public void InsertProduct(ProductInput product)throws SQLException;
    public ProductInput GetProductInputForEdit(int id) throws  SQLException;
    public void UpdateProduct(ProductInput input) throws  SQLException;
    public void UpdateProduct(Product product)throws SQLException;
    public void DeleteProduct(Product[] product) throws SQLException;
}
