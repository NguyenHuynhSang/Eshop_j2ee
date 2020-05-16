/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Mapper;

import com.EShop.Model.Content;
import com.EShop.Model.ContentCategory;
import com.EShop.ViewModel.ContentViewModel;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhatminh
 */
public class ContentViewModelMapper implements RowMapper<ContentViewModel>{
    
    @Override
    public ContentViewModel mapRow(ResultSet rs)
    {
        try {
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
             
             int CategoryId=rs.getInt("cCategoryID");
             String CategoryName = rs.getString("CategoryName");
             int CategoryParentID=rs.getInt("CategoryParentID");
             String CategoryMetaTitle=rs.getString("CategoryMetaTitle");
             String CategorySeoTitle=rs.getString("CategorySeoTitle");
             int CategoryDisplayOrder=rs.getInt("CategoryDisplayOrder");
             Date CategoryCreateDate=rs.getDate("CategoryCreateDate");
             String CategoryCreateBy=rs.getString("CategoryCreateBy");
             Date CategoryModifiedDate=rs.getDate("CategoryModifiedDate");
             String CategoryModifiedBy=rs.getString("CategoryModifiedBy");
             String CategoryMetaKeyWords=rs.getString("CategoryMetaKeyWords");
             String CategoryMetaDescription=rs.getString("CategoryMetaDescription");
             boolean CategoryStatus= rs.getBoolean("CategoryStatus");
             boolean CategoryShowOnHome =rs.getBoolean("CategoryShowOnHome");
             String CategoryLanguage=rs.getString("CategoryLanguage");
             
             Content content = new Content(id,name,MetaTitle,Description,
                                                   Image,CategoryID,Detail,Warranty,
                                                   CreateDate,CreateBy,ModifiedDate,
                                                   ModifiedBy,MetaKeyWords,MetaDescription,
                                                   Status,TopHot,ViewCount,Tags,Language);
            ContentCategory contentcategory = new ContentCategory(CategoryId,CategoryName,CategoryParentID,CategoryMetaTitle,CategorySeoTitle,CategoryDisplayOrder,CategoryCreateDate,CategoryCreateBy
                                                                  ,CategoryModifiedDate,CategoryModifiedBy,CategoryMetaKeyWords,CategoryMetaDescription,CategoryStatus,CategoryShowOnHome,CategoryLanguage);
            ContentViewModel view = new ContentViewModel(content,contentcategory);
            
            return view;
        } catch (SQLException ex) {
            Logger.getLogger(ContentViewModelMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
