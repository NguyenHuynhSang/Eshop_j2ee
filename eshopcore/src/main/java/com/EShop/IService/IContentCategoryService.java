/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.IService;

import com.EShop.Model.ContentCategory;
import java.sql.SQLException;
import java.util.List;
public interface IContentCategoryService {
    public List<ContentCategory> GetContentCategory() throws SQLException;
    public void InsertContentCategory(ContentCategory tag)throws SQLException;
    public void UpdateContentCategory(ContentCategory tag)throws SQLException;
    public void DeleteContentCategory(ContentCategory[] tag) throws SQLException;

}
