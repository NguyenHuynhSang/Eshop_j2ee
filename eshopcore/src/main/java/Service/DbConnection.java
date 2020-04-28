
package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DbConnection {
    public static Connection getJDBCConnection()
    {
        String url = "jdbc:jtds:sqlserver://LAPTOP-6KVMDIF8:1433/TestJSon;instance=";
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
            e.printStackTrace();
        }
        
        return null;
    }
}
