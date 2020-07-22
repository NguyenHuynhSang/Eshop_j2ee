/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Mapper;

import com.EShop.Model.Menu;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhatminh
 */
public class MenuMapper implements RowMapper<Menu>{

    @Override
    public Menu mapRow(ResultSet rs)
    {
        int id;
        try {
            Menu menu = new Menu();
            menu.setID(rs.getInt("ID"));
            menu.setLink(rs.getString("Link"));
            menu.setText(rs.getString("Text"));
            menu.setDisplayOrder(rs.getInt("DisplayOrder"));
            menu.setTarget(rs.getString("Target"));
            menu.setMenuGroupID(rs.getInt("MenuGroupID"));
            menu.setShow(rs.getBoolean("IsShow"));
            return menu;
        } catch (SQLException ex) {
            Logger.getLogger(SlideMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
