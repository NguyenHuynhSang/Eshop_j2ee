package com.EShop.Service;

import com.EShop.IService.IClientService.IMenuService;
import com.EShop.Mapper.MenuMapper;
import com.EShop.Mapper.SlideMapper;
import com.EShop.Model.AttributeValue;
import com.EShop.Model.Menu;
import com.EShop.Model.Slide;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MenuService extends DbConnection<Menu>  implements IMenuService {
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

    @Override
    public List<Menu> GetMenu() throws SQLException
    {
        String sql="SELECT * FROM Menu";
        return query(sql,new MenuMapper());
    }

    public List<Menu> GetJSONByID(String ID) throws SQLException
    {
        int id = Integer.parseInt(ID);
        String sqlQuery = "SELECT * FROM Menu WHERE ID = ?";
        return query(sqlQuery,new MenuMapper(), id);
    }


    public List<Menu> GetAllMenuByKey(String key) throws SQLException {
        String sqlQuery;
        if (key != "") {
            try {
                sqlQuery = "select * from Menu  where ID= ? OR Link LIKE %?%";
                return query(sqlQuery,new MenuMapper(),key,key);
            } catch (NumberFormatException e) {
                sqlQuery = "select * from Menu where  Link LIKE ?";
                return query(sqlQuery, new MenuMapper(),key);
            }
        }
        return null;
    }

    public List<Menu> GetMenuActive() throws SQLException
    {
        String sqlQuery;
        sqlQuery = "select * from Link Where IsShow = 'true'";
        return query(sqlQuery,new MenuMapper());
    }

    @Override
    public void InsertMenu(Menu menu)throws SQLException
    {
        String sqlQuery="INSERT INTO Menu (Link,Text,DisplayOrder,Target,MenuGroupID,IsShow) Values(?,?,?,?,?,?)";
        Update(sqlQuery,menu.getLink(),menu.getText(),menu.getDisplayOrder(),menu.getTarget(),menu.getMenuGroupID(),menu.isShow());
    }


    @Override
    public void UpdateMenu(Menu menu)throws SQLException
    {
        String sqlQuery="UPDATE Menu SET Link = ?,Text = ?, DisplayOrder = ? , Target = ? , MenuGroupID = ? , IsShow = ? WHERE ID = ?";
        Update(sqlQuery,menu.getLink(),menu.getText(),menu.getDisplayOrder(),menu.getTarget(),menu.getMenuGroupID(),menu.isShow(),menu.getID());
    }
    @Override
    public void DeleteMenu(int id) throws SQLException
    {
        String sqlQuery = "Delete from Menu Where ID = ?";
        Update(sqlQuery, id);

    }

    public void SetActiveMenu(int id) throws SQLException
    {
        String sqlQuery;
        sqlQuery ="Update Menu Set IsShow ='true' where ID = ?";
        Update(sqlQuery,id);
    }

}
