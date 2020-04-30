/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Service;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.EShop.Model.JSon;
import com.EShop.IService.IJSonService;


/**
 *
 * @author nhatminh
 */
public class JSonService implements IJSonService{
     Connection conn = DbConnection.getJDBCConnection();
     @Override
     public List<JSon> GetAllJSon() throws SQLException
    {
        List<JSon> jsons= new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery="SELECT * FROM JSon";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while(rs.next())
        {   
             int id=rs.getInt("ID");
             String name = rs.getString("Name");
             JSon json = new JSon(id,name);
             jsons.add(json);
        }
        rs.close();
        stmt.close();
        conn.close();
        return jsons;
    }  
     @Override
     public void InsertJson(JSon json)throws SQLException
     {
        Statement statement;
        statement = conn.createStatement();
        String sqlQuery="SELECT * FROM JSon WHERE ID="+json.getId();
        ResultSet rs;
        rs = statement.executeQuery(sqlQuery);
        if (rs.next() == false)
        {
          sqlQuery="INSERT INTO JSon (ID, Name) VALUES ('"+json.getId()+"','"+json.getName()+"');";
          int rowCount=statement.executeUpdate(sqlQuery);
        }
        else
        {
            System.out.println("id da ton tai");
        }
        rs.close();
        statement.close();
        conn.close();
     }
     @Override
     public void UpdateJson(JSon json)throws SQLException
     {
        Statement statement;
        statement = conn.createStatement();
        String sqlQuery="SELECT * FROM JSon WHERE ID="+json.getId();
        ResultSet rs;
        rs = statement.executeQuery(sqlQuery);
        if (rs.next() == false)
        {
            System.out.println("khong tim thay doi tuong can sua");
        }
        else
        {
          sqlQuery="UPDATE JSon SET Name = '"+json.getName()+"' WHERE ID = '"+json.getId()+"';";
          int rowCount=statement.executeUpdate(sqlQuery);
        }
        rs.close();
        statement.close();
        conn.close();
     }
     @Override
     public void DeleteJSon(JSon[] jsons) throws SQLException
     {
         Statement statement = conn.createStatement();
         for (JSon json : jsons) {
             String sqlQuery = "SELECT * FROM JSon Where ID=" + json.getId();
             ResultSet rs=statement.executeQuery(sqlQuery);
             if(rs.next()!=false)
             {
                 sqlQuery="DELETE FROM JSon WHERE ID='"+rs.getInt("ID")+"';";
                 int rowCount=statement.executeUpdate(sqlQuery);
             }
         }
         
     }
     
}
