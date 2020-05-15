/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.IService;

import com.EShop.Model.Content;
import java.sql.SQLException;
import java.util.List;

public interface IContentService extends IDbConnection<Content> {
    public List<Content> GetContent() throws SQLException;
    public void InsertContent(Content content)throws SQLException;
    public void UpdateContent(Content content)throws SQLException;
    public void DeleteContent(Content[] content) throws SQLException;

}
