/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Service;

import com.EShop.IService.IContentService;
import com.EShop.Mapper.ContentViewModelMapper;
import com.EShop.Model.Content;
import com.EShop.Model.ContentCategory;
import com.EShop.Model.ContentTag;
import com.EShop.Model.Tag;
import com.EShop.ViewModel.ContentViewModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContentService extends DbConnection<ContentViewModel> implements IContentService {
      Connection conn = DbConnection.getJDBCConnection();
    @Override
    public List<ContentViewModel> GetContent() throws SQLException
    {
        String sqlQuery="select b.ID,b.Name,b.MetaTitle,b.Description,b.Image,b.CategoryID,b.Detail,b.Warranty,b.CreatedDate\n" +
"	,b.CreatedBy,b.ModifiedDate,b.ModifiedBy,b.MetaKeywords,b.MetaDescriptions,b.Status\n" +
"	,b.TopHot,b.ViewCount,b.Tags,b.Language\n" +
"	,c.ID as cCategoryID,c.ParentID as CategoryParentID,c.Name as CategoryName,c.MetaTitle as CategoryMetaTitle\n" +
"	,c.SeoTitle as CategorySeoTitle, c.DisplayOrder as CategoryDisplayOrder\n" +
"	,c.CreatedDate as CategoryCreateDate,c.CreatedBy as CategoryCreateBy\n" +
"	,c.ModifiedDate as CategoryModifiedDate,c.ModifiedBy as CategoryModifiedBy\n" +
"	,c.MetaKeyWords as CategoryMetaKeyWords,c.MetaDescriptions as CategoryMetaDescription\n" +
"	,c.Status as CategoryStatus, c.ShowOnHome as CategoryShowOnHome\n" +
"	,c.Language as CategoryLanguage from Content b\n" +
"left join ContentCategory c on b.CategoryID = c.ID\n" +
"";
        
        return query(sqlQuery,new ContentViewModelMapper());
    }  
    
     public List<ContentViewModel> GetAllContentByKey(String key) throws SQLException {
        String sqlQuery ="select b.ID,b.Name,b.MetaTitle,b.Description,b.Image,b.CategoryID,b.Detail,b.Warranty,b.CreatedDate\n" +
"	,b.CreatedBy,b.ModifiedDate,b.ModifiedBy,b.MetaKeywords,b.MetaDescriptions,b.Status\n" +
"	,b.TopHot,b.ViewCount,b.Tags,b.Language\n" +
"	,c.ID as cCategoryID,c.ParentID as CategoryParentID,c.Name as CategoryName,c.MetaTitle as CategoryMetaTitle\n" +
"	,c.SeoTitle as CategorySeoTitle, c.DisplayOrder as CategoryDisplayOrder\n" +
"	,c.CreatedDate as CategoryCreateDate,c.CreatedBy as CategoryCreateBy\n" +
"	,c.ModifiedDate as CategoryModifiedDate,c.ModifiedBy as CategoryModifiedBy\n" +
"	,c.MetaKeyWords as CategoryMetaKeyWords,c.MetaDescriptions as CategoryMetaDescription\n" +
"	,c.Status as CategoryStatus, c.ShowOnHome as CategoryShowOnHome\n" +
"	,c.Language as CategoryLanguage  from Content b\n" +
"left join ContentCategory c on b.CategoryID = c.ID ";
        if (key != "") {
            try {
                int intValue= Integer.parseInt(key);
                sqlQuery += " where b.ID= ? OR b.Name LIKE ?";
                return query(sqlQuery,new ContentViewModelMapper(),intValue,key);
            } catch (NumberFormatException e) {
                sqlQuery += " where  b.Name LIKE ?";
                return query(sqlQuery,new ContentViewModelMapper(),key);
            }
        }
        return null;
    }  
     
     
       public List<ContentViewModel> GetContentByID(int ID) throws SQLException
    {
         String sqlQuery ="select b.ID,b.Name,b.MetaTitle,b.Description,b.Image,b.CategoryID,b.Detail,b.Warranty,b.CreatedDate\n" +
"	,b.CreatedBy,b.ModifiedDate,b.ModifiedBy,b.MetaKeywords,b.MetaDescriptions,b.Status\n" +
"	,b.TopHot,b.ViewCount,b.Tags,b.Language\n" +
"	,c.ID as cCategoryID,c.ParentID as CategoryParentID,c.Name as CategoryName,c.MetaTitle as CategoryMetaTitle\n" +
"	,c.SeoTitle as CategorySeoTitle, c.DisplayOrder as CategoryDisplayOrder\n" +
"	,c.CreatedDate as CategoryCreateDate,c.CreatedBy as CategoryCreateBy\n" +
"	,c.ModifiedDate as CategoryModifiedDate,c.ModifiedBy as CategoryModifiedBy\n" +
"	,c.MetaKeyWords as CategoryMetaKeyWords,c.MetaDescriptions as CategoryMetaDescription\n" +
"	,c.Status as CategoryStatus, c.ShowOnHome as CategoryShowOnHome\n" +
"	,c.Language as CategoryLanguage  from Content b\n" +
"left join ContentCategory c on b.CategoryID = c.ID Where b.ID = ? ";
         
        return query(sqlQuery,new ContentViewModelMapper(),ID);
    }

     
     @Override
     public void InsertContent(Content content)throws SQLException
     {
        Statement statement;
        statement = conn.createStatement();
        String sqlQuery="SELECT * FROM Content WHERE ID="+content.getID();
        ResultSet rs;
        rs = statement.executeQuery(sqlQuery);
        if (rs.next() == false)
        {
          sqlQuery="INSERT INTO Content (Name, MetaTitle, Description"
                  + ",Image, CategoryID, Detail, Warranty"
                  + ", MetaKeywords, MetaDescriptions"
                  + ", Status, TopHot, ViewCount, Tags, Language)"
                  + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
          Update(sqlQuery,content.getName(),content.getMetaTitle(),content.getDescription(),
                 content.getImage(),content.getCategoryID(),content.getDetail(),content.getWarranty(),
                 content.getMetaKeywords(),content.getMetaDescriptions(),content.isStatus(),content.getTopHot(),content.getViewCount(),content.getTags(),content.getLanguage());
          if(content.getTags()!=null)
          {
              String[] tags= content.getTags().split(",");
              for(String tag :tags)
              {
                  TagService tagservice = new TagService();
                  String tagID =tag;
                  String name=tag;
                  Tag entity=new Tag(tagID,name);
                  tagservice.InsertTag(entity);
                  
                  ContentTagService service=new ContentTagService();
                  ContentTag contenttag=new ContentTag(tag,content.getID());
                  service.InsertContentTag(contenttag);
              }
          }
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
     public void UpdateContent(Content content)throws SQLException
     {
        Statement statement;
        statement = conn.createStatement();
        String sqlQuery="SELECT * FROM Content WHERE ID="+content.getID();
        ResultSet rs;
        rs = statement.executeQuery(sqlQuery);
        if (rs.next() == false)
        {
            System.out.println("khong tim thay doi tuong can sua");
        }
        else
        {
          sqlQuery="UPDATE Content SET Name=?, MetaTitle=?,Description=?,Image=?,CategoryID=?,Detail=?,Warranty=?"
                  + ",MetaKeywords=?,MetaDescriptions=?,Status=?,Tags=?,Language=? WHERE ID = ?";
          Update(sqlQuery,content.getName(),content.getMetaTitle(),content.getDescription(),content.getImage(),
                  content.getCategoryID(),content.getDetail(),content.getWarranty(),content.getMetaKeywords(),content.getMetaDescriptions(),content.isStatus(),
                  content.getTags(),content.getLanguage(),content.getID());
          
          ContentTagService contenttagsv = new ContentTagService();
          contenttagsv.DeleteContentTag(content);
          if(content.getTags()!=null)
          {
              String[] tags= content.getTags().split(",");
              for(String tag :tags)
              {
                  TagService tagservice = new TagService();
                  String tagID =tag;
                  String name=tag;
                  Tag entity=new Tag(tagID,name);
                  tagservice.InsertTag(entity);
                  
                  ContentTagService service=new ContentTagService();
                  ContentTag contenttag=new ContentTag(tag,content.getID());
                  service.InsertContentTag(contenttag);
              }
          }
          
        }
     }
     @Override
    public void DeleteContent(int categories) throws SQLException
     {
        String sqlQuery = "Delete from Content Where ID = ?";
        Update(sqlQuery, categories);   
     }
}
