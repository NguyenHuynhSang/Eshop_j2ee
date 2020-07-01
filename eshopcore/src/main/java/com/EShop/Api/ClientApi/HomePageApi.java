package com.EShop.Api.ClientApi;

import com.EShop.Model.Attribute;
import com.EShop.Model.ProductCatalog;
import com.EShop.Model.Slide;
import com.EShop.Model.ViewModel.CatalogTreeModel;
import com.EShop.Model.ViewModel.CatalogViewModel;
import com.EShop.Service.CatalogService;
import com.EShop.Service.ClientService.HomeService;
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

@WebServlet(name = "HomePageApi", urlPatterns = {"/api/homePage"})
public class HomePageApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        HomeService homeService = new HomeService();
        String action = req.getParameter("action");
        PrintWriter printWriter=resp.getWriter();
        Gson gson=new Gson();
        try {
            switch (action) {
                case "getSlide":
                    List<Slide> slides = new ArrayList<Slide>();
                    slides = homeService.GetSlide();
                    String cover=gson.toJson(slides);
                    printWriter.print(gson.toJson(slides));
                    break;

            }

        } catch (SQLException ex) {
            log(ex.toString());
        }



    }
}

