package com.EShop.Api.ClientApi;

import com.EShop.Api.JSonAPI;
import com.EShop.Model.ProductCatalog;
import com.EShop.Model.UserModel.Order;
import com.EShop.Service.CatalogService;
import com.EShop.Service.ClientService.CheckOutService;
import com.EShop.Utills.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CheckOutApi", urlPatterns = {"/api/CheckOut"})
public class CheckOutApi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter printWriter = resp.getWriter();

        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
        CheckOutService service = new CheckOutService();

        String js = HttpUtil.of(req.getReader()); //request.getReader() dùng để lấy dữ liệu từ server
        Order order = gson.fromJson(js, Order.class);
        try {
            service.CheckOut(order);
            printWriter.print(order);
        } catch (SQLException ex) {
            Logger.getLogger(JSonAPI.class.getName()).log(Level.SEVERE, null, ex);
        }








    }
}
