/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Service;

import com.EShop.IService.IContentCategoryService;
import com.EShop.Mapper.ContentCategoryViewModelMapper;
import com.EShop.Model.ContentCategory;
import com.EShop.ViewModel.ContentCategoryViewModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ContentCategoryService extends DbConnection<ContentCategoryViewModel> implements IContentCategoryService {
    Connection conn = DbConnection.getJDBCConnection();

    @Override
    public List<ContentCategoryViewModel> GetContentCategory() throws SQLException {
        String sqlQuery = "select b.ID,b.Name,b.ParentID,b.MetaTitle,b.SeoTitle,b.DisplayOrder,\n" +
                "	b.CreatedDate,b.CreatedBy,b.ModifiedDate,b.ModifiedBy,b.MetaDescriptions\n" +
                "	,b.MetaKeyWords,b.Status,b.ShowOnHome,b.Language\n" +
                "	,c.ID as sParentID,c.ParentID as cParentID,c.Name as ParentName,c.MetaTitle as ParentMetaTitle\n" +
                "	,c.SeoTitle as ParentSeoTitle, c.DisplayOrder as ParentDisplayOrder\n" +
                "	,c.CreatedDate as ParentCreateDate,c.CreatedBy as ParentCreateBy\n" +
                "	,c.ModifiedDate as ParentModifiedDate,c.ModifiedBy as ParentModifiedBy\n" +
                "	,c.MetaKeyWords as ParentMetaKeyWords,c.MetaDescriptions as ParentMetaDescription\n" +
                "	,c.Status as ParentStatus, c.ShowOnHome as ParentShowOnHome\n" +
                "	,c.Language as ParentLanguage  from ContentCategory b\n" +
                "left join ContentCategory c on b.ParentID = c.ID";

        return query(sqlQuery, new ContentCategoryViewModelMapper());
    }

    public List<ContentCategoryViewModel> GetContentCategoryByID(int ID) throws SQLException {
        String sqlQuery = "select b.ID,b.Name,b.ParentID,b.MetaTitle,b.SeoTitle,b.DisplayOrder,\n" +
                "	b.CreatedDate,b.CreatedBy,b.ModifiedDate,b.ModifiedBy,b.MetaDescriptions\n" +
                "	,b.MetaKeyWords,b.Status,b.ShowOnHome,b.Language\n" +
                "	,c.ID as sParentID,c.ParentID as cParentID,c.Name as ParentName,c.MetaTitle as ParentMetaTitle\n" +
                "	,c.SeoTitle as ParentSeoTitle, c.DisplayOrder as ParentDisplayOrder\n" +
                "	,c.CreatedDate as ParentCreateDate,c.CreatedBy as ParentCreateBy\n" +
                "	,c.ModifiedDate as ParentModifiedDate,c.ModifiedBy as ParentModifiedBy\n" +
                "	,c.MetaKeyWords as ParentMetaKeyWords,c.MetaDescriptions as ParentMetaDescription\n" +
                "	,c.Status as ParentStatus, c.ShowOnHome as ParentShowOnHome\n" +
                "	,c.Language as ParentLanguage  from ContentCategory b\n" +
                "left join ContentCategory c on b.ParentID = c.ID where b.ID = ?";

        return query(sqlQuery, new ContentCategoryViewModelMapper(), ID);
    }

    public List<ContentCategoryViewModel> GetAllContentCategoryByKey(String key) throws SQLException {
        String sqlQuery = "select b.ID,b.Name,b.ParentID,b.MetaTitle,b.SeoTitle,b.DisplayOrder,\n" +
                "	b.CreatedDate,b.CreatedBy,b.ModifiedDate,b.ModifiedBy,b.MetaDescriptions\n" +
                "	,b.MetaKeyWords,b.Status,b.ShowOnHome,b.Language\n" +
                "	,c.ID as sParentID,c.ParentID as cParentID,c.Name as ParentName,c.MetaTitle as ParentMetaTitle\n" +
                "	,c.SeoTitle as ParentSeoTitle, c.DisplayOrder as ParentDisplayOrder\n" +
                "	,c.CreatedDate as ParentCreateDate,c.CreatedBy as ParentCreateBy\n" +
                "	,c.ModifiedDate as ParentModifiedDate,c.ModifiedBy as ParentModifiedBy\n" +
                "	,c.MetaKeyWords as ParentMetaKeyWords,c.MetaDescriptions as ParentMetaDescription\n" +
                "	,c.Status as ParentStatus, c.ShowOnHome as ParentShowOnHome\n" +
                "	,c.Language as ParentLanguage  from ContentCategory b\n" +
                "left join ContentCategory c on b.ParentID = c.ID";
        if (key != "") {
            try {
                int intValue = Integer.parseInt(key);
                sqlQuery += " where b.ID= ? OR b.Name LIKE ?";
                return query(sqlQuery, new ContentCategoryViewModelMapper(), intValue, "%" + key + "%");
            } catch (NumberFormatException e) {
                sqlQuery += " where  b.Name LIKE ?";
                return query(sqlQuery, new ContentCategoryViewModelMapper(), "%" + key + "%");
            }
        }
        return null;
    }

    @Override
    public void InsertContentCategory(ContentCategory category) throws SQLException {
        String sqlQuery = "INSERT INTO ContentCategory (Name, ParentID, MetaTitle, SeoTitle, DisPlayOrder, CreatedDate, CreatedBy, MetaKeyWords, MetaDescriptions, Status, ShowOnHome,Language)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Update(sqlQuery, category.getName(), category.getParentID(), category.getMetatitle(), category.getSeoTitle(),
                category.getDisplayOrder(), null, null, category.getMetaKeyWords(), category.getMetaDesciptions(),
                category.isStatus(), category.isShowOnHome(), category.getLanguage());


    }

    @Override
    public void UpdateContentCategory(ContentCategoryViewModel contentcategory) throws SQLException {
        String sqlQuery = "UPDATE ContentCategory SET Name = ?, ParentID = ?, MetaTitle = ?, SeoTitle = ?, DisplayOrder = ?, "
                + "ModifiedDate = ?, ModifiedBy = ?, MetaKeyWords = ?, MetaDescriptions = ?, Status = ?, ShowOnHome = ?, Language = ? "
                + "Where ID = ?";
        ContentCategory category = new ContentCategory();
        category = contentcategory.getCategory();
        Update(sqlQuery, category.getName(), category.getParentID(), category.getMetatitle(), category.getSeoTitle(),
                category.getDisplayOrder(), null, null, category.getMetaKeyWords(),
                category.getMetaDesciptions(), category.isStatus(), category.isShowOnHome(), category.getLanguage(), category.getID());
    }

    @Override
    public void DeleteContentCategory(int id) throws SQLException {
        String sqlQuery = "Delete from ContentCategory Where ID = ?";
        Update(sqlQuery, id);
    }
}
