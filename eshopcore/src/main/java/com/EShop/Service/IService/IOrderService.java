package com.EShop.Service.IService;

import com.EShop.Model.ProductCatalog;
import com.EShop.Model.ViewModel.CatalogTreeModel;
import com.EShop.Model.ViewModel.CatalogViewModel;
import com.EShop.dto.admin.OrderListDto;

import java.sql.SQLException;
import java.util.List;

public interface IOrderService {
    public List<OrderListDto> GetOrderListDto() throws SQLException;
}
