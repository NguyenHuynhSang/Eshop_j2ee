package com.EShop.Service.ClientService;

import com.EShop.Model.UserModel.Order;
import com.EShop.Model.UserModel.OrderDetail;
import com.EShop.Service.DbConnection;
import com.EShop.Service.IService.IClientService.ICheckOutService;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.EShop.Contain.contain.ORDER_STATUS_CREATE;

public class CheckOutService implements ICheckOutService {

    Connection conn = DbConnection.getJDBCConnection();

    @Override
    public void CheckOut(Order order) throws SQLException {
        Statement statement;
        String sqlQuery = "SELECT * FROM [Order] WHERE ID=" + order.getID(); // check trùng
        ResultSet rs;
        conn.setAutoCommit(false);
        statement = conn.createStatement();

        String CreateDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(Calendar.getInstance().getTime());
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(Calendar.getInstance().getTime());
        order.setStatus(ORDER_STATUS_CREATE);
        rs = statement.executeQuery(sqlQuery);
        if (rs.next() == false) {

            sqlQuery = "Insert into [Order] (Note,CreatedDate,ShipName,ShipMobile,ShipAddress,ShipEmail,Status) \n" +
                    "values (?, ?, ?, ?,?,?,?)";
            PreparedStatement pStatement = conn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            //statement = conn.prepareStatement(sqlQuery);
            pStatement.setObject(1, order.getNote());
            pStatement.setObject(2, CreateDate);
            pStatement.setObject(3, order.getShipName());
            pStatement.setObject(4, order.getShipMobile());
            pStatement.setObject(5, order.getShipAddress());
            pStatement.setObject(6, order.getShipEmail());
            pStatement.setObject(7, order.getStatus());
            int rowCount = pStatement.executeUpdate();
            ResultSet rs_ver = pStatement.getGeneratedKeys();
            if (rs_ver.next()) {
                int orderID = Integer.parseInt(rs_ver.getObject(1).toString());
                for (OrderDetail item :
                        order.getOrderDetails()) {
                    sqlQuery = "Insert into OrderDetail (ProductVersionID,OrderID,Quantity,Price) \n" +
                            "values (?, ?, ?, ?)";
                    PreparedStatement cStatement = conn.prepareStatement(sqlQuery);
                    cStatement.setObject(1, item.getProductVerion().ProductVersion.getID());
                    cStatement.setObject(2, orderID);
                    cStatement.setObject(3, item.getQuantity());
                    cStatement.setInt(4, item.getPrice().intValue());
                    rowCount = cStatement.executeUpdate();
                    cStatement.close();
                }
                pStatement.close();
                conn.commit();
            } else {
                System.out.println("id da ton tai");
                conn.rollback();
            }
            rs.close();
            statement.close();
            conn.close();
        }
    }
}
