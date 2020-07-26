/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Service.IService;

import com.EShop.Model.Content;
import com.EShop.Model.ContentTag;
import java.sql.SQLException;
import java.util.List;

public interface IContentTagService extends IDbConnection<ContentTag> {
    public List<ContentTag> GetAllContentTag() throws SQLException;
    public void InsertContentTag(ContentTag json)throws SQLException;
    public void DeleteContentTag(Content jsons) throws SQLException;

}
