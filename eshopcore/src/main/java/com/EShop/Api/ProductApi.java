package com.EShop.Api;

import com.EShop.Model.InputModel.ProductInput;
import com.EShop.Model.ProductCatalog;
import com.EShop.Model.JSon;
import com.EShop.Model.Product;
import com.EShop.Model.ProductVersion;
import com.EShop.Model.ViewModel.CatalogTreeModel;
import com.EShop.Model.ViewModel.CatalogViewModel;
import com.EShop.Service.CatalogService;
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
import java.nio.channels.ScatteringByteChannel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ProductApi", urlPatterns = {"/api/Product"})
public class ProductApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        ProductService productService = new ProductService();
        String keyword = req.getParameter("keyword");
        String action = req.getParameter("action");
        String ID = req.getParameter("ID");
        Gson gson = new Gson();
        PrintWriter printWriter = resp.getWriter();
        JSon js = null;
        try {
            List<ProductVersion> productVersions = new ArrayList<ProductVersion>();
            productVersions = productService.GetProductAllVersionList();
            printWriter.print(gson.toJson(productVersions));
        } catch (SQLException ex) {
            log(ex.toString());
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json"); //set kiểu dữ liệu trả về từ server là chuỗi json

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
        PrintWriter printWriter = resp.getWriter();
        ProductService service = new ProductService();

        String js = HttpUtil.of(req.getReader());

        ProductInput product = gson.fromJson(js, ProductInput.class);

        try {
            service.InsertProduct(product);
            printWriter.print(js);
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}