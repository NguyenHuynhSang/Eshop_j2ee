package com.EShop.Service.IService.IClientService;

import com.EShop.Model.ViewModel.ProductDetailViewModel;
import com.EShop.Model.ViewModel.ProductViewModel;

import java.sql.SQLException;

public interface ICProductService {

    public ProductViewModel GetProductByID(int id) throws  SQLException;
    public ProductDetailViewModel GetProductVertionDetailByID(int Id) throws  SQLException;
}
