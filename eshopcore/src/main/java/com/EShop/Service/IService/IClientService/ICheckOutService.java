package com.EShop.Service.IService.IClientService;

import com.EShop.Model.UserModel.Order;
import com.EShop.Model.ViewModel.CatalogViewModel;

import java.sql.SQLException;
import java.util.List;

public interface ICheckOutService {
    public void CheckOut(Order order) throws SQLException;
}
