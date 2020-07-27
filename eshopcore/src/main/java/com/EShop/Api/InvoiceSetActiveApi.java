package com.EShop.Api;

import com.EShop.Filter.InvoiceFilter;
import com.EShop.Service.OrderService;
import com.EShop.dto.admin.OrderListDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
@WebServlet(name = "InvoiceSetActiveApi", urlPatterns = {"/api/invoiceActive"})
public class InvoiceSetActiveApi  extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        OrderService service = new OrderService();
        Gson gson =new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
        int ID = Integer.parseInt(req.getParameter("ID")) ;
        int Code = Integer.parseInt(req.getParameter("Code")) ;

        PrintWriter printWriter = resp.getWriter();
        try {
            service.AcviteOrder(ID,Code);
        } catch (SQLException ex) {
            log(ex.toString());
        }




    }
}
