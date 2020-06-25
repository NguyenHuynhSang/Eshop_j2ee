/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Mapper;

import com.EShop.Model.ContentTag;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhatminh
 */
public class ContentTagMapper implements RowMapper<ContentTag>{
    
    @Override
    public ContentTag mapRow(ResultSet rs)
    {
        String id;
        try {
            id = rs.getString("ContentTagID");
            int name = rs.getInt("ContentID");
            ContentTag tag = new ContentTag(id,name);
            return tag;
        } catch (SQLException ex) {
            Logger.getLogger(ContentTagMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
