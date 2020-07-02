package com.EShop.Service;

import com.EShop.IService.IAttributeService;
import com.EShop.Model.Attribute;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AttributeService implements IAttributeService {
    Connection conn = DbConnection.getJDBCConnection();
    @Override
    public List<Attribute> GetAttribute() throws SQLException {
        List<Attribute> attributes= new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery="SELECT * FROM Attribute";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while(rs.next())
        {
            Attribute attribute = new Attribute(
                    rs.getInt("ID"),
                    rs.getString("Name"));
            attributes.add(attribute);
        }
        rs.close();
        stmt.close();
        conn.close();
        return attributes;
    }

    @Override
    public void InsertAttribute(Attribute attribute) throws SQLException {
        Statement statement;
        statement = conn.createStatement();
        String sqlQuery="SELECT * FROM Attribute WHERE ID='"+attribute.getID()+"'";
        ResultSet rs;
        rs = statement.executeQuery(sqlQuery);
        if (rs.next() == false)
        {
            sqlQuery="INSERT INTO Attribute (ID, Name) VALUES ('"+attribute.getID()+"','"+attribute.getName()+"');";
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
    public void UpdateAttribute(Attribute attribute) throws SQLException {
        Statement statement;
        statement = conn.createStatement();
        String sqlQuery="SELECT * FROM Attribute WHERE ID="+attribute.getID();
        ResultSet rs;
        rs = statement.executeQuery(sqlQuery);
        if (rs.next() == false)
        {
            System.out.println("khong tim thay doi tuong can sua");
        }
        else
        {
            sqlQuery="UPDATE Attribute SET Name = '"+attribute.getName()+"' WHERE ID = '"+attribute.getID()+"';";
            int rowCount=statement.executeUpdate(sqlQuery);
        }
        rs.close();
        statement.close();
        conn.close();
    }

    @Override
    public void DeleteAttribute(Attribute[] attribute) throws SQLException {

    }
}
