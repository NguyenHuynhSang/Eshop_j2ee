package com.EShop.IService.IClientService;

import com.EShop.Model.Menu;
import com.EShop.Model.ViewModel.ProductViewModel;

import java.sql.SQLException;
import java.util.List;

public interface IMenuService {
    public List<Menu> GetListMenusByGroupId(int id) throws SQLException;
}
