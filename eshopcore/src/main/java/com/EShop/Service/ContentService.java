/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Service;

import com.EShop.IService.IContentService;
import com.EShop.Model.Content;
import com.EShop.Model.ContentTag;
import com.EShop.Model.Tag;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContentService extends DbConnection<Content>  implements IContentService {
      Connection conn = DbConnection.getJDBCConnection();
    @Override
    public List<Content> GetContent() throws SQLException
    {
        List<Content> ContentCategories= new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery="SELECT * FROM Content";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while(rs.next())
        {   
             int id=rs.getInt("ID");
             String name = rs.getString("Name");
             String MetaTitle=rs.getString("MetaTitle");
             String Description=rs.getString("Description");
             String Image=rs.getString("Image");
             int CategoryID=rs.getInt("CategoryID");
             String Detail=rs.getString("Detail");
             int Warranty=rs.getInt("Warranty");
             Date CreateDate=rs.getDate("CreateDate");
             String CreateBy=rs.getString("CreateBy");
             Date ModifiedDate=rs.getDate("ModifiedDate");
             String ModifiedBy=rs.getString("ModifiedBy");
             String MetaKeyWords=rs.getString("MetaKeywords");
             String MetaDescription=rs.getString("MetaDescriptions");
             boolean Status= rs.getBoolean("Status");
             Date TopHot =rs.getDate("TopHot");
             int ViewCount=rs.getInt("ViewCount");
             String Tags=rs.getString("Tags");
             String Language=rs.getString("Language");
             Content contentcontent = new Content(id,name,MetaTitle,Description,
                                                   Image,CategoryID,Detail,Warranty,
                                                   CreateDate,CreateBy,ModifiedDate,
                                                   ModifiedBy,MetaKeyWords,MetaDescription,
                                                   Status,TopHot,ViewCount,Tags,Language);
             ContentCategories.add(contentcontent);
        }
        rs.close();
        stmt.close();
        conn.close();
        return ContentCategories;
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
          sqlQuery="INSERT INTO Content (ID, Name, MetaTitle, Description"
                  + ",Image, CategoryID, Detail, Warranty, CreateDate, CreateBy"
                  + ", MetaKeywords, MetaDescriptions"
                  + ", Status, TopHot, ViewCount, Tags, Language)"
                  + " VALUES ('"+content.getID()+"'";
          if(content.getName()!=null)
              sqlQuery+=",'"+content.getName()+"'";
          else sqlQuery+=",null";
          if(content.getMetaTitle()!=null)
              sqlQuery+=",'"+content.getMetaTitle()+"'";
          else sqlQuery+=",null";
          if(content.getDescription()!=null)
              sqlQuery+=",'"+content.getDescription()+"'";
          else sqlQuery+=",null";
          if(content.getImage()!=null)
              sqlQuery+=",'"+content.getImage()+"'";
          else sqlQuery+=",null";
          sqlQuery+=","+content.getCategoryID();
          if(content.getDetail()!=null)
              sqlQuery+=",'"+content.getDetail()+"'";
          else sqlQuery+=",null";
          sqlQuery+=","+content.getWarranty();
          if(content.getCreateDate()!=null)   
              sqlQuery+=",'"+content.getCreateDate().toString()+"'";
          else sqlQuery+=",null";
          if(content.getCreateBy()!=null)
              sqlQuery+=",'"+content.getCreateBy()+"'";
          else sqlQuery+=",null";          
          if(content.getMetaKeywords()!=null)
              sqlQuery+=",'"+content.getMetaKeywords()+"'";
          else sqlQuery+=",null";
          if(content.getMetaDescriptions()!=null)
              sqlQuery+=",'"+content.getMetaDescriptions()+"'";
          else sqlQuery+=",null";
          sqlQuery +=",'"+content.isStatus()+"'";
          if(content.getTopHot()!=null)
              sqlQuery+=",'"+content.getTopHot().toString()+"'";
          else sqlQuery+=",null";
          sqlQuery+=","+content.getViewCount();
          if(content.getTags()!=null)
              sqlQuery+=",'"+content.getTags()+"'";
          else sqlQuery+=",null";
          if(content.getLanguage()!=null)
              sqlQuery+=",'"+content.getLanguage()+"'";
          else sqlQuery+=",null";
          sqlQuery+=");";
          int rowCount=statement.executeUpdate(sqlQuery);
          
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
          sqlQuery="UPDATE Content SET ";                         
          if(content.getName()!=null)
              sqlQuery+="Name='"+content.getName()+"'";
          else sqlQuery+="Name=null";
          if(content.getMetaTitle()!=null)
              sqlQuery+=",MetaTitle='"+content.getMetaTitle()+"'";
          else sqlQuery+=",MetaTitle=null";
          if(content.getDescription()!=null)
              sqlQuery+=",Description ='"+content.getDescription()+"'";
          else sqlQuery+=",Description=null";
          if(content.getImage()!=null)
              sqlQuery+=",Image ='"+content.getImage()+"'";
          else sqlQuery+=",Image=null";
          sqlQuery+=",CategoryID ="+content.getCategoryID();
          if(content.getDetail()!=null)
              sqlQuery+=",Detail ='"+content.getDetail()+"'";
          else sqlQuery+=",Detail=null";
          sqlQuery+=",Warranty="+content.getWarranty();
          if(content.getModifiedDate()!=null)
              sqlQuery+=",ModifiedDate='"+content.getModifiedDate().toString()+"'";
          else sqlQuery+=",ModifiedDate=null";
          if(content.getModifiedBy()!=null)
              sqlQuery+=",ModifiedBy='"+content.getModifiedBy()+"'";
          else sqlQuery+=",ModifiedBy=null";
          if(content.getMetaKeywords()!=null)
              sqlQuery+=",MetaKeyWords='"+content.getMetaKeywords()+"'";
          else sqlQuery+=",MetaKeyWords=null";
          if(content.getMetaDescriptions()!=null)
              sqlQuery+=",MetaDescriptions='"+content.getMetaDescriptions()+"'";
          sqlQuery+=",Status='"+content.isStatus()+"',ViewCount="+content.getViewCount()+"";
          if(content.getTags()!=null)
              sqlQuery+=",Tags='"+content.getTags()+"'";
          else sqlQuery+=",Tags=null";
          if(content.getLanguage()!=null)
              sqlQuery+=",Language='"+content.getLanguage()+"' ";
          else sqlQuery+=",Language=null ";
          sqlQuery+=" WHERE ID ="+content.getID()+";";
          int rowCount=statement.executeUpdate(sqlQuery);
          
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
        rs.close();
        statement.close();
        conn.close();
     }
     @Override
    public void DeleteContent(Content[] categories) throws SQLException
     {
         Statement statement = conn.createStatement();
         for (Content content : categories) {
             String sqlQuery = "SELECT * FROM Content Where ID=" + content.getID();
             ResultSet rs=statement.executeQuery(sqlQuery);
             if(rs.next()!=false)
             {
                 sqlQuery="DELETE FROM Content WHERE ID='"+rs.getInt("ID")+"';";
                 int rowCount=statement.executeUpdate(sqlQuery);
                 ContentTagService contenttagsv = new ContentTagService();
                 contenttagsv.DeleteContentTag(content);
             }
         }
         
     }
}
