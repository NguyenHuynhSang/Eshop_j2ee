/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Service;

import com.EShop.IService.IContentTagService;
import com.EShop.Model.Content;
import com.EShop.Model.ContentTag;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nhatminh
 */
public class ContentTagService implements IContentTagService{
     Connection conn = DbConnection.getJDBCConnection();
    @Override
     public List<ContentTag> GetAllContentTag() throws SQLException
    {
        List<ContentTag> jsons= new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery="SELECT * FROM ContentTag";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while(rs.next())
        {   
             String TagId=rs.getString("TagID");
             int ContentId = rs.getInt("ContentID");
             ContentTag json = new ContentTag(TagId,ContentId);
             jsons.add(json);
        }
        rs.close();
        stmt.close();
        conn.close();
        return jsons;
    }  
     @Override
     public void InsertContentTag(ContentTag json)throws SQLException
     {
        Statement statement;
        statement = conn.createStatement();
        String sqlQuery="INSERT INTO ContentTag (TagID, ContentID) VALUES ('"+json.getTagID()+"','"+json.getContentID()+"');";
        int rowCount=statement.executeUpdate(sqlQuery);
        statement.close();
        conn.close();
     }
  
     @Override
     public void DeleteContentTag(Content jsons) throws SQLException
     {
        Statement statement = conn.createStatement();
        String sqlQuery="DELETE FROM ContentTag WHERE ContentID="+jsons.getID();
        int rowCount=statement.executeUpdate(sqlQuery);
     }
}
