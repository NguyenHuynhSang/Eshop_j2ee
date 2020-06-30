/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.IService;


import com.EShop.Model.Footer;
import java.sql.SQLException;
import java.util.List;
public interface IFooterService extends IDbConnection<Footer> {
    public List<Footer> GetFooter() throws SQLException;
    public void InsertFooter(Footer footer)throws SQLException;
    public void UpdateFooter(Footer footer)throws SQLException;
    public void DeleteFooter(int footer) throws SQLException;
}
