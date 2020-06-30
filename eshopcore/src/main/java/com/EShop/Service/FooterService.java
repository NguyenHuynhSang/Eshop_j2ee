/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Service;

import com.EShop.IService.IFooterService;
import com.EShop.Mapper.FooterMapper;
import com.EShop.Model.Footer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
public class FooterService extends DbConnection<Footer> implements IFooterService{
    Connection conn = DbConnection.getJDBCConnection();
     @Override
     public List<Footer> GetFooter() throws SQLException
    {
        String sql="SELECT * FROM Footer";
        return query(sql,new FooterMapper());
    }  
     
    public List<Footer> GetJSONByID(String ID) throws SQLException
    {
       String sqlQuery = "SELECT * FROM Footer WHERE ID = ?";
       return query(sqlQuery,new FooterMapper(), ID);
    }
     
    
      public List<Footer> GetAllFooterByKey(String key) throws SQLException {
        String sqlQuery;
        if (key != "") {
            try {
                sqlQuery = "select * from Footer  where ID= ? OR Content LIKE %?%";
                return query(sqlQuery,new FooterMapper(),key,key);
            } catch (NumberFormatException e) {
                sqlQuery = "select * from Footer where  Content LIKE ?";
                return query(sqlQuery, new FooterMapper(),key);
            }
        }  
        return null;
    }
      
      public Footer GetFooterActive() throws SQLException
      {
          String sqlQuery;
          sqlQuery = "select * from Footer Where IsShow = 'true'";
          return query(sqlQuery,new FooterMapper()).get(0);
      }

     @Override
     public void InsertFooter(Footer footer)throws SQLException
     {
          String sqlQuery="INSERT INTO Footer (Content,IsShow) VALUES (?,?)";
          Update(sqlQuery,footer.getID(),footer.getContent(),footer.isIsShow());
     }
     
   
     @Override
     public void UpdateFooter(Footer tag)throws SQLException
     {
        String sqlQuery="UPDATE Footer SET Content = ? , IsShow = ? WHERE ID = ?";
        Update(sqlQuery,tag.getContent(),tag.isIsShow(),tag.getID());
     }
    @Override
    public void DeleteFooter(int id) throws SQLException
     {
        String sqlQuery = "Delete from Footer Where ID = ?";
        Update(sqlQuery, id);
         
     }
    
    public void SetActiveFooter(int id) throws SQLException
    {
        String sqlQuery = "Update Footer Set IsShow = 'false'";
        Update(sqlQuery);
        sqlQuery ="Update Footer Set IsShow ='true' where ID = ?";
        Update(sqlQuery,id);
    }
}
