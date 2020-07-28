package com.EShop.Service.IService;

import com.EShop.Filter.InvoiceFilter;
import com.EShop.Model.ProductCatalog;
import com.EShop.Model.UserModel.Order;
import com.EShop.Model.ViewModel.CatalogTreeModel;
import com.EShop.Model.ViewModel.CatalogViewModel;
import com.EShop.dto.admin.OrderInputDto;
import com.EShop.dto.admin.OrderListDto;

import java.sql.SQLException;
import java.util.List;

public interface IOrderService {
    public List<OrderListDto> GetOrderListDto(InvoiceFilter filter) throws SQLException;
    public Order GetOrderDetail(int id) throws SQLException;
    public void AcviteOrder(int id,int code) throws SQLException;
    public void UpdateOrder(OrderInputDto inputDto) throws SQLException;
    public  OrderInputDto GetOrderByID(int ID) throws  SQLException;
    public  void DeleteOrderDetail(int ID) throws SQLException;
    public void UpdateOrderQuantity(int quantity) throws  SQLException;
    public  void AddOrderDetail() throws  SQLException;
}
