package com.EShop.Service;

import com.EShop.Model.Menu;
import com.EShop.Service.IService.IOrderService;
import com.EShop.dto.admin.OrderListDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderService {
    Connection conn = DbConnection.getJDBCConnection();
    @Override
    public List<OrderListDto> GetOrderListDto() throws SQLException {
        List<OrderListDto> orderListDtos = new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery = "use EShop\n" +
                "select o.ID,o.CreatedDate,o.Note,o.ShipName,o.ShipAddress,o.ShipEmail,o.ShipMobile,\n" +
                "o.Status,a.total\n" +
                "from [Order] o join\n" +
                "(select o1.ID,SUM(od.Price) as total\n" +
                "from [Order] o1\n" +
                "join OrderDetail od\n" +
                "on o1.ID =od.OrderID\n" +
                "group by o1.ID) as a\n" +
                "on a.ID=o.ID\n" +
                "order by o.CreatedDate desc";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            OrderListDto orderdto = new OrderListDto();
            orderdto.ID=rs.getInt("ID");
            orderdto.CreateDate=rs.getDate("CreatedDate");
            orderdto.ShipName=rs.getString("ShipName");
            orderdto.ShipEmail=rs.getString("ShipEmail");
            orderdto.ShipAddress=rs.getString("ShipAddress");
            orderdto.ShipMobile=rs.getString("ShipMobile");
            orderdto.Note=rs.getString("Note");
            orderdto.Status=rs.getInt("Status");
            orderdto.Total=rs.getInt("total");
            orderListDtos.add(orderdto);
        }
        rs.close();
        stmt.close();
        conn.close();
        return orderListDtos;
    }
}
