/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Service;

import com.EShop.IService.IContentCategoryService;
import com.EShop.Model.ContentCategory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class ContentCategoryService implements IContentCategoryService {
        Connection conn = DbConnection.getJDBCConnection();
    @Override
    public List<ContentCategory> GetContentCategory() throws SQLException
    {
        List<ContentCategory> ContentCategories= new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery="SELECT * FROM ContentCategory";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while(rs.next())
        {   
             int id=rs.getInt("ID");
             String name = rs.getString("Name");
             int ParentID=rs.getInt("ParentID");
             String MetaTitle=rs.getString("MetaTitle");
             String SeoTitle=rs.getString("SeoTitle");
             int DisplayOrder=rs.getInt("DisplayOrder");
             Date CreateDate=rs.getDate("CreateDate");
             String CreateBy=rs.getString("CreateBy");
             Date ModifiedDate=rs.getDate("ModifiedDate");
             String ModifiedBy=rs.getString("ModifiedBy");
             String MetaKeyWords=rs.getString("MetaKeyWords");
             String MetaDescription=rs.getString("MetaDescriptions");
             boolean Status= rs.getBoolean("Status");
             boolean ShowOnHome =rs.getBoolean("ShowOnHome");
             String Language=rs.getString("Language");
             ContentCategory contentcategory = new ContentCategory(id,name,ParentID,MetaTitle,SeoTitle,DisplayOrder,CreateDate,CreateBy
                                                                  ,ModifiedDate,ModifiedBy,MetaKeyWords,MetaDescription,Status,ShowOnHome,Language);
             ContentCategories.add(contentcategory);
        }
        rs.close();
        stmt.close();
        conn.close();
        return ContentCategories;
    }  
    
    @Override
     public void InsertContentCategory(ContentCategory category)throws SQLException
     {
        Statement statement;
        statement = conn.createStatement();
        String sqlQuery="SELECT * FROM ContentCategory WHERE ID="+category.getID();
        ResultSet rs;
        rs = statement.executeQuery(sqlQuery);
        if (rs.next() == false)
        {
          sqlQuery="INSERT INTO ContentCategory (ID, Name, ParentID, MetaTitle, SeoTitle, DisPlayOrder, CreateDate, CreateBy, MetaKeyWords, MetaDescriptions, Status, ShowOnHome,Language)"
                  + " VALUES ('"+category.getID()+"'";
          if(category.getName()!=null)
              sqlQuery+=",'"+category.getName()+"'";
          else sqlQuery+=",null";
          sqlQuery+=","+category.getParentID();
          if(category.getMetatitle()!=null)
              sqlQuery+=",'"+category.getMetatitle()+"'";
          else sqlQuery+=",null";
          if(category.getSeoTitle()!=null)
              sqlQuery+=",'"+category.getSeoTitle()+"'";
          else sqlQuery+=",null";
          sqlQuery+=","+category.getDisplayOrder();
          if(category.getCreateDate()!=null)   
              sqlQuery+=",'"+category.getCreateDate().toString()+"'";
          else sqlQuery+=",null";
          if(category.getCreateBy()!=null)
              sqlQuery+=",'"+category.getCreateBy()+"'";
          else sqlQuery+=",null";
          if(category.getMetaKeyWords()!=null)
              sqlQuery+=",'"+category.getMetaKeyWords()+"'";
          else sqlQuery+=",null";
          if(category.getMetaDesciptions()!=null)
              sqlQuery+=",'"+category.getMetaDesciptions()+"'";
          else sqlQuery+=",null";
          sqlQuery = sqlQuery +",'"+category.isStatus()+"','"+category.isShowOnHome()+"'";
          if(category.getLanguage()!=null)
              sqlQuery+=",'"+category.getLanguage()+"'";
          else sqlQuery+=",null";
          sqlQuery+=");";
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
     public void UpdateContentCategory(ContentCategory category)throws SQLException
     {
        Statement statement;
        statement = conn.createStatement();
        String sqlQuery="SELECT * FROM ContentCategory WHERE ID="+category.getID();
        ResultSet rs;
        rs = statement.executeQuery(sqlQuery);
        if (rs.next() == false)
        {
            System.out.println("khong tim thay doi tuong can sua");
        }
        else
        {
          sqlQuery="UPDATE ContentCategory SET ";                         
          if(category.getName()!=null)
              sqlQuery+="Name='"+category.getName()+"'";
          else sqlQuery+="Name=null";
          sqlQuery+=",ParentID="+category.getParentID();
          if(category.getMetatitle()!=null)
              sqlQuery+=",MetaTitle='"+category.getMetatitle()+"'";
          else sqlQuery+=",MetaTitle=null";
          if(category.getSeoTitle()!=null)
              sqlQuery+=",SeoTitle='"+category.getSeoTitle()+"'";
          else sqlQuery+=",SeoTitle=null";
          sqlQuery+=",DisplayOrder="+category.getDisplayOrder();
          if(category.getModifiedDate()!=null)
              sqlQuery+=",ModifiedDate='"+category.getModifiedDate().toString()+"'";
          else sqlQuery+=",ModifiedDate=null";
          if(category.getModifiedBy()!=null)
              sqlQuery+=",ModifiedBy='"+category.getModifiedBy()+"'";
          else sqlQuery+=",ModifiedBy=null";
          if(category.getMetaKeyWords()!=null)
              sqlQuery+=",MetaKeyWords='"+category.getMetaKeyWords()+"'";
          else sqlQuery+=",MetaKeyWords=null";
          if(category.getMetaDesciptions()!=null)
              sqlQuery+=",MetaDescriptions='"+category.getMetaDesciptions()+"'";
          sqlQuery+=",Status='"+category.isStatus()+"',ShowOnHome='"+category.isShowOnHome()+"'";
          if(category.getLanguage()!=null)
              sqlQuery+=",Language='"+category.getLanguage()+"' ";
          else sqlQuery+=",Language=null ";
          sqlQuery+=" WHERE ID ='"+category.getID()+"';";
          int rowCount=statement.executeUpdate(sqlQuery);
        }
        rs.close();
        statement.close();
        conn.close();
     }
    @Override
    public void DeleteContentCategory(ContentCategory[] categories) throws SQLException
     {
         Statement statement = conn.createStatement();
         for (ContentCategory category : categories) {
             String sqlQuery = "SELECT * FROM ContentCategory Where ID=" + category.getID();
             ResultSet rs=statement.executeQuery(sqlQuery);
             if(rs.next()!=false)
             {
                 sqlQuery="DELETE FROM ContentCategory WHERE ID='"+rs.getInt("ID")+"';";
                 int rowCount=statement.executeUpdate(sqlQuery);
             }
         }
         
     }
}
