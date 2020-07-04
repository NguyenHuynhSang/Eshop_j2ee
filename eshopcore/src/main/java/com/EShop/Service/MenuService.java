package com.EShop.Service;

import com.EShop.IService.IClientService.IMenuService;
import com.EShop.Model.AttributeValue;
import com.EShop.Model.Menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MenuService implements IMenuService {
    Connection conn = DbConnection.getJDBCConnection();

    @Override
    public List<Menu> GetListMenusByGroupId(int id) throws SQLException {
        List<Menu> menus = new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery = "select * from Menu\n" +
                "where   IsShow=1 and MenuGroupID=" +id+"\n"+
                "order by DisplayOrder asc";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            Menu menu = new Menu();
            menu.setLink(rs.getString("Link"));
            menu.setDisplayOrder(rs.getInt("DisplayOrder"));
            menu.setTarget(rs.getString("Target"));
            menu.setMenuGroupID(rs.getInt("MenuGroupID"));
            menu.setText(rs.getString("Text"));
            menu.setShow(rs.getBoolean("IsShow"));
            menus.add(menu);
        }
        rs.close();
        stmt.close();
        conn.close();
        return menus;
    }
}
