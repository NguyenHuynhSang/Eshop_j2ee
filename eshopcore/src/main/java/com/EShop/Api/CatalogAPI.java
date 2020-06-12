package com.EShop.Api;

import com.EShop.Model.Catalog;
import com.EShop.Model.JSon;
import com.EShop.Model.ViewModel.CatalogTreeModel;
import com.EShop.Model.ViewModel.CatalogViewModel;
import com.EShop.Service.CatalogService;
import com.EShop.Service.JSonService;
import com.EShop.Utills.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CatalogAPI", urlPatterns = {"/api/Catalog"})
public class CatalogAPI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        CatalogService catalogService = new CatalogService();
        String keyword = req.getParameter("keyword");
        String action = req.getParameter("action");
        String ID = req.getParameter("ID");
        Gson gson = new Gson();
        PrintWriter printWriter = resp.getWriter();
        JSon js = null;
        try {
            switch (action) {
                case "getAll":
                    List<CatalogViewModel> catalogs = new ArrayList<CatalogViewModel>();
                    catalogs = catalogService.GetCatalogs();
                    printWriter.print(gson.toJson(catalogs));
                    break;
                case "getTree":
                    List<CatalogTreeModel> catalogTree = new ArrayList<CatalogTreeModel>();
                    catalogTree = catalogService.GetCatalogsTree();
                    printWriter.print(gson.toJson(catalogTree));
                    break;
                case "getChild":
                    List<Catalog> childCatalogs = new ArrayList<Catalog>();
                    childCatalogs = catalogService.GetChildCatalogs();
                    printWriter.print(gson.toJson(childCatalogs));
                    break;
                case "getParents":
                    List<Catalog> parentCatalogs = new ArrayList<Catalog>();
                    parentCatalogs = catalogService.GetParentCatalogs();
                    printWriter.print(gson.toJson(parentCatalogs));
                    break;
                case "getByID":
                    break;


            }

        } catch (SQLException ex) {
            log(ex.toString());
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json"); //set kiểu dữ liệu trả về từ server là chuỗi json

        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
        CatalogService service = new CatalogService();

        String js = HttpUtil.of(req.getReader()); //request.getReader() dùng để lấy dữ liệu từ server
        Catalog json = gson.fromJson(js, Catalog.class);
        try {
            service.InsertCatalog(json);
        } catch (SQLException ex) {
            Logger.getLogger(JSonAPI.class.getName()).log(Level.SEVERE, null, ex);
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
