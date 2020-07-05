/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Mapper;

import com.EShop.Model.Slide;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhatminh
 */
public class SlideMapper implements RowMapper<Slide>{
    
    @Override
    public Slide mapRow(ResultSet rs)
    {
        int id;
        try {
            id = rs.getInt("ID");
            String Image = rs.getString("Image");
            boolean IsShow=rs.getBoolean("IsShow");
            Date CreateDate=rs.getDate("CreateDate");
            String CreateBy=rs.getString("CreateBy");
            Date ModifiedDate=rs.getDate("ModifiedDate");
            String ModifiedBy = rs.getString("ModifiedBy");
            String Url=rs.getString("Url");
            String Title = rs.getString("Title");
            String Content = rs.getString("Content");
            Slide tag = new Slide(id,Image,Url,IsShow,CreateBy,CreateDate,ModifiedBy,ModifiedDate,Title,Content);
            return tag;
        } catch (SQLException ex) {
            Logger.getLogger(SlideMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
