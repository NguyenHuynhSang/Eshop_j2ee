/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.JSon;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author nhatminh
 */
public class JSonService {

    Connection conn = null;

    public List<JSon> GetAllJSon() throws SQLException {
        DbConnection db = new DbConnection();
        conn = db.getJDBCConnection();

        List<JSon> jsons = new ArrayList<JSon>();

        ResultSet rs = null;
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery = "SELECT * FROM JSon";
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
        return jsons;
    }
}
