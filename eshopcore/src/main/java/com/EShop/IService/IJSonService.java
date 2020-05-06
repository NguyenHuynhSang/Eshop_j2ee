/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.IService;

import com.EShop.Model.JSon;
import java.sql.SQLException;
import java.util.List;

public interface IJSonService {
    public List<JSon> GetAllJSon() throws SQLException;
    public void InsertJson(JSon json) throws SQLException;
    public void UpdateJson(JSon json) throws SQLException;
    public void DeleteJSon(int id) throws SQLException;

}
