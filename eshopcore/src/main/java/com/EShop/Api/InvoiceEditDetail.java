package com.EShop.Api;

import com.EShop.Model.InputModel.ProductInput;
import com.EShop.Model.UserModel.Order;
import com.EShop.Service.OrderService;
import com.EShop.Service.ProductService;
import com.EShop.Utills.HttpUtil;
import com.EShop.dto.admin.OrderInputDto;
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

@WebServlet(name = "InvoiceEditDetail", urlPatterns = {"/api/invoiceEdit"})
public class InvoiceEditDetail extends HttpServlet {
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
            OrderInputDto order =service.GetOrderByID(ID);
            printWriter.print(gson.toJson(order));
        } catch (SQLException ex) {
            log(ex.toString());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json"); //set kiểu dữ liệu trả về từ server là chuỗi json

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
        PrintWriter printWriter = resp.getWriter();
        OrderService service = new OrderService();
        String js = HttpUtil.of(req.getReader());
        OrderInputDto orderInputDto = gson.fromJson(js, OrderInputDto.class);

        try {
            service.UpdateOrder(orderInputDto);
            printWriter.print(js);
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }





    }
}
