package com.EShop.IService.IClientService;

import com.EShop.Model.InputModel.ProductInput;
import com.EShop.Model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ICProductService {
    public List<Product> GetProducts() throws SQLException;
    public List<Product> GetProductViewDetail(int id) throws SQLException;
    public List<Product> GetProductsFilter() throws SQLException;
    public List<Product> GetProductsByCategory() throws SQLException;

}
