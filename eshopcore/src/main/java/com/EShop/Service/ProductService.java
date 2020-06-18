package com.EShop.Service;

import com.EShop.IService.IProductService;
import com.EShop.Model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService  implements IProductService {
    @Override
    public List<Product> GetProducts() throws SQLException {
        return null;
    }

    @Override
    public List<Product> GetProductAllVersionPaging() throws SQLException {
        return null;
    }

    @Override
    public void InsertProduct(Product product) throws SQLException {

    }

    @Override
    public void UpdateProduct(Product product) throws SQLException {

    }

    @Override
    public void DeleteProduct(Product[] product) throws SQLException {

    }
}
