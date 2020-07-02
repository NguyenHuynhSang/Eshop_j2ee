/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.IService;

import com.EShop.Model.ContentCategory;
import com.EShop.ViewModel.ContentCategoryViewModel;
import java.sql.SQLException;
import java.util.List;
public interface IContentCategoryService extends IDbConnection<ContentCategoryViewModel> {
    public List<ContentCategoryViewModel> GetContentCategory() throws SQLException;
    public void InsertContentCategory(ContentCategory tag)throws SQLException;
    public void UpdateContentCategory(ContentCategoryViewModel tag)throws SQLException;
    public void DeleteContentCategory(int id) throws SQLException;

}
