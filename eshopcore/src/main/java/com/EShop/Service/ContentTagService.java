/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Service;

import com.EShop.Service.IService.IContentTagService;
import com.EShop.Mapper.ContentTagMapper;
import com.EShop.Model.Content;
import com.EShop.Model.ContentTag;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author nhatminh
 */
public class ContentTagService extends DbConnection<ContentTag> implements IContentTagService{
     Connection conn = DbConnection.getJDBCConnection();
    @Override
     public List<ContentTag> GetAllContentTag() throws SQLException
    {
        String sqlQuery="SELECT * FROM ContentTag";
        return query(sqlQuery,new ContentTagMapper());
    }  
     @Override
     public void InsertContentTag(ContentTag json)throws SQLException
     {
        String sqlQuery="INSERT INTO ContentTag (TagID, ContentID) VALUES (?,?)";
        Update(sqlQuery,json.getTagID(),json.getContentID());
     }
  
     @Override
     public void DeleteContentTag(Content jsons) throws SQLException
     {
        Statement statement = conn.createStatement();
        String sqlQuery="DELETE FROM ContentTag WHERE ContentID="+jsons.getID();
        int rowCount=statement.executeUpdate(sqlQuery);
     }
}
