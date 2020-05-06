/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.IService;


import com.EShop.Model.Tag;
import java.sql.SQLException;
import java.util.List;
public interface ITagService {
    public List<Tag> GetTag() throws SQLException;
    public void InsertTag(Tag tag)throws SQLException;
    public void UpdateTag(Tag tag)throws SQLException;
    public void DeleteTag(Tag[] tag) throws SQLException;
}
