/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.EShop.Model.JSon;

import javax.json.Json;

/**
 *
 * @author nhatminh
 */
public class JSonService {
    
     DbConnection db = new DbConnection();
     Connection conn = db.getJDBCConnection();
     public List<JSon> GetAllJSon() throws SQLException
    {
        List<JSon> jsons= new ArrayList<JSon>();
        
        ResultSet rs = null;
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery="SELECT * FROM JSon";
        rs = stmt.executeQuery(sqlQuery);
        JSon json = null;
        while(rs.next())
        {   
             int id=rs.getInt("ID");
             String name = rs.getString("Name");
             json = new JSon(id,name);
             jsons.add(json);
        }
        rs.close();
        stmt.close();
        conn.close();
        return jsons;
    }  
     public void InsertJson(JSon json)throws SQLException
     {
        Statement statement = conn.createStatement();
        ResultSet rs= null;
        String sqlQuery="SELECT * FROM JSon WHERE ID="+json.getId();
        rs=statement.executeQuery(sqlQuery);
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
     public void UpdateJson(JSon json)throws SQLException
     {
        Statement statement = conn.createStatement();
        ResultSet rs= null;
        String sqlQuery="SELECT * FROM JSon WHERE ID="+json.getId();
        rs=statement.executeQuery(sqlQuery);
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
     
     public void DeleteJSon(JSon[] jsons) throws SQLException
     {
         Statement statement = conn.createStatement();
         ResultSet rs=null;
         for(int i=0;i<jsons.length;i++)
            {
                String sqlQuery ="SELECT * FROM JSon Where ID="+jsons[i].getId();
                rs=statement.executeQuery(sqlQuery);
                if(rs.next()!=false)
                {
                    sqlQuery="DELETE FROM JSon WHERE ID='"+rs.getInt("ID")+"';";
                    int rowCount=statement.executeUpdate(sqlQuery);
                }
            }
         
     }
     
}
