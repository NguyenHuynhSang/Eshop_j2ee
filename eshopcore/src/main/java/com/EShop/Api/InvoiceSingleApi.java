package com.EShop.Api;

import com.EShop.Filter.InvoiceFilter;
import com.EShop.Model.UserModel.Order;
import com.EShop.Service.OrderService;
import com.EShop.dto.admin.OrderListDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.mail.imap.protocol.ID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "InvoiceSingleApi", urlPatterns = {"/api/invoiceSingle"})
public class InvoiceSingleApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        OrderService service = new OrderService();
        Gson gson =new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
        int ID= Integer.parseInt(req.getParameter("ID"));

        PrintWriter printWriter = resp.getWriter();
        try {
           Order order =service.GetOrderDetail(ID);
            printWriter.print(gson.toJson(order));
        } catch (SQLException ex) {
            log(ex.toString());
        }




    }
}
