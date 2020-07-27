package com.EShop.Service;

import com.EShop.Filter.InvoiceFilter;
import com.EShop.Model.Menu;
import com.EShop.Model.Product;
import com.EShop.Model.ProductVersion;
import com.EShop.Model.UserModel.Order;
import com.EShop.Model.UserModel.OrderDetail;
import com.EShop.Model.ViewModel.ProductDetailViewModel;
import com.EShop.Model.ViewModel.ProductViewModel;
import com.EShop.Service.IService.IOrderService;
import com.EShop.dto.admin.OrderListDto;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderService implements IOrderService {
    Connection conn = DbConnection.getJDBCConnection();

    @Override
    public List<OrderListDto> GetOrderListDto(InvoiceFilter filter) throws SQLException {
        List<OrderListDto> orderListDtos = new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();

        String qfitler = " ";
        DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;

        if (filter != null) {
            if (filter.ID != 0) {
                qfitler = "where o.ID=" + filter.ID;
            }
            if (filter.Status != 0) {
                qfitler = "where o.Status=" + filter.Status;
            }
            if (filter.customerName != null) {
                qfitler = "where o.ShipName like '%" + filter.customerName + "%'";
            }
            if (filter.email != null) {
                qfitler = "where o.ShipEmail like '%" + filter.email + "%'";
            }
            if (filter.customerPhone != null) {
                qfitler = "where o.ShipMobile like '%" + filter.customerPhone + "%'";
            }
            if (filter.fromPrice != 0 && filter.toPrice == 0) {
                qfitler = "where a.total>=" + filter.fromPrice;
            }
            if (filter.fromPrice == 0 && filter.toPrice != 0) {
                qfitler = "where a.total<=" + filter.toPrice;
            }
            if (filter.fromPrice != 0 && filter.toPrice != 0) {
                qfitler = "where a.total>=" + filter.fromPrice + " and a.total<=+filter.toPrice";
            }

            if (filter.fromDate != null && filter.toDate == null) {
                qfitler = "where o.CreatedDate>='" + filter.fromDate + "'";
            }
            if (filter.fromDate == null && filter.toDate != null) {

                qfitler = "where o.CreatedDate<='" + filter.toDate + "'";
            }
            if (filter.fromDate != null && filter.toDate != null) {

                qfitler = "where o.CreatedDate>='" + filter.fromDate + "' and o.CreatedDate<='" + filter.toDate + "'";
            }


        }

        String sqlQuery = "use EShop\n" +
                "select o.ID,o.CreatedDate,o.Note,o.ShipName,o.ShipAddress,o.ShipEmail,o.ShipMobile,\n" +
                "o.Status,a.total\n" +
                "from [Order] o join\n" +
                "(select o1.ID,SUM(od.Price*od.Quantity) as total\n" +
                "from [Order] o1\n" +
                "join OrderDetail od\n" +
                "on o1.ID =od.OrderID\n" +
                "group by o1.ID) as a\n" +
                "on a.ID=o.ID\n" + qfitler +
                " order by o.CreatedDate desc";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            OrderListDto orderdto = new OrderListDto();
            orderdto.ID = rs.getInt("ID");
            orderdto.CreateDate = rs.getDate("CreatedDate");
            orderdto.ShipName = rs.getString("ShipName");
            orderdto.ShipEmail = rs.getString("ShipEmail");
            orderdto.ShipAddress = rs.getString("ShipAddress");
            orderdto.ShipMobile = rs.getString("ShipMobile");
            orderdto.Note = rs.getString("Note");
            orderdto.Status = rs.getInt("Status");
            orderdto.Total = rs.getInt("total");
            orderListDtos.add(orderdto);
        }
        rs.close();
        stmt.close();
        conn.close();
        return orderListDtos;
    }

    @Override
    public Order GetOrderDetail(int id) throws SQLException {
        Order order = new Order();
        Statement stmt;
        stmt = conn.createStatement();

        String sqlQuery = "select *\n" +
                "from [Order] o\n" +
                "where o.ID=" + id;
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while (rs.next()) {

            order.setID(rs.getInt("ID"));
            order.setCreateDate(rs.getDate("CreatedDate"));
            order.setStatus(rs.getInt("Status"));
            order.setShipAddress(rs.getString("ShipAddress"));
            order.setShipEmail(rs.getString("ShipEmail"));
            order.setShipMobile(rs.getString("ShipMobile"));
            order.setShipName(rs.getString("ShipName"));
            order.setNote(rs.getString("Note"));

            sqlQuery = "select od.Price,od.Quantity,p.Name,ver.ID\n" +
                    "from [Order] o\n" +
                    "join  OrderDetail od\n" +
                    "on o.ID =od.OrderID\n" +
                    "join ProductVersions ver\n" +
                    "on ver.ID=od.ProductVersionID\n" +
                    "join Product p\n" +
                    "on p.ID =ver.ProductID\n" +
                    "where o.ID=" + id;
            Statement stm = conn.createStatement();
            ResultSet rrs = stm.executeQuery(sqlQuery);
            List<OrderDetail> orderDetails = new ArrayList<>();
            while (rrs.next()) {
                OrderDetail od = new OrderDetail();
                od.setPrice(rrs.getInt("Price"));
                od.setQuantity(rrs.getInt("Quantity"));
                ProductDetailViewModel p = new ProductDetailViewModel();
                p.Product = new Product();
                p.Product.setName(rrs.getString("Name"));
                p.ProductVersion = new ProductVersion();
                p.ProductVersion.setID(rrs.getInt("ID"));
                od.setProductVerion(p);
                orderDetails.add(od);
            }

            order.setOrderDetails(orderDetails);
            rrs.close();
            stm.close();
        }
        rs.close();
        stmt.close();
        conn.close();
        return order;
    }

    @Override
    public void AcviteOrder(int id, int code) throws SQLException {

        String q = "update [Order] SET Status=? \n" +
                "where ID=?6";
        PreparedStatement preparedStatement = conn.prepareStatement(q);

        preparedStatement.setInt(1, code);
        preparedStatement.setInt(2, id);
        int row = preparedStatement.executeUpdate();
        preparedStatement.close();
        conn.close();
    }
}
