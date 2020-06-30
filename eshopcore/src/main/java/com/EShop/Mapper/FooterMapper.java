/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Mapper;

import com.EShop.Model.Footer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhatminh
 */
public class FooterMapper implements RowMapper<Footer>{
    
    @Override
    public Footer mapRow(ResultSet rs)
    {
        int id;
        try {
            id = rs.getInt("ID");
            String name = rs.getString("Content");
            boolean status = rs.getBoolean("IsShow");
            Footer footer = new Footer(id,name,status);
            return footer;
        } catch (SQLException ex) {
            Logger.getLogger(FooterMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
