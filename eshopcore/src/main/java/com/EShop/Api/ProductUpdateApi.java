package com.EShop.Api;

import com.EShop.Filter.ProductFilter;
import com.EShop.Model.InputModel.ProductInput;
import com.EShop.Model.ProductVersion;
import com.EShop.Service.ProductService;
import com.EShop.Utills.HttpUtil;
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


@WebServlet(name = "ProductUpdateApi", urlPatterns = {"/api/productUpdate"})
public class ProductUpdateApi extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        ProductService productService = new ProductService();
        Gson gson = new Gson();
        int ID  = Integer.parseInt(req.getParameter("ID")) ;

        PrintWriter printWriter = resp.getWriter();
        try {

            ProductInput input = productService.GetProductInputForEdit(ID);
            //  resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            printWriter.print(gson.toJson(input));
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
        ProductService service = new ProductService();

        String js = HttpUtil.of(req.getReader());

        ProductInput product = gson.fromJson(js, ProductInput.class);

        try {
            service.UpdateProduct(product);
            printWriter.print(js);
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }





    }
}
