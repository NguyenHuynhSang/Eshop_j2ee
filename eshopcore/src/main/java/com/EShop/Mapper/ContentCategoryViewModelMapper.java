/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Mapper;

import com.EShop.Model.ContentCategory;
import com.EShop.ViewModel.ContentCategoryViewModel;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhatminh
 */
public class ContentCategoryViewModelMapper implements RowMapper<ContentCategoryViewModel>{
    
    @Override
    public ContentCategoryViewModel mapRow(ResultSet rs)
    {
        try {
             ContentCategory child = new ContentCategory();
             child.setID(rs.getInt("ID"));
             child.setName(rs.getString("Name"));
             child.setParentID(rs.getInt("ParentID"));
             child.setMetatitle(rs.getString("MetaTitle"));
             child.setSeoTitle(rs.getString("SeoTitle"));
             child.setDisplayOrder(rs.getInt("DisplayOrder"));
             child.setCreateDate(rs.getDate("CreatedDate"));
             child.setCreateBy(rs.getString("CreatedBy"));
             child.setModifiedDate(rs.getDate("ModifiedDate"));
             child.setModifiedBy(rs.getString("ModifiedBy"));
             child.setMetaKeyWords(rs.getString("MetaKeyWords"));
             child.setMetaDesciptions(rs.getString("MetaDescriptions"));
             child.setStatus(rs.getBoolean("Status"));
             child.setShowOnHome(rs.getBoolean("ShowOnHome"));
             child.setLanguage(rs.getString("Language"));
             
             ContentCategory parent = new ContentCategory();
             parent.setID(rs.getInt("sParentID"));
             parent.setName(rs.getString("ParentName"));
             parent.setParentID(rs.getInt("cParentID"));
             parent.setMetatitle(rs.getString("ParentMetaTitle"));
             parent.setSeoTitle(rs.getString("ParentSeoTitle"));
             parent.setDisplayOrder(rs.getInt("ParentDisplayOrder"));
             parent.setCreateDate(rs.getDate("ParentCreateDate"));
             parent.setCreateBy(rs.getString("ParentCreateBy"));
             parent.setModifiedDate(rs.getDate("ParentModifiedDate"));
             parent.setModifiedBy(rs.getString("ParentModifiedBy"));
             parent.setMetaKeyWords(rs.getString("ParentMetaKeyWords"));
             parent.setMetaDesciptions(rs.getString("ParentMetaDescription"));
             parent.setStatus(rs.getBoolean("ParentStatus"));
             parent.setShowOnHome(rs.getBoolean("ParentShowOnHome"));
             parent.setLanguage(rs.getString("ParentLanguage"));
             
             ContentCategoryViewModel viewmodel = new ContentCategoryViewModel(child,parent);
             return viewmodel;
        } catch (SQLException ex) {
            Logger.getLogger(ContentCategoryViewModelMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
