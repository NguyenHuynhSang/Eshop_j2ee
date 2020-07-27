/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Mapper;

import com.EShop.Model.Footer;
import com.EShop.Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhatminh
 */
public class UserMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet rs)
    {
        int id;
        try {
            id = rs.getInt("ID");
            User user = new User();
            user.setID(rs.getInt("ID"));
            user.setUsername(rs.getString("Username"));
            user.setPassword(rs.getString("Password"));
            user.setName(rs.getString("Name"));
            user.setSex(rs.getString("Sex"));
            user.setAddress(rs.getString("Address"));
            user.setEmail(rs.getString("Email"));
            user.setPhone(rs.getString("Phone"));
            user.setUserGroupID(rs.getInt("UserGroupID"));
            user.setLock(rs.getBoolean("IsLock"));
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(FooterMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
