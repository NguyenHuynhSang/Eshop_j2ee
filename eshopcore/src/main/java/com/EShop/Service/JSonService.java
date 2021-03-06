
package com.EShop.Service;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.EShop.Model.JSon;
import com.EShop.Service.IService.IJSonService;

/**
 * @author nhatminh
 */
public class JSonService extends DbConnection<JSon> implements IJSonService{
    
     DbConnection db = new DbConnection();
     Connection conn = db.getJDBCConnection();
     public List<JSon> GetAllJSon() throws SQLException
    {
        List<JSon> jsons= new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery = "SELECT * FROM JSon";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        rs = stmt.executeQuery(sqlQuery);
        JSon json = null;
        while (rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("Name");
            json = new JSon(id, name);
            jsons.add(json);
        }
        return jsons;
    }


    public JSon GetJSONByID(int ID) throws SQLException
    {
        JSon json=null;
        List<JSon> jsons= new ArrayList<JSon>();

        ResultSet rs = null;
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery = "SELECT * FROM JSon WHERE  ID="+ID;
        rs = stmt.executeQuery(sqlQuery);

        while (rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("Name");
            json = new JSon(id, name);
        }
        return json;
    }

    public List<JSon> GetAllJSonByKey(String key) throws SQLException {
        DbConnection db = new DbConnection();
        conn = db.getJDBCConnection();

        List<JSon> jsons = new ArrayList<JSon>();

        ResultSet rs = null;
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery;
        if (key != "") {
            try {
                int intValue= Integer.parseInt(key);
                sqlQuery = "select * from JSon  where ID="+intValue+" OR Name LIKE " + "'%"+key+"%'";
            } catch (NumberFormatException e) {
                sqlQuery = "select *" + "from JSon" + " where  Name LIKE "+  "'%"+key+"%'";
            }


            rs = stmt.executeQuery(sqlQuery);
        }


        JSon json = null;
        while (rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("Name");
            json = new JSon(id, name);
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
     
     public void DeleteJSon(int id) throws SQLException
     {

         Statement statement = conn.createStatement();
         ResultSet rs= null;
         String sqlQuery="SELECT * FROM JSon WHERE ID="+id;
         rs=statement.executeQuery(sqlQuery);
         if (rs.next() == false)
         {
             System.out.println("khong tim thay doi tuong can sua");
         }
         else
         {
             sqlQuery="DELETE FROM JSon WHERE ID=" +id;
             int rowCount=statement.executeUpdate(sqlQuery);
         }
         rs.close();
         statement.close();
         conn.close();

     }
     
}
