package com.EShop.Api.ClientApi;

import com.EShop.Filter.ProductClientFilter;
import com.EShop.Filter.ProductFilter;
import com.EShop.Model.Slide;
import com.EShop.Model.ViewModel.ProductDetailViewModel;
import com.EShop.Service.ClientService.HomeService;
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

@WebServlet(name = "ProductListApi", urlPatterns = {"/api/productList"})
public class ProductListApi extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        ProductService homeService = new ProductService();
        String action = req.getParameter("action");
        PrintWriter printWriter = resp.getWriter();
        String cover = "";
        Gson gson = new Gson();


        String js = req.getParameter("filterJson");

        ProductClientFilter filter = gson.fromJson(js, ProductClientFilter.class);


        try {
            List<ProductDetailViewModel> productViewModels = new ArrayList<ProductDetailViewModel>();
            productViewModels = homeService.GetListProductsByFilter(filter);
            printWriter.print(gson.toJson(productViewModels));

        } catch (SQLException ex) {
            log(ex.toString());
        }







    }
}
