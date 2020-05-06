/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Service;

import com.EShop.IService.ITagService;
import com.EShop.Model.Tag;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class TagService implements ITagService{
    Connection conn = DbConnection.getJDBCConnection();
     @Override
     public List<Tag> GetTag() throws SQLException
    {
        List<Tag> tags= new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery="SELECT * FROM Tag";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while(rs.next())
        {   
             String id=rs.getString("TagID");
             String name = rs.getString("TagName");
             Tag tag = new Tag(id,name);
             tags.add(tag);
        }
        rs.close();
        stmt.close();
        conn.close();
        return tags;
    }  
     @Override
     public void InsertTag(Tag tag)throws SQLException
     {
        Statement statement;
        statement = conn.createStatement();
        String sqlQuery="SELECT * FROM Tag WHERE TagID='"+tag.getID()+"'";
        ResultSet rs;
        rs = statement.executeQuery(sqlQuery);
        if (rs.next() == false)
        {
          sqlQuery="INSERT INTO Tag (TagID, TagName) VALUES ('"+tag.getID()+"','"+tag.getName()+"');";
          int rowCount=statement.executeUpdate(sqlQuery);
        }
        else
        {
            System.out.println("id da ton tai");
        }
        rs.close();
        statement.close();
        conn.close();
     }
     @Override
     public void UpdateTag(Tag tag)throws SQLException
     {
        Statement statement;
        statement = conn.createStatement();
        String sqlQuery="SELECT * FROM Tag WHERE TagID="+tag.getID();
        ResultSet rs;
        rs = statement.executeQuery(sqlQuery);
        if (rs.next() == false)
        {
            System.out.println("khong tim thay doi tuong can sua");
        }
        else
        {
          sqlQuery="UPDATE Tag SET TagName = '"+tag.getName()+"' WHERE TagID = '"+tag.getID()+"';";
          int rowCount=statement.executeUpdate(sqlQuery);
        }
        rs.close();
        statement.close();
        conn.close();
     }
    @Override
    public void DeleteTag(Tag[] tags) throws SQLException
     {
         Statement statement = conn.createStatement();
         for (Tag tag : tags) {
             String sqlQuery = "SELECT * FROM Tag Where TagID=" + tag.getID();
             ResultSet rs=statement.executeQuery(sqlQuery);
             if(rs.next()!=false)
             {
                 sqlQuery="DELETE FROM Tag WHERE TagID='"+rs.getInt("TagID")+"';";
                 int rowCount=statement.executeUpdate(sqlQuery);
             }
         }
         
     }
}
