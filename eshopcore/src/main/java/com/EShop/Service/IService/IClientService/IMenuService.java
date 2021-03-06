package com.EShop.Service.IService.IClientService;

import com.EShop.Model.Menu;

import java.sql.SQLException;
import java.util.List;

public interface IMenuService {
    public List<Menu> GetListMenusByGroupId(int id) throws SQLException;
    public List<Menu> GetMenu() throws SQLException;
    public void InsertMenu(Menu menu)throws SQLException;
    public void UpdateMenu(Menu menu)throws SQLException;
    public void DeleteMenu(int ID) throws SQLException;
}
