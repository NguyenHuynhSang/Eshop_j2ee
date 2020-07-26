package com.EShop.Service;

import com.EShop.Service.IService.IDbConnection;
import com.EShop.Mapper.RowMapper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection<T> implements IDbConnection<T>{
    public static Connection getJDBCConnection()
    {

        String url = "jdbc:jtds:sqlserver://DESKTOP-0B8181F:1433/EShop;instance=SQLEXPRESS";
        String driver = "net.sourceforge.jtds.jdbc.Driver";
        String userName = "sa";
        String password = "123";
        try{
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            return DriverManager.getConnection(url,userName,password);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowmapper,Object... parameters)
    {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            connection = getJDBCConnection();
            statement = connection.prepareStatement(sql);
            setParameter(statement,parameters);
            rs = statement.executeQuery();
            while(rs.next())
            {
                results.add(rowmapper.mapRow(rs));
            }
            return results;
        }catch(SQLException e)
        {
            return null;
        } finally
        {
            try
            {
                if(connection!=null)
                {
                    connection.close();
                }
                if(statement!=null)
                {
                    statement.close();
                }
                if(rs!=null)
                {
                    rs.close();
                }
            }catch(SQLException e)
            {
                return null;
            }
        }
    }
    
    private void setParameter(PreparedStatement statement, Object... parameters)
    {
        for(int i=0; i< parameters.length; i++)
        {
            try{
                 Object parameter=parameters[i];
                 int index=i+1;
                 if(parameter instanceof Long)
                    statement.setLong(index, (Long)parameter);
                 else if(parameter instanceof String)
                    statement.setString(index, (String)parameter);
                 else if(parameter instanceof Integer)
                    statement.setInt(index, (Integer)parameter);
                 else if(parameter instanceof Timestamp)
                     statement.setTimestamp(index, (Timestamp)parameter);
                 else if(parameter == null)
                     statement.setNull(index, java.sql.Types.NULL);
                 else if(parameter instanceof Date)
                     statement.setDate(index, (Date)parameter);
                 else if(parameter instanceof Boolean)
                     statement.setBoolean(index, (Boolean)parameter);
            }catch(SQLException e) {
                e.printStackTrace();
            }
     
        }
    }

    @Override
    public void Update(String sql, Object... parameters) {
         Connection connection = null;
         PreparedStatement statement = null;
         try{
             connection = getJDBCConnection();
             connection.setAutoCommit(false);
             statement = connection.prepareStatement(sql);
             setParameter(statement,parameters);
             statement.executeUpdate();
             connection.commit();
         }catch(SQLException e)
         {
             try {
                if(connection!=null)
                     connection.rollback();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
         }finally{
             try{
                 if(connection!=null)
                     connection.close();
                 if(statement!=null)
                     statement.close();
             }catch(SQLException e1)
             {
                 e1.printStackTrace();
             }
         }
    }
}