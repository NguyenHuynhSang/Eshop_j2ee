package com.EShop.IService;

import com.EShop.Model.Product;
import com.EShop.Model.Tag;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    public List<Product> GetProducts() throws SQLException;
    public void InsertProduct(Product product)throws SQLException;
    public void UpdateProduct(Product product)throws SQLException;
    public void DeleteProduct(Product[] product) throws SQLException;
}
