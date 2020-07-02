package com.EShop.IService.IClientService;

import com.EShop.Model.InputModel.ProductInput;
import com.EShop.Model.Product;
import com.EShop.Model.ViewModel.ProductViewModel;

import java.sql.SQLException;
import java.util.List;

public interface ICProductService {

    public ProductViewModel GetProductByID(int id) throws  SQLException;
}
