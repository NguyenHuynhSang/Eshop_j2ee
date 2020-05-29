package com.EShop.Api;

import com.EShop.Model.JSon;
import com.EShop.Model.ViewModel.CatalogViewModel;
import com.EShop.Service.CatalogService;
import com.EShop.Service.JSonService;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;

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

@WebServlet(name = "CatalogAPI", urlPatterns = {"/api/catalog"})
public class CatalogAPI  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        CatalogService catalogService = new CatalogService();

        String keyword = req.getParameter("keyword");
        String action = req.getParameter("action");
        String ID= req.getParameter("ID");

        Gson gson = new Gson();
        PrintWriter printWriter = resp.getWriter();
        JSon js=null;
        try {
            switch (action){
                case "getAll":
                    List<CatalogViewModel> catalogs = new ArrayList<CatalogViewModel>();
                        catalogs = catalogService.GetCatalogs();
                    printWriter.print(gson.toJson(catalogs));
                    break;
                case "getByID":
                    break;

            }

        } catch (SQLException ex) {

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
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
