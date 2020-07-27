package com.EShop.Api.ClientApi;

import com.EShop.Filter.ProductClientFilter;
import com.EShop.Model.ViewModel.ProductDetailViewModel;
import com.EShop.Service.ProductService;
import com.google.gson.Gson;

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
@WebServlet(name = "ProductSingleApi", urlPatterns = {"/api/productSingle"})
public class ProductSingleApi extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        ProductService service = new ProductService();
        int ID= Integer.parseInt(req.getParameter("ID")) ;
        PrintWriter printWriter = resp.getWriter();
        String cover = "";
        Gson gson = new Gson();


        String js = req.getParameter("filterJson");

        ProductClientFilter filter = gson.fromJson(js, ProductClientFilter.class);


        try {
           ProductDetailViewModel productViewModel =service.GetProductVertionDetailByID(ID);
            printWriter.print(gson.toJson(productViewModel));

        } catch (SQLException ex) {
            log(ex.toString());
        }




    }
}
