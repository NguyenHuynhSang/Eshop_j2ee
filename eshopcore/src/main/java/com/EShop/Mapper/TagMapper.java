/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Mapper;

import com.EShop.Model.Tag;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhatminh
 */
public class TagMapper implements RowMapper<Tag>{
    
    @Override
    public Tag mapRow(ResultSet rs)
    {
        String id;
        try {
            id = rs.getString("ID");
            String name = rs.getString("TagtName");
            Tag tag = new Tag(id,name);
            return tag;
        } catch (SQLException ex) {
            Logger.getLogger(TagMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
