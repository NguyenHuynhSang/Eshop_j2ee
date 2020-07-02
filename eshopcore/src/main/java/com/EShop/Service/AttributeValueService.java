package com.EShop.Service;

import com.EShop.IService.IAttributeValueService;
import com.EShop.Model.AttributeValue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AttributeValueService implements IAttributeValueService {
    Connection conn = DbConnection.getJDBCConnection();
    @Override
    public List<AttributeValue> GetAttributeValue() throws SQLException {
        List<AttributeValue> attributes= new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery="SELECT * FROM AttributeValue";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while(rs.next())
        {
            AttributeValue attribute = new AttributeValue(
                    rs.getInt("ID"),
                    rs.getInt("AttributeID"),
                    rs.getString("Name"));
            attributes.add(attribute);
        }
        rs.close();
        stmt.close();
        conn.close();
        return attributes;
    }

    @Override
    public List<AttributeValue> GetAttributeValueByAtributeID(int id) throws SQLException {
        List<AttributeValue> attributes= new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery="select *\n" +
                "from AttributeValue\n" +
                "where AttributeID="+id;
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while(rs.next())
        {
            AttributeValue attribute = new AttributeValue(
                    rs.getInt("ID"),
                    rs.getInt("AttributeID"),
                    rs.getString("Name"));
            attributes.add(attribute);
        }
        rs.close();
        stmt.close();
        conn.close();
        return attributes;
    }

    @Override
    public void InsertAttributeValue(AttributeValue attribute) throws SQLException {

    }

    @Override
    public void UpdateAttributeValue(AttributeValue attribute) throws SQLException {

    }

    @Override
    public void DeleteAttributeValue(AttributeValue[] attribute) throws SQLException {

    }
}
