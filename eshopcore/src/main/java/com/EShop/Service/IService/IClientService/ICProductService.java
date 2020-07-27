package com.EShop.Service.IService.IClientService;

import com.EShop.Filter.ProductClientFilter;
import com.EShop.Model.ViewModel.ProductDetailViewModel;
import com.EShop.Model.ViewModel.ProductViewModel;

import java.sql.SQLException;
import java.util.List;

public interface ICProductService {

    public ProductViewModel GetProductByID(int id) throws  SQLException;
    public ProductDetailViewModel GetProductVertionDetailByID(int Id) throws  SQLException;
    public List<ProductDetailViewModel> GetListProductsByFilter(ProductClientFilter filter) throws SQLException;


}
