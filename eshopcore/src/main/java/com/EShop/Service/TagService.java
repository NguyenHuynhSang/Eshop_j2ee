/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Service;

import com.EShop.Service.IService.ITagService;
import com.EShop.Mapper.TagMapper;
import com.EShop.Model.Tag;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
public class TagService extends DbConnection<Tag> implements ITagService{
    Connection conn = DbConnection.getJDBCConnection();
     @Override
     public List<Tag> GetTag() throws SQLException
    {
        String sql="SELECT * FROM Tag";
        return query(sql,new TagMapper());
    }  
     
    public List<Tag> GetJSONByID(String ID) throws SQLException
    {
       String sqlQuery = "SELECT * FROM Tag WHERE ID = ?";
       return query(sqlQuery,new TagMapper(), ID);
    }
     
    
      public List<Tag> GetAllTagByKey(String key) throws SQLException {
        String sqlQuery;
        if (key != "") {
            try {
                sqlQuery = "select * from Tag  where ID= ? OR TagtName LIKE %?%";
                return query(sqlQuery,new TagMapper(),key,key);
            } catch (NumberFormatException e) {
                sqlQuery = "select * from Tag where  TagtName LIKE ?";
                return query(sqlQuery, new TagMapper(),key);
            }
        }  
        return null;
    }

     @Override
     public void InsertTag(Tag tag)throws SQLException
     {
          String sqlQuery="INSERT INTO Tag (ID, TagtName) VALUES (?,?)";
          Update(sqlQuery,tag.getID(),tag.getName());
     }
     
   
     @Override
     public void UpdateTag(Tag tag)throws SQLException
     {
        String sqlQuery="UPDATE Tag SET TagtName = ? WHERE ID = ?";
        Update(sqlQuery,tag.getName(),tag.getID());
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
                 sqlQuery="DELETE FROM Tag WHERE TagID='"+rs.getInt("ID")+"';";
                 int rowCount=statement.executeUpdate(sqlQuery);
             }
         }
         
     }
}
